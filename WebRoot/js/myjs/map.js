var map;
var markerArray = [];
$(document).ready(
		function() {
			var mapOptions = {
				center : new google.maps.LatLng(30.30947, 120.38485),
				zoom : 8,
				disableDefaultUI : true,
				// panControl : false,
				// scaleControl : false,
				// rotateControl : false,
				zoomControl : true,
				zoomControlOptions : {
					style : google.maps.ZoomControlStyle.SMALL
				},
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document
					.getElementById("map-canvas-inner"), mapOptions);
		});

var showdevicesby = function(areaid) {
	$("#devices").html("");
	$.getJSON("map/devices.action", "areaid=" + areaid, function(data) {
		$.each(data.devices, function(i, item) {
			$("#devices").append("<li class=\"online\"><a href=\"#\" onclick=\"showOnMap("+ item.deviceid+ "); return false;\"><span>"+ item.name+ " ("+ item.deviceid+ ")</span> </a><span class=\"msg-count badge badge-info\" onclick=\"showHistoryOnMap(" + item.deviceid + ")\">轨迹</span></li>");
		});
	});
};

var showOnMap = function(deviceid) {
	// alert(deviceid);
	$.getJSON("location/loc.action", "deviceid=" + deviceid, function(data) {
		placeMarder(data.location);
	});
};

var showHistoryOnMap = function(deviceid) {
	
};

var placeMarder = function(location) {
	clearOverlays();
	var latLng = new google.maps.LatLng(location.lat, location.lng);
	map.setCenter(latLng);
	map.setZoom(15);
	var marker = new google.maps.Marker({
		position : latLng,
		map : map
	});
	markerArray.push(marker);
	attachSecretMessage(marker, location);
};

var attachSecretMessage = function(marker, location) {
	var message = "address: " + location.address;
	var infowindow = new google.maps.InfoWindow({
		content : message,
	});
	google.maps.event.addListener(marker, "click", function() {
		infowindow.open(map, marker);
	});
};

var clearOverlays = function() {
	if (markerArray) {
		for (i in markerArray) {
			markerArray[i].setMap(null);
		}
	}
	markerArray.length = 0;
};