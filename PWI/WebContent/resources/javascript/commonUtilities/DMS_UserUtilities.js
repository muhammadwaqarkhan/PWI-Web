/**
 * A utility Java script file to include all common JS functions that can be used across the applications. 
 * 
 * @author waqar
 * 
 * */

/**
 * showLightBox_OK : A utility function to display light box on UI. 
 * 
 * msg: the message you want to display in light box
 * dialogTitle: title of the light box
 * 
 * */

function showLightBox_OK (msg, dialogTitle)
{
	$("#userDialog").html(msg);
	$("#userDialog").dialog(
	{
		title: dialogTitle,
		resizable: false,
        draggable: false,
        dialogClass: "alertDialog", 
        modal: true, 
        buttons: { "Ok": function() { $(this).dialog("close"); } } 
	}		
	);
}

function DMS_ShowWarningMessage (msg, dialogTitle)
{
	$("#userDialog").html(msg);
	$("#userDialog").dialog(
	{
		title: dialogTitle,
		resizable: false,
        draggable: false,
        dialogClass: "alertDialog", 
        modal: true, 
        buttons: { "Ok": function() { $(this).dialog("close"); } } 
	}		
	);
}

/**
 * showAjaxWaitVeil : A utility function to hide screen during AJAX calls. 
 * 
 * */
function showAjaxWaitVeil ()
{
	$("#userDialog").html("Please wait . . .");
	$("#userDialog").dialog(
	{
		title: "Please wait",
		resizable: false,
	    draggable: false,
	    dialogClass: "alertDialog", 
	    open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
	    modal: true
	}		
	);
}

/**
 * hideAjaxWaitVeil : A utility function to enable back screen once AJAX call is over. 
 * 
 * */
function hideAjaxWaitVeil ()
{
	$("#userDialog").dialog("close");
}

