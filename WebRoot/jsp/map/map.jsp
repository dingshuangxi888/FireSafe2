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

<title>map.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<script src="js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script src="js/myjs/map.js"></script>
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/unicorn.js"></script>
<script src="js/unicorn.dashboard.js"></script>
<script src="js/dtpicker/WdatePicker.js"></script>
</head>

<body>
	<div id="header">
		<h1>
			<a href="./dashboard.html">FireSafe Admin</a>
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">Settings</span> </a>
			</li>
			<li class="btn btn-inverse"><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">Logout</span> </a>
			</li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>
			Map Action</a>
		<ul>
			<li class="active"><a href="map/show.action"><i
					class="icon icon-home"></i> <span>Map Action</span> </a></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>设备管理</span> <span class="label">3</span> </a>
				<ul>
					<li><a href="device/list.action">显示列表</a></li>
					<li><a href="device/addinit.action">添加设备</a></li>
					<li><a href="form-wizard.html">Wizard</a></li>
				</ul>
			</li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>设备类型管理</span> <span class="label">3</span> </a>
				<ul>
					<li><a href="devtype/list.action">显示列表</a></li>
					<li><a href="devtype/addinit.action">添加类型</a></li>
					<li><a href="form-wizard.html">Wizard</a></li>
				</ul>
			</li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>用户管理</span> <span class="label">3</span> </a>
				<ul>
					<li><a href="form-common.html">Common elements</a></li>
					<li><a href="form-validation.html">Validation</a></li>
					<li><a href="form-wizard.html">Wizard</a></li>
				</ul>
			</li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>区域管理</span> <span class="label">3</span> </a>
				<ul>
					<li><a href="form-common.html">Common elements</a></li>
					<li><a href="form-validation.html">Validation</a></li>
					<li><a href="form-wizard.html">Wizard</a></li>
				</ul>
			</li>
		</ul>

	</div>

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
			href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
			style="background-color: #673232;"></a>
	</div>

	<div id="content">
		<div id="content-header">
			<h1>Map Action</h1>
		</div>

		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i> Home</a> <a href="map/show.action"
				class="current">Map Action</a>
		</div>
		<div class="container-fluid">

			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box widget-chat">
						<div class="widget-title">
							<span class="icon"> <i class="icon-comment"></i> </span>
							<h5>Map View</h5>
						</div>
						<div class="widget-content nopadding">
							<div class="map-content panel-left">
								<div class="map-canvas">
									<div id="map-canvas-inner"></div>
								</div>
							</div>
							<div class="map-areas panel-right">
								<!-- 
								<div class="panel-title">
									<h5>Online Users</h5>
								</div>
								 -->
								<div class="btn-group">
									<button class="btn btn-small selectarea">Select an
										area</button>
									<button data-toggle="dropdown"
										class="btn btn-big dropdown-toggle" style="height:26px">
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">All</a>
										</li>
										<s:iterator value="areas" id="area">
											<li><a href="#"
												onclick="showdevicesby(<s:property value="#area.areaid" />); return false;"><s:property
														value="#area.name" /> </a>
											</li>
										</s:iterator>
									</ul>
								</div>
								<div class="panel-content nopadding">
									<ul class="contact-list devicelist" id="devices">
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div id="footer" class="span12">
					2013 &copy; FireSafe Admin. Brought to you by <a
						href="http://www.cctit.cn">dean&fang</a>
				</div>
			</div>
		</div>
	</div>
	<div>
<input type="text" class="Wdate" onfocus="WdatePicker()"/>
</div>
</body>


</html>
