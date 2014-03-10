package com.firesafe.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "authority", catalog = "firesafe")
public class Authority implements java.io.Serializable {

	// Fields

	private Integer authorityid;
	private String name;
	private Integer authoritylevel;
	private Integer parentid;
	private String url;
	private String remarks;
	private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** minimal constructor */
	public Authority(String name) {
		this.name = name;
	}

	/** full constructor */
	public Authority(String name, Integer authoritylevel, Integer parentid,
			String url, String remarks, Set<Role> roles) {
		this.name = name;
		this.authoritylevel = authoritylevel;
		this.parentid = parentid;
		this.url = url;
		this.remarks = remarks;
		this.roles = roles;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "authorityid", unique = true, nullable = false)
	public Integer getAuthorityid() {
		return this.authorityid;
	}

	public void setAuthorityid(Integer authorityid) {
		this.authorityid = authorityid;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "authoritylevel")
	public Integer getAuthoritylevel() {
		return this.authoritylevel;
	}

	public void setAuthoritylevel(Integer authoritylevel) {
		this.authoritylevel = authoritylevel;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "url", length = 45)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "remarks", length = 20)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authorities")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}