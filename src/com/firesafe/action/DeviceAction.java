package com.firesafe.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Area;
import com.firesafe.model.Device;
import com.firesafe.model.Devtype;
import com.firesafe.model.User;
import com.firesafe.service.AreaService;
import com.firesafe.service.DevconfigService;
import com.firesafe.service.DeviceService;
import com.firesafe.service.DevtypeService;
import com.firesafe.util.s2sh.BaseAction;
import com.firesafe.util.s2sh.Pagination;
import com.firesafe.vo.ConfigVO;
import com.firesafe.vo.DevConfigsVO;

@Controller
@Namespace("/device")
@ParentPackage("struts-default")
public class DeviceAction extends BaseAction {

	private static final long serialVersionUID = 2436451991581785265L;

	private DeviceService deviceService;
	private DevtypeService devtypeService;
	private DevconfigService devconfigService;
	private AreaService areaService;
	private int pageNo;
	private Pagination<Device> devpage;
	private long deviceid;
	private int areaid;
	private Device device;
	private List<Device> devices;
	private List<Devtype> devtypes;
	private List<Area> areas;
	private DevConfigsVO devconfigs;
	private ConfigVO config;

	@Action(value = "list", results = { @Result(name = "success", location = "/jsp/device/device_list.jsp") })
	public String list() {
//		devices = deviceService.findAll();
		User user = (User) this.session.get("User");
		int userareaid = user.getAreaid();
		if (areaid == 0 && areaid < userareaid) {
			areaid = userareaid;
		}
		devpage = deviceService.findByPageWithAreaid(pageNo, 10, areaid);
		areas = areaService.findChildArea(user.getAreaid());
		return SUCCESS;
	}

	@Action(value = "view", results = { @Result(name = "success", location = "/jsp/device/device_view.jsp") })
	public String view() {
		device = deviceService.findDeviceAllInfo(deviceid);
		devconfigs = devconfigService.getConfig(deviceid);
		return SUCCESS;
	}

	@Action(value = "modifyinit", results = { @Result(name = "success", location = "/jsp/device/device_modify.jsp") })
	public String modifyInit() {
		device = deviceService.findDeviceAllInfo(deviceid);
		devtypes = devtypeService.findAll();
		areas = areaService.findAll();
		devconfigs = devconfigService.getConfig(deviceid);
		return SUCCESS;
	}

	@Action(value = "modify", results = { @Result(name = "success", location = "/jsp/device/device_view.jsp") })
	public String modify() {
		System.out.println(device.getName());
		deviceService.update(device);
		device = deviceService.findDeviceAllInfo(device.getDeviceid());
		devtypes = devtypeService.findAll();
		areas = areaService.findAll();
		config.setName(device.getName());
		config.setDeviceid(device.getDeviceid());
		devconfigs = devconfigService.setConfig(config);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "chain", location = "list") })
	public String delete() {
		deviceService.deleteById(deviceid);
		return SUCCESS;
	}

	@Action(value = "addinit", results = { @Result(name = "success", location = "/jsp/device/device_add.jsp") })
	public String addInit() {
		devtypes = devtypeService.findAll();
		areas = areaService.findAll();
		return SUCCESS;
	}

	@Action(value = "add", results = { @Result(name = "success", type = "chain", location = "view") })
	public String add() {
		this.deviceid = device.getDeviceid();
		deviceService.saveOrUpdate(device);
		return SUCCESS;
	}

	@Resource
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Resource
	public void setDevtypeService(DevtypeService devtypeService) {
		this.devtypeService = devtypeService;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	@Resource
	public void setDevconfigService(DevconfigService devconfigService) {
		this.devconfigService = devconfigService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public List<Devtype> getDevtypes() {
		return devtypes;
	}

	public void setDevtypes(List<Devtype> devtypes) {
		this.devtypes = devtypes;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public DevConfigsVO getDevconfigs() {
		return devconfigs;
	}

	public void setDevconfigs(DevConfigsVO devconfigs) {
		this.devconfigs = devconfigs;
	}

	public ConfigVO getConfig() {
		return config;
	}

	public void setConfig(ConfigVO config) {
		this.config = config;
	}

	public Pagination<Device> getDevpage() {
		return devpage;
	}

	public void setDevpage(Pagination<Device> devpage) {
		this.devpage = devpage;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	
}
