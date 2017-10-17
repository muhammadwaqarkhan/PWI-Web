<%@page import="com.pwi.services.branch.dto.BranchDTO"%>
<%@page import="com.pwi.constants.ApplicationCodes"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript" src="AddProduct.js"></script>
<script type="text/javascript" src="resources/javascript/validation/IValidation.js"></script>



<script type="text/javascript" src="resources/javascript/menu.js"></script>	

<script>
  $(function() {
   
   	
   	$("#resultTable").dataTable
   	({
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true
	});
   	
   	$('#resultTable tbody').on('click', 'tr', function () 
	{
		var resultTable = $('#resultTable').dataTable();
		
		var ID = $('td', this).eq(0).text();
		$('#selectedID').val(ID);
		
	
		var productName = $('td', this).eq(1).text();
		var productType = $('td', this).eq(2).text();
		var size = $('td', this).eq(3).text();
		
		var MOQ = $('td', this).eq(4).text();
		var QPB = $('td', this).eq(5).text();
		
		var productType = $('td', this).eq(6).text();
		
		

		
		$('#productName').val(productName);
		
		$('#productType').val(productType);
		$('#size').val(size);
		
		$('#MOQ').val(MOQ);
		$('#QPB').val(QPB);
		$('#productType').val(productType);
		
		
		
	});
   	
   	
   	
  });
  
 
  
</script>
</head>
<body>

	<jsp:include page="Header.jsp" /> 

	<div id="main">
	
	
		<div id="page-wrap" align="center">
			
			<br />
			<br />
			<div id="desktop">
				<h1 >${companyName}</h1>
				<form id="addStore" action="ApplicationServlet" method="post">
				<table>
								<tr>
									<td><label for="reportPeriod"><b>Product Name:</b></label></td>
									<td><input type="text" id="productName" name="productName"  irequired="1" imask="alphanumeric"  value=""></td>
								</tr>
								<tr>
									<td><label><b>Product Type</b></label></td>
									<td>
										<select id="productType" name="productType" irequired="1">
											<option value="500"> select Packaging Material</option>
											<option value="500"> Finished Product</option>
											<option value="501">Component</option>
											<option value="502">Packaging Material</option>
										</select>
									</td>
									
								</tr>
								<tr>
									<td><label><b>size</b></label></td>
									<td><input type="text" id="size" name="size" irequired="1" imask="numeric"  value=""></td>
								</tr>
								
								
								<tr>
									<td><label><b>MOQ</b></label></td>
									<td><input type="text" id="MOQ" name="MOQ" irequired="1" imask="numeric"   value=""></td>
								</tr>
								<tr>
									<td><label><b>QPB</b></label></td>
									<td><input type="text" id="QPB" name="QPB"  irequired="1" imask="numeric"  value=""></td>
								
								</tr>
								
								
								
								
						
							</table>
							<br />
							
						<div align="justify">
							<input type="hidden" id="PageName" name="PageName" value="AddProduct" /> 
							<input type="hidden" id="ACTION" name="ACTION" value="1">
							<input type="hidden" id="selectedID" name="selectedID" value=""/>
						</div>
						
						<input type="submit" value="Add Product" name="Save" onclick="return setAction (1);">
						<input type="button" id="update" name="update" value="update product" onclick="return setAction (3);">
								
					
						<br/>
					<div id="productDiv">
								<table id="resultTable" align="right" class="table table-responsive table-bordered table-hover">
									<thead>
										<tr>
											<th><u>Product Code</u></th>
											<th><u>Product Name</u></th>
											<th><u>Product Type</u></th>
											<th><u>Size</u></th>
											<th><u>MOQ</u></th>
											<th><u>QPB</u></th>
						
											
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="productRecord" items="${products}">
											<tr>
												<td><c:out value="${productRecord.productID}"></c:out></td>
												<td><c:out value="${productRecord.productName}"></c:out></td>
												<td ><c:out value="${productRecord.productType}"></c:out></td>
												<td ><c:out value="${productRecord.size}"></c:out></td>
												
												<td><c:out value="${productRecord.MOQ}"></c:out></td>
												<td><c:out value="${productRecord.QPB}"></c:out></td>
			
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
					</div>	
				</form>
				
				
					
			</div>

		</div>
	</div>

</body>
</html>