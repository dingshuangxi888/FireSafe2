$(document).ready(
function() {
	$.getJSON("session/getMenu.action", function(data) {
		$.each(data.menus, function(i, item) {
				$("#container").append("<TABLE width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left-table03\"><tr><td height=\"29\"><table width=\"85%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"8%\"><img name=\"img8\" id=\"img"+item.menuid+"\" src=\"images/ico04.gif\" width=\"8\" height=\"11\" /></td><td width=\"92%\">" +
				"<a href=\"javascript:\" target=\"mainFrame\" class=\"left-font03\" onClick=\"list('"+item.menuid+"');\" >"+item.menuname+"</a></td></tr></table></td></tr></TABLE><table id=\"menutree"+item.menuid+"\" style=\"DISPLAY: none\" width=\"80%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"left-table02\">");
		        for(var j=0;j<item.menus.length;j++){
		        	$("#menutree"+item.menuid).append("<tr><td width=\"9%\" height=\"20\" ><img id=\"xiaotu"+item.menus[j].menuid+"\" src=\"images/ico06.gif\" width=\"8\" height=\"12\" /></td><td width=\"91%\"><a href=\""+item.menus[j].menuurl+"\" target=\"mainFrame\" class=\"left-font03\" onClick=\"tupian('"+item.menus[j].menuid+"');\">"+item.menus[j].menuname+"</a></td></tr>");
		        }
		});
	});
   }
);