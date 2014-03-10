package com.firesafe.model;

import java.sql.Timestamp;
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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "firesafe")
public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String password;
	private String name;
	private String phonenum;
	private String email;
	private String address;
	private Integer areaid;
	private Timestamp createtime;
	private Timestamp lastlogintime;
	private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, Timestamp createtime,
			Timestamp lastlogintime) {
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
	}

	public User(Integer userid, String username, String password, String name, String phonenum, String email, String address, Integer areaid, Timestamp createtime, Timestamp lastlogintime) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
		this.address = address;
		this.areaid = areaid;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.roles = roles;
	}

	/** full constructor */
	public User(String username, String password, String name, String phonenum,
			String email, String address, Integer areaid, Timestamp createtime,
			Timestamp lastlogintime, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
		this.address = address;
		this.areaid = areaid;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.roles = roles;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 15)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phonenum", length = 15)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "areaid")
	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "lastlogintime", nullable = false, length = 19)
	public Timestamp getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "userrole", catalog = "firesafe", joinColumns = { @JoinColumn(name = "userid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "roleid", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}