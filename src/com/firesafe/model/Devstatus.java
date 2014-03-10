package com.firesafe.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Devstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "devstatus", catalog = "firesafe")
public class Devstatus implements java.io.Serializable {

	// Fields

	private Long deviceid;
	private Integer bl;
	private Integer tamper;
	private Integer temperature;
	private Timestamp updatetime;

	// Constructors

	/** default constructor */
	public Devstatus() {
	}

	/** minimal constructor */
	public Devstatus(Long deviceid) {
		this.deviceid = deviceid;
	}

	/** full constructor */
	public Devstatus(Long deviceid, Integer bl, Integer tamper,
			Integer temperature, Timestamp updatetime) {
		this.deviceid = deviceid;
		this.bl = bl;
		this.tamper = tamper;
		this.temperature = temperature;
		this.updatetime = updatetime;
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

	@Column(name = "bl")
	public Integer getBl() {
		return this.bl;
	}

	public void setBl(Integer bl) {
		this.bl = bl;
	}

	@Column(name = "tamper")
	public Integer getTamper() {
		return this.tamper;
	}

	public void setTamper(Integer tamper) {
		this.tamper = tamper;
	}

	@Column(name = "temperature")
	public Integer getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	
	@Column(name = "updatetime", nullable = false, length = 19)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}