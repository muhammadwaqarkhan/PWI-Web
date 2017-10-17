// Draw JQuery data table on load
$(document).ready(function() {
	$("#dataTable").dataTable({
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true
	});
});

// get the values of all selected check boxes on load and set it in a hidden
// variable
$(document).ready(function() {
	$("#btnSubmit").click(function() {
		var checkedValues = $("input[name=selector]:checked").map(function() {
			return this.value;
		}).get().join(",");
		$('#selctedRows').val(checkedValues);
	});
});

// get the value of selected check box on check box selection
$(document).ready(function() {
	$("input[name=selector]").click(function() {
		// this property will verify if an element is checked or not
		if ($(this).is(":checked")) {
			$(this).val();
		}

	});
});

