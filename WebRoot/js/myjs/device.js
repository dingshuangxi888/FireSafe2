//设备操作
var viewdevice = function(deviceid) {
	window.location.href = "device/view.action?deviceid=" + deviceid;
};

var modifydevice = function(deviceid) {
	window.location.href = "device/modifyinit.action?deviceid=" + deviceid;
};

var deletedevice = function(deviceid) {
	window.location.href = "device/delete.action?deviceid=" + deviceid;
};


//设备类型管理
var viewdevtype = function(typeid) {
//	alert(typeid);
	window.location.href = "devtype/view.action?typeid=" + typeid;
};

var modifydevtype = function(typeid) {
//	alert(typeid);
	window.location.href = "devtype/modifyinit.action?typeid=" + typeid;
};

var deletedevtype = function(typeid) {
//	alert(typeid);
	window.location.href = "devtype/delete.action?typeid=" + typeid;
};