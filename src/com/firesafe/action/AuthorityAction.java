package com.firesafe.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/authority")
@ParentPackage("struts-default")
public class AuthorityAction extends BaseAction {

	private static final long serialVersionUID = 8789590544701857652L;
		
}
