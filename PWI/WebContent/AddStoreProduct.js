function setAction(action)
{
	if(validate())
	{
		$('#ACTION').val(action);
		document.getElementById("addStoreProduct").submit();
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
	var validate = new IValidation("addStoreProduct",true);
	validate.initValidation();
	return validate.isFormValid(true);
}