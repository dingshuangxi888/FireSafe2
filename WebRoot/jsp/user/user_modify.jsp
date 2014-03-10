<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <form action="user/modify.action" method="post" enctype="multipart/form-data" name="form" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >修改个人信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>用户信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					  <td><input type="hidden" name="user.userid" value="<s:property value="user.userid" />" /></td>
					  <td><input type="hidden" name="user.roles" value="<s:property value="user.roles" />" /></td>
					  <td><input type="hidden" name="user.createtime" value="<s:property value="user.createtime" />" /></td>
					  <td><input type="hidden" name="user.lastlogintime" value="<s:property value="user.lastlogintime" />" /></td>
					  </tr>		 
					  <tr>
					    <td nowrap align="right" width="15%">用户名:</td>
					    <td width="35%"><input name='user.username' type="text" class="text" style="width:154px" value="<s:property value="user.username" />" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input class="text" type="password" name='user.password' style="width:154px" value="<s:property value="user.password" />">
					    <span class="red">*</span></td>
					  </tr>				    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input class="text" name='user.name' style="width:154px" value="<s:property value="user.name" />"/></td>
					     <td width="16%" align="right" nowrap="nowrap">联系电话:</td>
					    <td width="34%"><input class="text" type="text" name='user.phonenum' style="width:154px" value="<s:property value="user.phonenum" />"></td>
					  </tr>				  
					  <tr>
					    <td align="right">email:</td>
					    <td><input class="text" name='user.email' style="width:154px" value="<s:property value="user.email" />"/></td>
					    <td align="right">住址:</td>
					    <td><input class="text" name='user.address' style="width:154px" value="<s:property value="user.address" />"/></td>
					  </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		</TABLE>
	 </td>
  </tr>
        <TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button"/>　
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
