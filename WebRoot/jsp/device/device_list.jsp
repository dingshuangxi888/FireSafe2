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

<title>My JSP 'device_list_2.jsp' starting page</title>

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

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="62" background="images/nav04.gif">
							<form name="form" id="form" method="post"
								action="device/list.action">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="24"><img src="images/ico07.gif" width="20"
											height="18" />
										</td>
										<td width="519">当前位置：设备管理 > 设备列表<label>设备类型: 
										<s:select list="areas" name="areaid" listKey="areaid" listValue="name" value="areaid"></s:select>
										</label><input
											type="hidden" name="pageNo" value="1"> <input
											name="Submit" type="submit" class="right-button02"
											value="查 询" />
										</td>
										<td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
								</table>
							</form></td>
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
										<table width="100%" border="0" cellpadding="4" cellspacing="1"
											bgcolor="#464646" class="newfont03">
											<tr class="CTitle">
												<td height="22" colspan="7" align="center"
													style="font-size:16px">设备信息列表</td>
											</tr>
											<tr bgcolor="#EEEEEE">
												<td width="25%">设备编号</td>
												<td width="25%">设备名称</td>
												<td width="25%">状态</td>
												<td width="25%">操作</td>
											</tr>
											<s:iterator value="devpage.list" id="device">
												<tr bgcolor="#FFFFFF">
													<td><a href="listmokuaimingxi.htm" onclick=""></a> <s:property
															value="#device.deviceid" /></td>
													<td><s:property value="#device.name" /></td>
													<td><s:property value="#device.registered" /></td>
													<td>
													<a href="device/view.action?deviceid=<s:property value="#device.deviceid" />">查看|</a>
													<a href="device/modifyinit.action?deviceid=<s:property value="#device.deviceid" />">编辑|</a>
													<a href="device/delete.action?deviceid=<s:property value="#device.deviceid" />&areaid=<s:property value="areaid" />">删除|</a>
													<a href="map/showdevice.action?deviceid=<s:property value="#device.deviceid" />"><img src="images/map/map256.png" height="16px" width="20px" /></a>
													</td>
												</tr>
											</s:iterator>
										</table></td>
								</tr>
							</table>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="6"><img src="images/spacer.gif" width="1"
										height="1" /></td>
								</tr>
								<tr>
									<td height="33"><table width="100%" border="0"
											align="center" cellpadding="0" cellspacing="0"
											class="right-font08">
											<tr>
												<td width="50%">共 <span class="right-text09"><s:property
															value="devpage.totalPage" /> </span> 页 | 第 <span
													class="right-text09"><s:property
															value="devpage.pageNo" /> </span> 页</td>
												<td width="49%" align="right">[<a
													href="device/list.action?pageNo=1&areaid=<s:property value="areaid" />"
													class="right-font08">首页</a> | <a
													href="device/list.action?pageNo=<s:property value="devpage.prePage" />&areaid=<s:property value="areaid" />"
													class="right-font08">上一页</a> | <a
													href="device/list.action?pageNo=<s:property value="devpage.nextPage" />&areaid=<s:property value="areaid" />"
													class="right-font08">下一页</a> | <a
													href="device/list.action?pageNo=<s:property value="devpage.totalPage" />&areaid=<s:property value="areaid" />"
													class="right-font08">末页</a>] 转至：</td>
												<td width="1%"><table width="20" border="0"
														cellspacing="0" cellpadding="0">
														<form action="device/list.action" method="post">
															<tr>
																<td width="1%"><input name="pageNo" type="text"
																	class="right-textfield03" size="1" /> <input
																	name="areaid" type="hidden"
																	value="<s:property value="areaid" />" /></td>
																<td width="87%"><input name="Submit23222"
																	type="submit" class="right-button06" value=" " /></td>
															</tr>
														</form>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
