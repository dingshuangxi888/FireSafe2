package com.firesafe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Device entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "device", catalog = "firesafe")
public class Device implements java.io.Serializable {

	// Fields

	private Long deviceid;
	private String name;
	private String remarks;
	private Integer areaid;
	private Integer typeid;
	private Integer registered;

	private Devstatus devstatus;
	private Devtype devtype;
	private Area area;
	private List<Location> locations;

	// Constructors

	/** default constructor */
	public Device() {
	}

	/** minimal constructor */
	public Device(Long deviceid, Integer registered) {
		this.deviceid = deviceid;
		this.registered = registered;
	}

	/** full constructor */
	public Device(Long deviceid, String name, String remarks, Integer areaid,
			Integer typeid, Integer registered) {
		this.deviceid = deviceid;
		this.name = name;
		this.remarks = remarks;
		this.areaid = areaid;
		this.typeid = typeid;
		this.registered = registered;
	}

	// Property accessors
	@Id
	@Column(name = "deviceid", unique = true, nullable = false)
	public Long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(Long deviceid) {
		this.deviceid = deviceid;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "areaid")
	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	@Column(name = "typeid")
	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Column(name = "registered", nullable = false)
	public Integer getRegistered() {
		return this.registered;
	}

	public void setRegistered(Integer registered) {
		this.registered = registered;
	}

	@Transient
	public Devstatus getDevstatus() {
		return devstatus;
	}

	public void setDevstatus(Devstatus devstatus) {
		this.devstatus = devstatus;
	}

	@Transient
	public Devtype getDevtype() {
		return devtype;
	}

	public void setDevtype(Devtype devtype) {
		this.devtype = devtype;
	}

	@Transient
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Transient
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}