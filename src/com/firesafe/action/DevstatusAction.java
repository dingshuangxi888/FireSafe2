package com.firesafe.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.firesafe.util.s2sh.BaseAction;

@Controller
@Namespace("/devstatus")
@ParentPackage("struts-default")
public class DevstatusAction extends BaseAction {

	private static final long serialVersionUID = -4322272441124032763L;
}
