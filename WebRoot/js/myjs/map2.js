var map;
var markerArray = [];
var flightPlanCoordinates = [];
$(document).ready(
		function() {
			var mapOptions = {
				center : new google.maps.LatLng(30.30947, 120.38485),
				zoom : 8,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document
					.getElementById("map-canvas-inner"), mapOptions);
		});

var showdevicesby = function(areaid) {
	$("#devices").html("");
	$
			.getJSON(
					"map/devices.action",
					"areaid=" + areaid,
					function(data) {
						$
								.each(
										data.devices,
										function(i, item) {
											$("#devices")
													.append(
															"<li class=\"online\"><a href=\"#\" onclick=\"showOnMap("
																	+ item.deviceid
																	+ "); return false;\"><span>"
																	+ item.name
																	+ " ("
																	+ item.deviceid
																	+ ")</span> </a><span class=\"msg-count badge badge-info\" onclick=\"showHistoryOnMap("
																	+ item.deviceid
																	+ ")\">轨迹</span></li>");
										});
					});
};

var showOnMap = function(deviceid) {
	// alert(deviceid);
	$.getJSON("location/loc.action", "deviceid=" + deviceid, function(data) {
		var loc = data.location;
		placeMarder(loc.deviceid, loc.lat, loc.lng, loc.alt, loc.cep,
				loc.address, loc.offsetlat, loc.offsetlng, false);
	});
};

var showHistory = function(deviceid) {
	$(".history_list").remove();
	var param = $("#showHistoryForm").serialize();
	$.getJSON("location/history.action", param, function(data) {
		if (data.locations != null && data.locations.length != 0) {
			$.each(data.locations, function(i, item) {
				$("#history_table").append(
					"<tr align=\"center\" class=\"history_list\"><td height=\"20\" bgcolor=\"#FFFFFF\">"
					+ item.updatetime
					+ "</td><td bgcolor=\"#FFFFFF\">"
					+ item.address
					+ "</td><td bgcolor=\"#FFFFFF\"><img src=\"images/map/map256.png\" height=\"16px\" width=\"20px\" onclick=\"showOnMap2("
					+ item.deviceid
					+ ", "
					+ item.lat
					+ ", "
					+ item.lng
					+ ", "
					+ item.alt
					+ ", "
					+ item.cep
					+ ", '"
					+ item.address
					+ "', "
					+ item.offsetlat
					+ ", "
					+ item.offsetlng
					+ ");\"></td></tr>");
					});
			showPolyline(data.locations);
		}
	});
};

var showOnMap = function(deviceid) {
	// alert(deviceid);
	$.getJSON("location/loc.action", "deviceid=" + deviceid, function(data) {
		placeMarder(data.location, false);
	});
};

var showOnMap2 = function(deviceid, lat, lng, alt, cep, address, offsetlat,
		offsetlng) {
	placeMarder2(deviceid, lat, lng, alt, cep, address, offsetlat, offsetlng,
			false);
};

var showPolyline = function(locations) {
	clearMarders();
	map.setCenter(new google.maps.LatLng(locations[0].offsetlat,
			locations[0].offsetlng));
	map.setZoom(16);
//	locations.sort(function(a, b) {
//		return a.updatetime > a.updatetime ? -1 : 1;
//	});
//	if (locations.length >= 2) {
//		
//	}
	$.each(locations, function(i, item) {
		flightPlanCoordinates.push(new google.maps.LatLng(item.offsetlat,
				item.offsetlng));
	});
//	var lineSymbol = {
//			path: google.maps.SymbolPath.BACKWARD_OPEN_ARROW
//	};
	var poly = new google.maps.Polyline({
		path : flightPlanCoordinates,
//		icons:[{
//			icon: lineSymbol,
//			offset: '100%'
//		}],
		strokeColor : '#FF0000',
		strokeOpacity : 1.0,
		strokeWeight : 2
	});
	poly.setMap(map);
};

var placeMarder = function(location, clear) {
	if (clear == true) {
		clearMarders();
	}
	var latLng = new google.maps.LatLng(location.offsetlat, location.offsetlng);
	map.setCenter(latLng);
	map.setZoom(17);
	var marker = new google.maps.Marker({
		draggable:true,
		animation: google.maps.Animation.DROP,
		position : latLng,
		map : map
	});
	markerArray.push(marker);
	attachSecretMessage(marker, location);
};

var placeMarder2 = function(deviceid, lat, lng, alt, cep, address, offsetlat,
		offsetlng, clear) {
	if (clear == true) {
		clearMarders();
	}
	var latLng = new google.maps.LatLng(offsetlat, offsetlng);
	map.setCenter(latLng);
	map.setZoom(17);
	var marker = new google.maps.Marker({
		draggable:true,
		animation: google.maps.Animation.DROP,
		position : latLng,
		map : map
	});
	markerArray.push(marker);
	attachSecretMessage2(marker, deviceid, lat, lng, alt, cep, address);
};

var attachSecretMessage = function(marker, location) {
	var message = "deviceid: " + location.deviceid + ";<br/>" + "lat: "
			+ location.lat + "," + "lng: " + location.lng + ";<br/>" + "alt: "
			+ location.alt + ", " + "cep: " + location.cep + ";<br/>"
			+ "address: " + location.address + ".";
	var infowindow = new google.maps.InfoWindow({
		content : message,
	});
	google.maps.event.addListener(marker, "click", function() {
		infowindow.open(map, marker);
	});
};

var attachSecretMessage2 = function(marker, deviceid, lat, lng, alt, cep,
		address) {
	var message = "deviceid: " + deviceid + ";<br/>" + "lat: " + lat + ","
			+ "lng: " + lng + ";<br/>" + "alt: " + alt + ", " + "cep: " + cep
			+ ";<br/>" + "address: " + address + ".";
	var infowindow = new google.maps.InfoWindow({
		content : message,
	});
	google.maps.event.addListener(marker, "click", function() {
		infowindow.open(map, marker);
	});
};

var clearMarders = function() {
	if (markerArray) {
		for (i in markerArray) {
			markerArray[i].setMap(null);
		}
	}
	markerArray.length = 0;
};