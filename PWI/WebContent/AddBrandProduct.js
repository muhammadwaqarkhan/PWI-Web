function setAction(action)
{
	$('#ACTION').val(action);
	document.getElementById("addStoreProduct").submit();
}

function isNotNullOrEmpty (data)
{
	return !isNullOrEmpty(data);
}

function isNullOrEmpty (data)
{
	return (data == '' || data == undefined);
}

