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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "firesafe")
public class Role implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String name;
	private String remarks;
	private Set<User> users = new HashSet<User>(0);
	private Set<Authority> authorities = new HashSet<Authority>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name) {
		this.name = name;
	}
	
	public Role(Integer roleid, String name, String remarks) {
		this.roleid = roleid;
		this.name = name;
		this.remarks = remarks;
	}

	/** full constructor */
	public Role(String name, String remarks, Set<User> users,
			Set<Authority> authorities) {
		this.name = name;
		this.remarks = remarks;
		this.users = users;
		this.authorities = authorities;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "roleauthority", catalog = "firesafe", joinColumns = { @JoinColumn(name = "roleid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authorityid", nullable = false, updatable = false) })
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}