package com.firesafe.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Area;
import com.firesafe.model.Authority;
import com.firesafe.model.Device;
import com.firesafe.model.Devstatus;
import com.firesafe.model.Role;
import com.firesafe.model.User;
import com.firesafe.service.AreaService;
import com.firesafe.service.DevstatusService;
import com.firesafe.service.RoleService;
import com.firesafe.service.UserService;
import com.firesafe.util.s2sh.BaseAction;
import com.firesafe.util.s2sh.Pagination;

@Controller
@Namespace("/user")
@ParentPackage("json-default")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = -3637813109604997902L;

	private User user;
	private UserService userService;
	private RoleService roleService;
	private AreaService areaService;
	private DevstatusService devstatusService;
	private int userid;
	private int pageNo;
	private Pagination<User> userpage;
	private List<Role> roles;
	private int roleid;
	private List<Area> areas;
	private List<Device> warndev;
	private List<Device> abnormaldev;

	public DevstatusService getDevstatusService() {
		return devstatusService;
	}

	public void setDevstatusService(DevstatusService devstatusService) {
		this.devstatusService = devstatusService;
	}

	public List<Device> getWarndev() {
		return warndev;
	}

	public void setWarndev(List<Device> warndev) {
		this.warndev = warndev;
	}

	public List<Device> getAbnormaldev() {
		return abnormaldev;
	}

	public void setAbnormaldev(List<Device> abnormaldev) {
		this.abnormaldev = abnormaldev;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Pagination<User> getUserpage() {
		return userpage;
	}

	public void setUserpage(Pagination<User> userpage) {
		this.userpage = userpage;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action(value = "login", results = { @Result(name = "success", location = "/jsp/common/home.jsp") })
	public String login() {
		if (userService.login(user)) {
			user = userService.findByProperty("username", user.getUsername()).get(0);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			Timestamp t = Timestamp.valueOf(time);
			user.setLastlogintime(t);
			userService.update(user);
			this.session.put("User", user);
			preparMenu();
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	@Action(value = "logout", results = { @Result(name = "success", location = "/jsp/common/login.jsp") })
	public String logout() {
		this.session.remove("User");
		this.session.remove("Menu");
		return SUCCESS;
	}

	@Action(value = "addInit", results = { @Result(name = "success", location = "/jsp/user/user_add.jsp") })
	public String addInit() {
		roles = roleService.findAllRole();
		areas = areaService.findAll();
		return SUCCESS;
	}

	@Action(value = "add", results = { @Result(name = "success",type = "chain", location = "view") })
	public String add() {
		Role role = roleService.findById(roleid);
		roles = new ArrayList<Role>();
		roles.add(role);
		Set<Role> roleset = new HashSet(roles);
		user.setRoles(roleset);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		Timestamp t = Timestamp.valueOf(time);
		user.setCreatetime(t);
		user.setLastlogintime(t);
		user = userService.save(user);
		this.userid = user.getUserid();
		return SUCCESS;
	}

	@Action(value = "modifyinit", results = { @Result(name = "success", location = "/jsp/user/user_modify.jsp") })
	public String modifyinit() {
		user = userService.findById(userid);
		return SUCCESS;
	}

	@Action(value = "modifySelf", results = { @Result(name = "success", location = "/jsp/user/user_modify.jsp") })
	public String modifySelf() {
		user = (User) this.session.get("User");
		return SUCCESS;
	}

	@Action(value = "modify", results = { @Result(name = "success", location = "/jsp/user/user_view.jsp") })
	public String modify() {
		userService.update(user);
		return SUCCESS;
	}

	@Action(value = "view", results = { @Result(name = "success", location = "/jsp/user/user_view.jsp") })
	public String view() {
		user = userService.findById(userid);
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", location = "/jsp/user/user_list.jsp") })
	public String list() {
		userpage = userService.findAllUser(pageNo, 10);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "chain", location = "list") })
	public String delete() {
		userService.deleteById(userid);
		return SUCCESS;
	}

	@Action(value = "preparPage", results = { @Result(name = "success", location = "/jsp/common/right.jsp") })
	public String preparPage() {
		User user = (User) this.session.get("User");
		warndev = new ArrayList<Device>();
		abnormaldev = new ArrayList<Device>();
		List<Device> tmpdev = new ArrayList<Device>();
		tmpdev = areaService.findDevice(user.getAreaid());
		for (int i = 0; i < tmpdev.size(); i++) {
			Devstatus devstatus = devstatusService.findById(tmpdev.get(i).getDeviceid());
			if (devstatus != null) {
				if (devstatus.getTemperature() >= 120) {
					tmpdev.get(i).setDevstatus(devstatus);
					warndev.add(tmpdev.get(i));
				} else if (devstatus.getTamper() != 0) {
					tmpdev.get(i).setDevstatus(devstatus);
					abnormaldev.add(tmpdev.get(i));
				}
			}
		}
		return SUCCESS;
	}

	public void preparMenu() {
		User user = (User) this.session.get("User");
		Iterator<Role> roles = user.getRoles().iterator();
		List<Authority> authoritis = new ArrayList<Authority>();
		while (roles.hasNext()) {
			authoritis.addAll(roles.next().getAuthorities());
		}
		this.session.put("Menu", authoritis);
	}
}
