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

<title>主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBZDh63rJym1VeIn2wSbdFO_xCjlcnNq9M&sensor=false">
	
</script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/myjs/map2.js"></script>
</head>
<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr height="26px">
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" />
			</td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">欢迎界面</div>
						</td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top" background="images/mail_rightbg.gif"><img
				src="images/nav-right-bg.gif" width="16" height="29" />
			</td>
		</tr>
		<tr>
			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0"
					align="center" cellpadding="0" cellspacing="0" height="100%">
					<tr>
						<td width="100%"><table width="100%" height="100%">
								<tr>
									<td width="35%" height="100%" scope="col" valign="top"><table width="100%" height="144" border="0"
											cellpadding="0" cellspacing="0" class="line_table">
											<tr>
												<td width="7%" height="27"
													background="images/news-title-bg.gif"><img
													src="images/news-title-bg.gif" width="2" height="27">
												</td>
												<td width="93%" background="images/news-title-bg.gif"
													class="left_bt2">管理设备</td>
											</tr>
											<tr>
												<TD height="40" colspan="5" class="font42">
													<table width="100%" border="0" cellpadding="4"
														cellspacing="1" bgcolor="#464646" class="newfont03">
														<tr>
															<td height="20" colspan="5" bgcolor="#EEEEEE"
																class="tablestyle_title">
																<div align="center" style="font-size:16px">告警设备</div></td>
														</tr>
														<tr bgcolor="#EEEEEE">
															<td width="20%">设备编号</td>
															<td width="20%">设备名称</td>
															<td width="20%">温度</td>
															<td width="20%">最后一次更新时间</td>
															<td width="20%">操作</td>
														</tr>
														<s:iterator value="warndev" id="warndev">
															<tr bgcolor="#FFFFFF">
																<td><s:property value="#warndev.deviceid" />
																</td>
																<td><a href="device/view.action?deviceid=<s:property value="#warndev.deviceid" />"><s:property value="#warndev.name" /></a>
																</td>
																<td><s:property
																		value="#warndev.devstatus.temperature" /></td>
																<td><s:property
																		value="#warndev.devstatus.updatetime" /></td>
																<td><img
																	src="images/map/map256.png" height="16px" width="20px"
																	onclick="showOnMap(<s:property value="#warndev.deviceid" />);" /></td>
															</tr>
														</s:iterator>
													</table>
												</TD>
											</tr>
											<tr>
												<td height="20" colspan="5" width="100%"></td>
											</tr>
											<tr>
												<TD height="40" colspan="5" class="font42" style="overflow: auto">
													<table width="100%" border="0" cellpadding="4"
														cellspacing="1" bgcolor="#464646" class="newfont03">
														<tr>
															<td height="20" colspan="5" bgcolor="#EEEEEE"
																class="tablestyle_title">
																<div align="center" style="font-size:16px">异常设备</div></td>
														</tr>
														<tr bgcolor="#EEEEEE">
															<td width="20%">设备编号</td>
															<td width="20%">设备名称</td>
															<td width="20%">异常状态</td>
															<td width="20%">最后一次更新时间</td>
															<td width="20%">操作</td>
														</tr>
														<s:iterator value="abnormaldev" id="abnormaldev">
															<tr bgcolor="#FFFFFF">
																<td><s:property value="#abnormaldev.deviceid" />
																</td>
																<td><a href="device/view.action?deviceid=<s:property value="#abnormaldev.deviceid" />"><s:property value="#abnormaldev.name" /></a>
																</td>
																<td><s:property value="#abnormaldev.devstatus.tamper" />
																</td>
																<td><s:property
																		value="#abnormaldev.devstatus.updatetime" />
																</td>
																<td><img
																	src="images/map/map256.png" height="16px" width="20px"
																	onclick="showOnMap(<s:property value="#abnormaldev.deviceid" />);" /></td>
															</tr>
														</s:iterator>
													</table>
												</TD>
											</tr>
										</table></td>
										<td width="65%" height="100%"><div style="width: 100%; height: 100%" id="map-canvas-inner"></div></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</td>

			<td valign="middle" background="images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr height="17px">
			<td valign="bottom" background="images/mail_leftbg.gif"><img
				src="images/buttom_left2.gif" width="17" height="17" />
			</td>
			<td background="images/buttom_bgs.gif"><img
				src="images/buttom_bgs.gif" width="17" height="17">
			</td>
			<td valign="bottom" background="images/mail_rightbg.gif"><img
				src="images/buttom_right2.gif" width="16" height="17" />
			</td>
		</tr>
	</table>
</body>
</html>
