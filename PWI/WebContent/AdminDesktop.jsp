<%@page import="com.pwi.constants.ApplicationCodes"%>
<%@page import="com.pwi.services.ui.pageHandlers.admin.AdminPageHandler"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desktop</title>

<!-- CSS -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="resources//css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="resources/css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="resources/css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/minified/jquery.ui.accordion.min.css" rel="stylesheet" type="text/css">
<link href="resources/javascript/jquery-ui-1.10.4/themes/base/jquery.ui.accordion.css" rel="stylesheet" type="text/css">
<link href="resources/css/AdminDesktop.css" rel="stylesheet" type="text/css">

<link type="text/css" href="resources/css/menu.css" rel="stylesheet" />
<!-- <script type="text/javascript" src="resources/javascript/jquery_dropMenu.js"></script> -->


<!-- Scripts -->

<script src="resources/javascript/jquery-ui-1.10.4/tests/jquery-1.9.1.js" type="text/javascript"></script>
<script src="resources/javascript/jquery-ui-1.10.4/ui/jquery-ui.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/javascript/jquery.dataTables.js"	type="text/javascript"></script>
<script src="resources/javascript/index.js" type="text/javascript"></script>
<script src="resources/javascript/AdminDesktop.js" type="text/javascript"></script>
<script	src="resources/javascript/jquery-ui-1.10.4/ui/minified/jquery.ui.accordion.min.js" type="text/javascript"></script>
<script src="resources/javascript/jquery-ui-1.10.4/ui/jquery.ui.accordion.js" type="text/javascript"></script>
<script type="text/javascript" src="AddBranch.js"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/interface/BranchAjaxHandler.js'></script>
<script type="text/javascript" src="resources/javascript/validation/IValidation.js"></script>
<script type="text/javascript" src="resources/javascript/menu.js"></script>	

<script>
 
  
 
  
</script>

</head>
<body>

	<jsp:include page="Header.jsp" /> 

	<div class="container" style="margin-top:80px">
	
		
		<div class="col-md-8 col-md-offset-2">
			
			<br />
			<br />
			<div id="desktop">

				<form id="reportDetails" action="ApplicationServlet" method="post">
					<div align="justify">


					<c:forEach var="brancheRecord" items="${branches}">
					
					<h3>${brancheRecord.branchName}</h3>
					
							<table  id="resultTable" align="right" class="table table-responsive table-bordered table-hover">
									<thead>
										<tr>
											
											<th>Store Name</th>
											<th>Item</th>
											<th>Size</th>
											<th>In Stock</th>
											<th>Avl.Quantity</th>
											<th>In Transit</th>
											<th>MOQ</th>
											<th>QPB</th>
											<th>Reorder point</th>										
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="productRecord" items="${brancheRecord.branchInformation}">
											<tr>
												
												<td><c:out value="${productRecord.storeName}"></c:out></td>
												<td ><c:out value="${productRecord.productName}"></c:out></td>
												<td><c:out value="${productRecord.size}"></c:out></td>
												<td><c:out value="${productRecord.inStock}"></c:out></td>
												<td><c:out value="${productRecord.availableQuantity}"></c:out></td>
												<td><c:out value="${productRecord.inTransit}"></c:out></td>
												<td><c:out value="${productRecord.MOQ}"></c:out></td>
												<td><c:out value="${productRecord.QPB}"></c:out></td>
												<td><c:out value="${productRecord.recordPoint}"></c:out></td>
												
			
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								<br/>
					</c:forEach>
								
						<input type="hidden" id="PageName" name="PageName" value="AdminDesktop" /> 
						<input type="hidden" id="${ApplicationCodes.ACTION}" name="${ApplicationCodes.ACTION}" value="${ApplicationCodes.ACTION_WRITE}">
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>