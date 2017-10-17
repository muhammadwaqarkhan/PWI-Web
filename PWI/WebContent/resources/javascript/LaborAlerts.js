function enableDisableSubmitButton ()
{
	var fromDate = $('#fromDate').val();
	var threshold = $('#threshold').val();

	if (isNullOrEmpty(fromDate) || isNullOrEmpty(threshold))
	{
		$( "#viewReportButton" ).prop( "disabled", true );
	}
	else 
	{
		$( "#viewReportButton" ).prop( "disabled", false );
	}
}

function isNotNullOrEmpty (data)
{
	return !isNullOrEmpty(data);
}

function isNullOrEmpty (data)
{
	return (data == '' || data == undefined);
}

function fetchReports ()
{
	$('#viewReport').val("true");
	//document.forms("LaborAlerts").submit();
	document.getElementById('LaborAlerts').submit();
}

function readReportsInRange ()
{
	document.getElementById("ReportSummaryDiv").style.display = 'none';
	document.getElementById("SendEmailDiv").style.display = 'none';
	var fromDate = $('#fromDate').val();
	var toDate = $('#toDate').val();
	var threshold = $('#threshold').val();
	var companyId = $('#companyId').val ();
	showAjaxWaitVeil ();
	LaborAlertAjaxHandler.readCompanyReports (fromDate, toDate, companyId, threshold,  {callback:function(dataFromServer) { 
	    ajaxResponse(dataFromServer); 
	}});
}

function ajaxResponse (data)
{
	hideAjaxWaitVeil ();
	if (data)
	{
		if (data.error == '1')
		{
			alert ("Error accoured while retrieving reports");
		}
		else 
		{
			if (data.htmlString != '')
			{
				document.getElementById ("reportListTableDiv").innerHTML = data.htmlString;
				eval (data.javaScript);	
			}
		}
	}
}

function getReportSummary (reportId)
{
	showAjaxWaitVeil ();
	var thresholdLevel = $('#currentReportThresholdLevel').val();
	var userid = $('#userId').val();
	var roleId = $('#roleId').val();
	alert(userid  +" " +roleId);
	LaborAlertAjaxHandler.getReportSummary (reportId, thresholdLevel,userid,roleId,  {callback:function(dataFromServer) { 
	    handleLoadReportSummaryResponse(dataFromServer); 
	}});
}

function handleLoadReportSummaryResponse (data)
{
	hideAjaxWaitVeil ();
	if (data)
	{
		if (data.error == '1')
		{
			alert ("Error accoured while retrieving reports");
		}
		else 
		{
			if (data.htmlString != '')
			{
				document.getElementById ("ReportSummaryDiv").innerHTML = data.htmlString;
				eval (data.javaScript);	
			}
		}
	}
}

function sendEmailOnClick ()
{
	var selectedReportId = $('#selectedReportId').val();
	var thresholdLevel = $('#currentReportThresholdLevel').val();
	var storeid =  $('#storeid').val();
	var userid = $('#userId').val();
	var roleId = $('#roleId').val();
	showAjaxWaitVeil ();
	$.ajax({
	    type: "POST",
	    url: "./AjaxHandlerServlet",
	    data: 'ACTION=' + 1 + '&PageName=LaborAlerts&reportId=' + selectedReportId + '&thresholdLevel=' + thresholdLevel + '&storeid=' + storeid+ '&userid=' + userid+ '&roleId=' + roleId,
	    success: function (msd)
	    {
	    	$( "#emailSuccessDialog" ).dialog(
			{
				resizable: false,
		        draggable: false,
		        dialogClass: "alertDialog", 
		        modal: true, 
		        buttons: { "Ok": function() { 
		        	$(this).dialog("close");
		        	hideAjaxWaitVeil ();
		        } } 
			}		
			);
	    },
	    error: function (msg)
	    {
	    	$( "#emailFailureDialog" ).dialog( 
			{
				resizable: false,
		        draggable: false,
		        dialogClass: "alertDialog", 
		        modal: true, 
		        buttons: { "Ok": function() {
		        	$(this).dialog("close");
		        	hideAjaxWaitVeil ();
		        	} } 
			}			
			);
	    }

	});
}