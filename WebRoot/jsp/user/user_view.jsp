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
    
    <title>用户详细信息</title>
    
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
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
         
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 用户详细信息</td>
                    </tr>
                     <tr>
                        <td height="20" align="right" bgcolor="#FFFFFF">用户名:</td>
                        <td colspan="2" bgcolor="#FFFFFF"><s:property value="user.username" /></td>
                     </tr>
                      <tr>
				    <td width="16%" height="20" align="right" bgcolor="#FFFFFF">真实姓名:</td>
                    <td width="84%" colspan="2" bgcolor="#FFFFFF"><s:property value="user.name" /></td>
                    </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">联系电话:</td>
				    <td colspan="2" bgcolor="#FFFFFF"><s:property value="user.phonenum" /></td>
                    </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">email:</td>
				    <td colspan="2" bgcolor="#FFFFFF"><s:property value="user.email" /></td>
                    </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">住址:</td>
                    <td colspan="2" bgcolor="#FFFFFF"><s:property value="user.address" /></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
