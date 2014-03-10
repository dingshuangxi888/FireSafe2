<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21">
										当前位置：用户管理>用户列表
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">用户信息列表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">用户编号</td>
													<td width="20%">用户名</td>
													<td width="20%">真实姓名</td>
													<td width="20%">上一次登陆时间</td>
													<td width="20%">操作</td>
												</tr>
												<s:iterator value="userpage.list" id="user">
													<tr bgcolor="#FFFFFF">
														<td><s:property	value="#user.userid" />
														</td>
														<td><s:property value="#user.username" />
														</td>
														<td><s:property value="#user.name" />
														</td>
														<td><s:property value="#user.lastlogintime" />
														</td>
														<td><a href="user/view.action?userid=<s:property value="#user.userid" />">查看|</a><a
															href="user/modifyinit.action?userid=<s:property value="#user.userid" />">编辑|</a><a
															href="user/delete.action?userid=<s:property value="#user.userid" />">删除</a>
														</td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="6"><img src="images/spacer.gif" width="1"
											height="1" />
										</td>
									</tr>
									<tr>
										<td height="33"><table width="100%" border="0"
												align="center" cellpadding="0" cellspacing="0"
												class="right-font08">
												<tr>
													<td width="50%">共 <span class="right-text09"><s:property value="userpage.totalPage" /></span>
														页 | 第 <span class="right-text09"><s:property value="userpage.pageNo" /></span> 页</td>
													<td width="49%" align="right">[<a href="user/list.action?pageNo=1"
														class="right-font08">首页</a> | <a href="user/list.action?pageNo=<s:property value="userpage.prePage" />"
														class="right-font08">上一页</a> | <a href="user/list.action?pageNo=<s:property value="userpage.nextPage" />"
														class="right-font08">下一页</a> | <a href="user/list.action?pageNo=<s:property value="userpage.totalPage" />"
														class="right-font08">末页</a>] 转至：</td>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
															<form action="device/list.action" method="post">
																<td width="1%"><input name="pageNo" type="text"
																	class="right-textfield03" size="1" />
																</td>
																<td width="87%"><input name="Submit23222"
																	type="submit" class="right-button06" value=" " /></td>
															</tr>
															</form>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
