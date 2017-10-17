function setAction(action)
{
	if(validate())
	{
		$('#ACTION').val(action);
		document.getElementById("addStore").submit();
		return true;
	}
	else
		return false;
	
}

function isNotNullOrEmpty (data)
{
	return !isNullOrEmpty(data);
}

function isNullOrEmpty (data)
{
	return (data == '' || data == undefined);
}

function validate()
{
	debugger;
	var validate = new IValidation("addStore",true);
	validate.initValidation();
	return validate.isFormValid(true);
}