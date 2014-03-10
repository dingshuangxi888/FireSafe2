package com.firesafe.ws;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import com.firesafe.model.Devstatus;
import com.firesafe.model.Location;
import com.firesafe.service.DevstatusService;
import com.firesafe.service.LocationService;
import com.firesafe.util.DataTimeUtil;
import com.google.gson.Gson;

@Component
@Path("/")
public class LocoWebService {
	static final Logger logger = Logger.getLogger(LocoWebService.class);

	private OffsetService offsetService;
	private GeoService geoService;
	
	private LocationService locationService;
	private DevstatusService devstatusService;
	
	@Path("loco")
	@POST
	public String loco(@FormParam("param") JSONObject param) {
		logger.info("Data From push service :" + param.toString());
		Gson gson = new Gson();
		LocoVO loco = gson.fromJson(param.toString(), LocoVO.class);
		
		Location location = new Location(loco.getImsi(), (float)loco.getLat(), (float)loco.getLon(), (int)loco.getAlt(), (int)loco.getCep(), DataTimeUtil.toTimestamp(loco.getTime()));
		double[] offset = offsetService.getOffset((float)loco.getLat(), (float)loco.getLon());
		location.setOffsetlat((float)offset[0]);
		location.setOffsetlng((float)offset[1]);
		String address = geoService.getGeo((float)loco.getLat(), (float)loco.getLon());
		address = address.replace("\r\n", "");
		location.setAddress(address);
		locationService.save(location);
		
		Devstatus devstatus = new Devstatus(loco.getImsi(), (int)loco.getBl(), (int)loco.getTamper(), (int)loco.getTemperature(), DataTimeUtil.toTimestamp(loco.getTime()));
		devstatusService.saveOrUpdate(devstatus);
		
		return "OK";
	}
	
	@Resource
	public void setOffsetService(OffsetService offsetService) {
		this.offsetService = offsetService;
	}

	@Resource
	public void setGeoService(GeoService geoService) {
		this.geoService = geoService;
	}

	@Resource
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@Resource
	public void setDevstatusService(DevstatusService devstatusService) {
		this.devstatusService = devstatusService;
	}
}
