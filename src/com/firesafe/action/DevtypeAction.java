package com.firesafe.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Device;
import com.firesafe.model.Devtype;
import com.firesafe.service.DevtypeService;
import com.firesafe.util.s2sh.BaseAction;
import com.firesafe.util.s2sh.Pagination;

@Controller
@Namespace("/devtype")
@ParentPackage("struts-default")
public class DevtypeAction extends BaseAction {

	private static final long serialVersionUID = -7317924472604058150L;

	private DevtypeService devtypeService;

	private List<Devtype> devtypes;
	private int typeid;
	private Devtype devtype;
	private int pageNo;
	private Pagination<Device> devtypepage;

	@Action(value = "list", results = { @Result(name = "success", location = "/jsp/devtype/devtype_list.jsp") })
	public String list() {
//		devtypes = devtypeService.findAll();
		devtypepage = devtypeService.findByPage(pageNo, 10);
		return SUCCESS;
	}
	
	@Action(value = "view", results = { @Result(name = "success", location = "/jsp/devtype/devtype_view.jsp") })
	public String view() {
		devtype = devtypeService.findById(typeid);
		return SUCCESS;
	}

	@Action(value = "modifyinit", results = { @Result(name = "success", location = "/jsp/devtype/devtype_modify.jsp") })
	public String modifyInit() {
		devtype = devtypeService.findById(typeid);
		return SUCCESS;
	}

	@Action(value = "modify", results = { @Result(name = "success", location = "/jsp/devtype/devtype_view.jsp") })
	public String modify() {
		devtypeService.update(devtype);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "chain", location = "list") })
	public String delete() {
		devtypeService.deleteById(typeid);
		return SUCCESS;
	}

	@Action(value = "addinit", results = { @Result(name = "success", location = "/jsp/devtype/devtype_add.jsp") })
	public String addInit() {
		return SUCCESS;
	}

	@Action(value = "add", results = { @Result(name = "success", type = "chain", location = "view") })
	public String add() {
		devtype = devtypeService.save(devtype);
		this.typeid = devtype.getTypeid();
		return SUCCESS;
	}

	@Resource
	public void setDevtypeService(DevtypeService devtypeService) {
		this.devtypeService = devtypeService;
	}

	public List<Devtype> getDevtypes() {
		return devtypes;
	}

	public void setDevtypes(List<Devtype> devtypes) {
		this.devtypes = devtypes;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public Devtype getDevtype() {
		return devtype;
	}

	public void setDevtype(Devtype devtype) {
		this.devtype = devtype;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Pagination<Device> getDevtypepage() {
		return devtypepage;
	}

	public void setDevtypepage(Pagination<Device> devtypepage) {
		this.devtypepage = devtypepage;
	}

}
