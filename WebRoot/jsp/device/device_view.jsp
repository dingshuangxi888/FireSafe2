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

<title>设备详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<form name="user" id="fom" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
												<!-- 设备详细信息 -->
												<tr>
													<td height="20" colspan="2" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">设备详细信息</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">设备编号:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.deviceid" />
													</td>
												</tr>
												<tr>
													<td width="16%" height="20" align="right" bgcolor="#FFFFFF">设备名称:</td>
													<td width="84%" colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.name" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">设备类型:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.devtype.name" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">设备区域:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.area.name" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">设备描述:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.remarks" />
													</td>
												</tr>

												<!-- 位置信息 -->
												<tr>
													<td height="20" colspan="2" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">位置信息</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">经度:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].lng" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">纬度:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].lat" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">高度:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].alt" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">精度:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].cep" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">地址:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].address" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">更新时间:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.locations[0].updatetime" />
													</td>
												</tr>

												<!-- 设备状态 -->
												<tr>
													<td height="20" colspan="2" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">设备状态</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">异常状态:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.devstatus.tamper" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">电量:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.devstatus.bl" />
													</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">温度:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="device.devstatus.temperature" />
													</td>
												</tr>

												<!-- 设备参数-->
												<tr>
													<td height="20" colspan="2" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">设备参数（黑色为用户修改，红色为设备当前，一致则表示已同步）</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">目标精度（米）:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="devconfigs.modified.tarcep" /> <span
														style="color:red">(<s:property
																value="devconfigs.current.tarcep" />)</span></td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">唤醒时间间隔:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="devconfigs.modified.wkp" /> <span
														style="color:red">(<s:property
																value="devconfigs.current.wkp" />)</span></td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">GPS获取限时（秒）:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="devconfigs.modified.tgps" /> <span
														style="color:red">(<s:property
																value="devconfigs.current.tgps" />)</span></td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">服务器DNS:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="devconfigs.modified.dns" /> <span
														style="color:red">(<s:property
																value="devconfigs.current.dns" />)</span></td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">端口号:</td>
													<td colspan="2" bgcolor="#FFFFFF"><s:property
															value="devconfigs.modified.prt" /> <span
														style="color:red">(<s:property
																value="devconfigs.current.prt" />)</span></td>
												</tr>
												<s:if test="devconfigs.current.tenbl != -1">
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">不动不报传感器:</td>
													<td colspan="2" bgcolor="#FFFFFF">
													<s:property value="devconfigs.modified.tenbl" />
													<span style="color:red">(<s:property value="devconfigs.current.tenbl" />)</span>
													</td>
												</tr>
												</s:if>
												<s:if test="devconfigs.current.e433 != -1">
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">433定位传感器:</td>
													<td colspan="2" bgcolor="#FFFFFF">
													<s:property value="devconfigs.modified.e433" />
													<span style="color:red">(<s:property value="devconfigs.current.e433" />)</span>
													</td>
												</tr>
												</s:if>
												<s:if test="devconfigs.current.tempenable != -1">
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">温度传感器:</td>
													<td colspan="2" bgcolor="#FFFFFF">
													<s:property value="devconfigs.modified.tempenable" />
													<span style="color:red">(<s:property value="devconfigs.current.tempenable" />)</span>
													</td>
												</tr>
												</s:if>
												<s:if test="devconfigs.current.speedenable != -1">
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">速度传感器:</td>
													<td colspan="2" bgcolor="#FFFFFF">
													<s:property value="devconfigs.modified.speedenable" />
													<span style="color:red">(<s:property value="devconfigs.current.speedenable" />)</span>
													</td>
												</tr>
												</s:if>

											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="6"><img src="../images/spacer.gif" width="1"
								height="1" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
