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

<title>修改个人信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
</style>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<body class="ContentBody">
	<form action="device/modify.action" method="post"
		enctype="multipart/form-data" name="form">
		<div class="MainDiv">
			<input type="hidden" name="device.deviceid"
				value="<s:property value="device.deviceid" />" />
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">修改设备信息</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>设备信息修改</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td nowrap align="right" width="15%">设备编号:</td>
												<td width="35%"><s:property value="device.deviceid" /></td>
												<td width="16%" align="right" nowrap="nowrap">设备名称:</td>
												<td width="34%"><input type="text" name="device.name"
													value="<s:property value="device.name" />" /></td>
											</tr>
											<tr>
												<td nowrap align="right" width="15%">注册状态:</td>
												<td width="35%"><s:select list="#{1:'注册', 0:'注销'}"
														name="device.registered" listKey="key" listValue="value"
														value="device.registered"></s:select> <span class="red">*</span>
												</td>
												<td width="16%" align="right" nowrap="nowrap">设备类型:</td>
												<td width="34%"><s:select list="devtypes"
														name="device.typeid" listKey="typeid" listValue="name"
														value="device.typeid"></s:select> <span class="red">*</span>
												</td>
											</tr>
											<tr>
												<td nowrap align="right" width="15%">所在区域:</td>
												<td width="35%"><s:select list="areas"
														name="device.areaid" listKey="areaid" listValue="name"
														value="device.areaid"></s:select>
												</td>
												<td width="16%" align="right" nowrap="nowrap">备注:</td>
												<td width="34%"><textarea name="device.remarks">
												<s:property value="device.remarks" />
											</textarea></td>
											</tr>
										</table>
									</fieldset>
								</TD>
							</TR>

							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>设备参数修改</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td nowrap align="right" width="15%">目标精度（米）:</td>
												<td width="35%">
												<input type="hidden" name="config.apn" value="devconfigs.modified.tarcep" />
												<input type="text" name="config.tarcep"
													value="<s:property value="devconfigs.modified.tarcep" />" />
													<span style="color:red">(<s:property
															value="devconfigs.current.tarcep" />)</span>
												</td>
												<td width="16%" align="right" nowrap="nowrap">唤醒时间间隔:</td>
												<td width="34%"><input type="text" name="config.wkp"
													value="<s:property value="devconfigs.modified.wkp" />" />
													<span style="color:red">(<s:property
															value="devconfigs.current.wkp" />)</span> <span class="red">*</span></td>
											</tr>
											<tr>
												<td nowrap align="right" width="15%">GPS获取限时（秒）:</td>
												<td width="35%"><input type="text" name="config.tgps"
													value="<s:property value="devconfigs.modified.tgps" />" />
													<span style="color:red">(<s:property
															value="devconfigs.current.tgps" />)</span>
												</td>
												<td width="16%" align="right" nowrap="nowrap">服务器DNS:</td>
												<td width="34%"><input type="text" name="config.dns"
													value="<s:property value="devconfigs.modified.dns" />" />
													<span style="color:red">(<s:property
															value="devconfigs.current.dns" />)</span> <span class="red">*</span>
												</td>
											</tr>
											<tr>
												<td nowrap align="right" width="15%">端口号:</td>
												<td width="35%"><input type="text" name="config.prt"
													value="<s:property value="devconfigs.modified.prt" />" />
													<span style="color:red">(<s:property
															value="devconfigs.current.prt" />)</span> <span class="red">*</span>
												</td>
												<td nowrap align="right" width="15%"></td>
												<td width="35%"></td>
											</tr>
											<s:if test="devconfigs.current.tenbl != -1">
												<tr>
													<td width="16%" align="right" nowrap="nowrap">不动不报传感器:</td>
													<td width="34%"><s:select list="#{1:'开启', 0:'关闭'}"
															name="config.tenbl" listKey="key" listValue="value"
															value="devconfigs.modified.tenbl"></s:select> <span
														style="color:red">(<s:property
																value="devconfigs.current.tenbl" />)</span></td>
													<td nowrap align="right" width="15%"></td>
													<td width="35%"></td>
												</tr>
											</s:if>
											<s:else>
												<input type="hidden" name="config.tenbl" value="0">
											</s:else>
											<s:if test="devconfigs.current.e433 != -1">
												<tr>
													<td width="16%" align="right" nowrap="nowrap">433定位传感器:</td>
													<td width="34%"><s:select list="#{1:'开启', 0:'关闭'}" name="config.e433"
												listKey="key" listValue="value" value="devconfigs.modified.e433"></s:select>
												<span style="color:red">(<s:property
														value="devconfigs.current.e433" />)</span></td>
													<td nowrap align="right" width="15%"></td>
													<td width="35%"></td>
												</tr>
											</s:if>
											<s:else>
												<input type="hidden" name="config.e433" value="0">
											</s:else>
											<s:if test="devconfigs.current.tempenable != -1">
												<tr>
													<td width="16%" align="right" nowrap="nowrap">433定位传感器:</td>
													<td width="34%"><s:select list="#{1:'开启', 0:'关闭'}" name="config.tempenable"
												listKey="key" listValue="value" value="devconfigs.modified.tempenable"></s:select>
												<span style="color:red">(<s:property
														value="devconfigs.current.tempenable" />)</span></td>
													<td nowrap align="right" width="15%"></td>
													<td width="35%"></td>
												</tr>
											</s:if>
											<s:else>
												<input type="hidden" name="config.tempenable" value="0">
											</s:else>
											<s:if test="devconfigs.current.speedenable != -1">
												<tr>
													<td width="16%" align="right" nowrap="nowrap">速度传感器:</td>
													<td width="34%"><s:select list="#{1:'开启', 0:'关闭'}" name="config.speedenable"
												listKey="key" listValue="value" value="devconfigs.modified.speedenable"></s:select>
												<span style="color:red">(<s:property
														value="devconfigs.current.speedenable" />)</span></td>
													<td nowrap align="right" width="15%"></td>
													<td width="35%"></td>
												</tr>
											</s:if>
											<s:else>
												<input type="hidden" name="config.speedenable" value="0">
											</s:else>
										</table>
									</fieldset>
								</TD>
							</TR>
						</TABLE>
					</td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="保存" class="button" /> <input
						type="button" name="Submit2" value="返回" class="button"
						onclick="window.history.go(-1);" /></TD>
				</TR>
			</TABLE>
		</div>
	</form>
</body>
</html>
