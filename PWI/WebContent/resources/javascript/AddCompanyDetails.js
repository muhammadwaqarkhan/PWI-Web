var ACTION_WRITE = 1;
var ACTION_READ = 0;
var companyDetails = undefined;
var REG_EXP_TEXT = "[A-Za-z ]+$";
var REG_EXP_NUMBER = "^0$|^[0-9]*$";

jQuery.noConflict();

$().ready(function ()
{
	
	// validate the form when it is submitted
	var validator = $("#addCompanyForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$( element )
				.closest( "form" )
					.find( "label[for='" + element.attr( "id" ) + "']" )
						.append( error );
		},
//		errorElement: "span",
		messages: {
			CompanyName: {
				required: " (required)"
			},
			PhoneNumber: {
				required: " (required)",
			},
			Address: {
				required: " (required)",
			},
			ZipCode: {
				required: " (required)",
			},
			Email: {
				required: " (required)",
			}
		}
	});

});

function addCompany ()
{
	addCompanyDetails ();
	
}

function addCompanyDetails ()
{
	var companyId = $('#companyId').val();
	var companyName = $('#CompanyName').val();
	var phoneNumber = $('#PhoneNumber').val();
	var address = $('#Address').val ();
	var zipCode = $('#ZipCode').val ();
	var email = $('#Email').val ();
	var alertProfile = $('#alertProfile').val ();
	var laborealert = $('#laborealert').val ();
	var estub = $('#estub').val ();
	var ewtwo = $('#ewtwo').val ();
	var dms = $('#dms').val ();
	var threshold = $('#threshold').val ();
	
	companyDetails = 
	{
		companyName : companyName, 
		phoneNumber : phoneNumber, 
		address : address,
		zipCode : zipCode,
		email : email,
		alertProfile : alertProfile,
		laborealert : laborealert, 
		estub : estub,
		ewtwo : ewtwo,
		dms : dms,
		threshold:threshold
	};
	
	var isValid = validateCompanyDetails ();
	
	if (!isValid) 
	{
		alert (document.getElementById("alertMessage").innerHTML);
		return false;
	}
	
	var companyInfo = 
	{
		companyId : companyId, 
		companyName : companyName,
		phoneNumber : phoneNumber,
		address : address,
		zipCode	: zipCode,
		email	: email, 
		alertProfile : alertProfile, 
		moduleLaboralert : laborealert, 	
		moduleEstub	: estub, 
		moduleEwtwo : ewtwo, 	
		moduleDms : dms,
		threshold:threshold
	};
	
//	$("#overlay").show();
	
	CompanyDetailsHandler.addCompanyDetails (companyInfo, {callback:function(dataFromServer) { 
			    ajaxResponse(dataFromServer); 
	 }});
}

function ajaxResponse (data)
{
	if (data)
	{
		if (data.error == '1')
		{
			alert ("Unable to add/update company");
		}
		else 
		{
			$('#companyId').val(data.htmlString);
			alert ("Company record updated succesfully");
		}
	}
}

function showErrorDialog ()
{
	$( "#alertMessageDialog" ).dialog(
	{
		resizable: false,
        draggable: false,
        dialogClass: "alertDialog", 
        modal: true, 
        buttons: { "Ok": function() { $(this).dialog("close"); } } 
	}		
	);
}

function clearDetails ()
{
	$('#companyId').val("");
	$('#CompanyName').val("");
	$('#PhoneNumber').val("");
	$('#Address').val ("");
	$('#ZipCode').val ("");
	$('#Email').val ("");
	//$('#alertProfile').prop('checked', true);
	$('#laborealert').attr('checked', false); // Unchecks it
	$('#estub').attr('checked', false); // Unchecks it
	$('#ewtwo').attr('checked', false); // Unchecks it
	$('#dms').attr('checked', false); // Unchecks it
}

function validateCompanyDetails ()
{
	var isValid = true;
	
	// company
	var pattern = new RegExp(REG_EXP_TEXT);
	isValid = pattern.test (companyDetails.companyName);
	
	if (!isValid)
	{
		document.getElementById("alertMessage").innerHTML = "Enter valid company name";
		return false;
	}
		
	// phone number
	pattern = new RegExp(REG_EXP_NUMBER);
	isValid = pattern.test (companyDetails.phoneNumber);
	
	if (!isValid)
	{
		document.getElementById("alertMessage").innerHTML = "Enter valid phone number";
		return false;
	}
	
	// address
	var address = companyDetails.address;
	if (address == '')
	{
		document.getElementById("alertMessage").innerHTML = "Please enter address";
		return false;
	}
	
	// zip code
	pattern = new RegExp(REG_EXP_NUMBER);
	isValid = pattern.test (companyDetails.zipCode);
	
	if (!isValid)
	{
		document.getElementById("alertMessage").innerHTML = "Please enter valid Zip Code";
		return false;
	}
	
	//threshold
	pattern = new RegExp(REG_EXP_NUMBER);
	isValid = pattern.test (companyDetails.threshold);
	
	if (!isValid)
	{
		document.getElementById("alertMessage").innerHTML = "Please enter valid Zip Code";
		return false;
	}
	
	// email
	var email = companyDetails.email;
	if (email == '')
	{
		document.getElementById("alertMessage").innerHTML = "Please enter an email address";
		return false;
	}

	
	return isValid;
}

function selectWeekly()
{
	$('#dailyalertProfile').prop('checked', false);
	$('#alertProfile').val("1");
}
function selectDaliy()
{
	$('#weeklyalertProfile').prop('checked', false);
	$('#alertProfile').val("0");
}