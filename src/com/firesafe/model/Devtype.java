package com.firesafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Devtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "devtype", catalog = "firesafe")
public class Devtype implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String name;
	private String remarks;

	// Constructors

	/** default constructor */
	public Devtype() {
	}

	/** minimal constructor */
	public Devtype(String name) {
		this.name = name;
	}

	/** full constructor */
	public Devtype(String name, String remarks) {
		this.name = name;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "typeid", unique = true, nullable = false)
	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
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

}