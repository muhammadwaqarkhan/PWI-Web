////$(document).ready(function ()
////{
////	// 1. prepare the validation rules and messages.
////	var rules =
////	{
////		vendorName :
////		{
////			required : true
////		},
////		vendorItemType : "required",
////		email : "required"
////	};
////	var messages =
////	{
////		vendorName :
////		{
////			required : "textbox1 is required"
////		},
////		vendorItemType : "textbox2 is requried",
////		email : "textbox3 is required"
////	};
////
////	// 2. Initiate the validator
////	var validator = new jQueryValidatorWrapper("addVendor", rules, messages);
////
////	// 3. Set the click event to do the validation
////	$("#validate").click(function ()
////	{
////		if (!validator.validate())
////			return;
////
////		alert("Validation Success!");
////	});
////});
//
//$(document).ready(function ()
//{
//	jQuery.validator.setDefaults(
//	{
//		debug : true,
//		success : "valid"
//	});
//});
//
//
//$("#validate").click(function ()
//{
//	$("#addVendor").validate(
//	{
//		rules :
//		{
//			vendorName :
//			{
//				required : true,
//				message : "mandatory"
//			}
//		}
//	});
//});