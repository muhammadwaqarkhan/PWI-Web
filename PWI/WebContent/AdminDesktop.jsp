<%@page import="com.pwi.constants.ApplicationCodes"%>
<%@page import="com.pwi.services.ui.pageHandlers.admin.AdminPageHandler"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desktop</title>

<!-- CSS -->
<link href="resources/css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="resources/css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="resources/css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/minified/jquery.ui.accordion.min.css" rel="stylesheet" type="text/css">
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/jquery.ui.accordion.css" rel="stylesheet" type="text/css">
<link href="resources/css/AdminDesktop.css" rel="stylesheet" type="text/css">

<link type="text/css" href="resources/css/menu.css" rel="stylesheet" />
<!-- <script type="text/javascript" src="resources/javascript/jquery_dropMenu.js"></script> -->
<script type="text/javascript" src="resources/javascript/menu.js"></script>

<!-- Scripts -->
<script src="resources/javascript/jquery-ui-1.10.4/ui/jquery-ui.js" type="text/javascript"></script>
<script src="resources/javascript/jquery-ui-1.10.4/tests/jquery-1.9.1.js" type="text/javascript"></script>
<script src="resources/javascript/jquery.dataTables.js"	type="text/javascript"></script>
<script src="resources/javascript/index.js" type="text/javascript"></script>
<script src="resources/javascript/AdminDesktop.js" type="text/javascript"></script>
<script	src="resources/javascript/jquery-ui-1.10.4/ui/minified/jquery.ui.accordion.min.js" type="text/javascript"></script>
<script src="resources/javascript/jquery-ui-1.10.4/ui/jquery.ui.accordion.js" type="text/javascript"></script>
	


</head>
<body>

	<jsp:include page="Header.jsp" /> 

	<div id="main">
	
		
		<div id="page-wrap" align="center">
			
			<br />
			<br />
			<div id="desktop">

				<form id="reportDetails" action="ApplicationServlet" method="post">
					<div align="justify">

						<input type="hidden" id="PageName" name="PageName" value="AdminDesktop" /> 
						<input type="hidden" id="${ApplicationCodes.ACTION}" name="${ApplicationCodes.ACTION}" value="${ApplicationCodes.ACTION_WRITE}">
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>