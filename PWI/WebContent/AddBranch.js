function setAction(action)
{
	if(validate())
	{
		$('#ACTION').val(action);
		document.getElementById("addBranch").submit();
		return true;
	}
	else 
		return false;
	
}

function validate()
{
	debugger;
	var validate = new IValidation("addBranch",true);
	validate.initValidation();
	return validate.isFormValid(true);
}

function isNotNullOrEmpty (data)
{
	return !isNullOrEmpty(data);
}

function isNullOrEmpty (data)
{
	return (data == '' || data == undefined);
}

function deleteBranch (reportId)
{

	var branchID = $('#selectedbranchId').val();
	if(!branchID)
	{
		alert("please select branch which you want to delete");
		return;
	}
	BranchAjaxHandler.deleteBranch (branchID,   {callback:function(dataFromServer) { 
	    handleBranchResponse(dataFromServer); 
	}});
}

function handleBranchResponse (data)
{

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
				document.getElementById ("branchesDiv").innerHTML = data.htmlString;
				
			}
		}
	}
}
