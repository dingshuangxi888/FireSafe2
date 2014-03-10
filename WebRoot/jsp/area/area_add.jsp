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
    
    <title>添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
  <script language=JavaScript>
  function changeType(){
      var areaType = document.getElementById("areaType").value;
      if(areaType=="市"){
         document.getElementById("parentid").value="";
         document.getElementById("parent").style.display="none";
      }
      else if(areaType=="区"){
         document.getElementById("parentid").value="";
         document.getElementById("parent").style.display="";
      }
  }
  </script>
<body class="ContentBody">
  <form action="user/add.action" method="post" enctype="multipart/form-data" name="form">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >添加区域信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		 <TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>区域信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%"> 
					  <tr>
					    <td nowrap align="right" width="15%">区域名称:</td>
					    <td width="35%"><input name='user.username' type="text" class="text" style="width:154px" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">区域类型:</td>
					    <td width="34%"><select name="areaType" id="areaType" onchange="changeType();" >
                            <option selected="selected">==请选择==</option>
                            <option>市</option>
                            <option>区</option>
                        </select></td>
					  </tr>   
					  <tr id="parent" style="display:none">
					    <td nowrap align="right" width="15%">所属市:</td>
					    <td width="35%"><s:select list="areas" name="area.parentid" id="parentid"
							listKey="areaid" listValue="name" value=""></s:select></td>
					  </tr>
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="area.remarks" cols="100" rows="8"></textarea></td>
					    </tr>
					  </table>
			  <br/>
				</fieldset></TD>
		</TR>		
		</TABLE>
	 </td>
  </tr>	
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button" />　		
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
