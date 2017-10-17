var ADD_VENDOR = "1";

$(document).ready(function() {
	$("#addVendor").click(function() {
		$("#vendorAction").val(ADD_VENDOR);
		$("#vendorManagement").submit();
	});
});