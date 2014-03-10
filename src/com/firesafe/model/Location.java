package com.firesafe.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "location", catalog = "firesafe")
public class Location implements java.io.Serializable {

	// Fields

	private Integer locid;
	private Long deviceid;
	private Float lat;
	private Float lng;
	private Integer alt;
	private Integer cep;
	private String address;
	private Float offsetlat;
	private Float offsetlng;
	private Timestamp updatetime;

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** minimal constructor */
	public Location(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	/** full constructor */
	public Location(Long deviceid, Float lat, Float lng, Integer alt,
			Integer cep, String address, Float offsetlat, Float offsetlng,
			Timestamp updatetime) {
		this.deviceid = deviceid;
		this.lat = lat;
		this.lng = lng;
		this.alt = alt;
		this.cep = cep;
		this.address = address;
		this.offsetlat = offsetlat;
		this.offsetlng = offsetlng;
		this.updatetime = updatetime;
	}

	public Location(Long deviceid, Float lat, Float lng, Integer alt,
			Integer cep, Timestamp updatetime) {
		this.deviceid = deviceid;
		this.lat = lat;
		this.lng = lng;
		this.alt = alt;
		this.cep = cep;
		this.updatetime = updatetime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "locid", unique = true, nullable = false)
	public Integer getLocid() {
		return this.locid;
	}

	public void setLocid(Integer locid) {
		this.locid = locid;
	}

	@Column(name = "deviceid")
	public Long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(Long deviceid) {
		this.deviceid = deviceid;
	}

	@Column(name = "lat", precision = 10, scale = 7)
	public Float getLat() {
		return this.lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	@Column(name = "lng", precision = 10, scale = 7)
	public Float getLng() {
		return this.lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	@Column(name = "alt")
	public Integer getAlt() {
		return this.alt;
	}

	public void setAlt(Integer alt) {
		this.alt = alt;
	}

	@Column(name = "cep")
	public Integer getCep() {
		return this.cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "offsetlat", precision = 10, scale = 7)
	public Float getOffsetlat() {
		return this.offsetlat;
	}

	public void setOffsetlat(Float offsetlat) {
		this.offsetlat = offsetlat;
	}

	@Column(name = "offsetlng", precision = 10, scale = 7)
	public Float getOffsetlng() {
		return this.offsetlng;
	}

	public void setOffsetlng(Float offsetlng) {
		this.offsetlng = offsetlng;
	}

	@Column(name = "updatetime", nullable = false, length = 19)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}