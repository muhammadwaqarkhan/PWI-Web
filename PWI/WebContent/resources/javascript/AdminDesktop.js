$(document).ready(function ()
{

	$('#cssmenu > ul > li:has(ul)').addClass("has-sub");

	$('#cssmenu > ul > li > a').click(function() {
		var checkElement = $(this).next();

		$('#cssmenu li').removeClass('active');
		$(this).closest('li').addClass('active');

		if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
			$(this).closest('li').removeClass('active');
			checkElement.slideUp('normal');
		}

		if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
			$('#cssmenu ul ul:visible').slideUp('normal');
			checkElement.slideDown('normal');
		}

		if (checkElement.is('ul')) {
			return false;
		} else {
			return true;
		}
	});

});


function checkCompany ()
{
	var company = document.getElementById("company");
	var value = company.options[company.selectedIndex].value;
	if (value == '' || value == undefined)
		alert("Please select a company");
	else
	{
		document.forms("reportDetails").submit();
	}
}
