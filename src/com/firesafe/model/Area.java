package com.firesafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "area", catalog = "firesafe")
public class Area implements java.io.Serializable {

	// Fields

	private Integer areaid;
	private String name;
	private String remarks;
	private Integer parentid;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(String name) {
		this.name = name;
	}

	/** full constructor */
	public Area(String name, String remarks, Integer parentid) {
		this.name = name;
		this.remarks = remarks;
		this.parentid = parentid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "areaid", unique = true, nullable = false)
	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	@Column(name = "name", nullable = false, length = 20)
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

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

}