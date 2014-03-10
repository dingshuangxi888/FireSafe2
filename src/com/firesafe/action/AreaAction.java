package com.firesafe.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Area;
import com.firesafe.service.AreaService;
import com.firesafe.util.s2sh.BaseAction;
import com.firesafe.util.s2sh.Pagination;

@Controller
@Namespace("/area")
@ParentPackage("struts-default")
public class AreaAction extends BaseAction {

	private static final long serialVersionUID = -5196716390304085635L;
	
	private int areaid;
	private List<Area> areas;
	private Area area;
	private AreaService areaService;
	private String parentname;
	private Pagination<Area> areapage;
	private int pageNo;
	
	
	public Pagination<Area> getAreapage() {
		return areapage;
	}
	public void setAreapage(Pagination<Area> areapage) {
		this.areapage = areapage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
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
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	
	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Action(value = "addInit", results = { @Result(name = "success", location = "/jsp/area/area_add.jsp") })
	public String addInit() {
		areas = areaService.findAll();
		for(int i=0;i<areas.size();i++){
			if(areas.get(i).getParentid()==null){
				areas.remove(i);
			}
		}
		return SUCCESS;
	}
	
	@Action(value = "add", results={@Result(name="success", location="view")})
	public String add() {
		area = areaService.save(area);
		this.areaid = area.getAreaid();
		return SUCCESS;
	}
	
	@Action(value = "view", results={@Result(name="success", location="/jsp/area/area_view.jsp")})
	public String view() {
		area = areaService.findById(areaid);
		if(area.getParentid()!=0){
			parentname = areaService.findById(area.getParentid()).getName();
		}	
		return SUCCESS;
	}
	
	@Action(value = "list", results={@Result(name="success", location="/jsp/area/area_list.jsp")})
	public String list() {
		areapage = areaService.findByPage(pageNo, 10);
		return SUCCESS;
	}
	
	@Action(value = "delete", results = { @Result(name = "success", type = "chain", location = "list") })
	public String delete() {
		areaService.deleteById(areaid);
		return SUCCESS;
	}

}
