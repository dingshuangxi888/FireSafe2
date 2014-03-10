package com.firesafe.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.model.Authority;
import com.firesafe.model.User;
import com.firesafe.util.s2sh.BaseAction;
import com.firesafe.vo.Menu;

@Controller
@Namespace("/session")
@ParentPackage("json-default")
public class SessionAction extends BaseAction {

	private static final long serialVersionUID = 7447952030504889215L;
	
    private List<Menu> menus;
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Action(value = "getMenu", results = { @Result(type = "json") })
	public String getMenu() {
		List<Authority> authorities = (List<Authority>) this.session.get("Menu");
		menus = new ArrayList<Menu>();	
		for(int i=0;i<authorities.size();i++){
			if(authorities.get(i).getAuthoritylevel()==1){
				Menu menu = new Menu();
				menu.setMenuid(authorities.get(i).getAuthorityid());
				menu.setMenuname(authorities.get(i).getName());
				menu.setMenuurl(authorities.get(i).getUrl());
				menus.add(menu);
			}
		}
		for(int i=0;i<menus.size();i++){
			List<Menu> menustmp = new ArrayList<Menu>();
				for(int j=0;j<authorities.size();j++){
					if(menus.get(i).getMenuid()==authorities.get(j).getParentid()){
						Menu menu = new Menu();
						menu.setMenuid(authorities.get(j).getAuthorityid());
					    menu.setMenuname(authorities.get(j).getName());
					    menu.setMenuurl(authorities.get(j).getUrl());
					    menustmp.add(menu);
					}
				}		
				menus.get(i).setMenus(menustmp);
		}
		return SUCCESS;
	}
	
	@Action(value = "getCurrentUser", results = { @Result(type = "json") })
	public String getCurrentUser() {
		user = (User) this.session.get("User");
		return SUCCESS;
	}

}