package com.firesafe.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/role")
@ParentPackage("struts-default")
public class RoleAction extends BaseAction {

	private static final long serialVersionUID = -5196716390304085635L;
}
