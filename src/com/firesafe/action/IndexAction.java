package com.firesafe.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class IndexAction extends BaseAction {

	@Action(value = "index", results = { @Result(name = "success", location = "/jsp/common/login.jsp") })
	public String index() {
		return SUCCESS;
	}
}
