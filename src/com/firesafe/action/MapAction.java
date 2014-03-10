package com.firesafe.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Area;
import com.firesafe.model.Device;
import com.firesafe.model.Location;
import com.firesafe.service.AreaService;
import com.firesafe.service.DeviceService;
import com.firesafe.service.LocationService;
import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/map")
@ParentPackage("json-default")
public class MapAction extends BaseAction {

	private static final long serialVersionUID = -45189957238414940L;

	private AreaService areaService;
	private DeviceService deviceService;
	private LocationService locationService;
	private List<Area> areas;
	private int areaid;
	private long deviceid;
	private List<Device> devices;
	private Device device;
	private List<Location> locations;

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	@Resource
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Resource
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@Action(value = "show", results = { @Result(name = "success", location = "/jsp/map/map.jsp") })
	public String show() {
		areas = areaService.findAll();
		return SUCCESS;
	}

	@Action(value = "devices", results = { @Result(type = "json") })
	public String devices() {
//		System.out.println(areaid);
		devices = areaService.findDevice(areaid);
		return SUCCESS;
	}
	@Action(value = "showdevice", results = { @Result(name = "success", location = "/jsp/map/map2.jsp") })
	public String showDevice() {
		device = deviceService.findById(deviceid);
		locations = new ArrayList<Location>();
		Location location = locationService.findLastLoction(deviceid);
		if (location != null) {
			locations.add(location);
		}
		return SUCCESS;
	}
}
