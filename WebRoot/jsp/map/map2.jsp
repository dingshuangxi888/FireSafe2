<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'map2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBZDh63rJym1VeIn2wSbdFO_xCjlcnNq9M&sensor=false">
	
</script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/myjs/map2.js"></script>
<script language="javascript" type="text/javascript"
	src="js/datepicker/WdatePicker.js"></script>

</head>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}

-->
.left {
	width: 25%;
	height: 98%;
	float: left;
	border: 1px solid;
}

.content {
	width: 70%;
	height: 98%;
	float: left;
	border: 1px solid;
}

.all {
	with: 100%;
	height: 100%;
}
</style>
<body>
	<div class="all">
		<div class="left" style="overflow-x: auto;overflow-x: auto;">
			<form name="showHistoryForm" id="showHistoryForm" method="post"
				onsubmit="showHistory(); return false;">
				<table id="mainpage" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="30"><table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td height="62" background="images/nav04.gif">
										<table width="98%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="21"><img src="images/ico07.gif" width="20"
													height="18" /></td>
												<td width="550">轨迹回放： <input type="hidden"
													name="deviceid"
													value="<s:property value="device.deviceid" />" /><input
													class="Wdate" name="start" type="text"
													onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})"><span
													class="newfont06">至</span> <input class="Wdate" name="end"
													type="text"
													onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
													<input name="Submit" type="submit" class="right-button02"
													value="查 询" />
												</td>
											</tr>
										</table>
										</td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td>
						<table id="subtree1" style="DISPLAY: " width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="95%" border="0" align="center"
											cellpadding="0" cellspacing="0">
											<tr>
												<TD height="40" class="font42">
													<table width="100%" border="0" cellpadding="4"
														cellspacing="1" bgcolor="#464646" class="newfont03">
														<tr>
															<td height="20" colspan="2" bgcolor="#EEEEEE"
																class="tablestyle_title">
																<div align="center" style="font-size:16px">设备详细信息</div>
															</td>
														</tr>
														<tr bgcolor="#FFFFFF" height="20">
															<td width="30%" align="right">设备编号:</td>
															<td width="70%"><s:property value="device.deviceid" />
															</td>
														</tr>
														<tr bgcolor="#FFFFFF">
															<td align="right">设备名称:</td>
															<td><a href="device/view.action?deviceid=<s:property value="device.deviceid" />"><s:property value="device.name" /></a>
															</td>
														</tr>
													</table></TD>
											</tr>
										</table>
										<table width="95%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="6"><img src="images/spacer.gif" width="1"
													height="1" />
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
												<td height="40" class="font42"><table id="history_table" width="100%"
														border="0" cellpadding="4" cellspacing="1"
														bgcolor="#464646" class="newfont03">
														<tr>
															<td height="20" colspan="14" align="center"
																bgcolor="#EEEEEE" class="tablestyle_title">轨迹回放列表</td>
														</tr>
														<tr>
															<td width="30%" align="center" bgcolor="#EEEEEE">时间</td>
															<td width="50%" height="20" align="center"
																bgcolor="#EEEEEE">地址</td>
															<td width="20%" align="center" bgcolor="#EEEEEE">操作</td>
														</tr>
														<s:iterator value="locations" id="location">
															<tr align="center" class="history_list">
																<td height="20" bgcolor="#FFFFFF"><s:property
																		value="#location.updatetime" />
																</td>
																<td bgcolor="#FFFFFF"><s:property
																		value="#location.address" />
																</td>
																<td bgcolor="#FFFFFF"><img
																	src="images/map/map256.png" height="16px" width="20px"
																	onclick="showOnMap(<s:property value="#location.deviceid" />);" />
																</td>
															</tr>
														</s:iterator>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="map-canvas-inner" class="content"></div>
	</div>
</body>

</html>
