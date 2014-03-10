package com.firesafe.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Location;
import com.firesafe.service.LocationService;
import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/location")
@ParentPackage("json-default")
public class LocationAction extends BaseAction {

	private static final long serialVersionUID = 122185084353697331L;

	private LocationService locationService;
	private long deviceid;
	private Location location;
	private String start;
	private String end;
	private List<Location> locations;

	@Action(value = "loc", results = { @Result(type = "json") })
	public String loc() {
		location = locationService.findLastLoction(deviceid);
		return SUCCESS;
	}
	
	@Action(value = "history", results = { @Result(type = "json") })
	public String history() {
		locations = locationService.findHistory(deviceid, start, end);
		return SUCCESS;
	}

	@Resource
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
