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
<script type="text/javascript" src="AddBrandProduct.js"></script>
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
		
		
		var brandName = $('td', this).eq(1).text();
		var products = $('td', this).eq(2).text();

		
		
		
		//$('#brand').val(brandName);
		//$('#products').val(products);
		
			    

		var brandOptions = document.getElementById('brand');
		for (var i = 0; i < brandOptions.options.length; i++) {
		    if (brandOptions.options[i].text === brandName) {
		    	brandOptions.selectedIndex = i;
		        break;
		    }
		}
		
		var productsOptions = document.getElementById('products');
		for (var i = 0; i < productsOptions.options.length; i++) {
		    if (productsOptions.options[i].text === products) {
		    	productsOptions.selectedIndex = i;
		        break;
		    }
		}
		
		
		
	});
   	
   	
   	
  });
  
 
  
</script>
</head>
<body>

	<jsp:include page="Header.jsp" /> 

<div class="container" style="margin-top:80px">
	
		
		<div class="col-md-8 col-md-offset-2">
			
			<br />
			<br />
			<div id="desktop">
				<h1 >${companyName}</h1>
				<form id="addStoreProduct" action="ApplicationServlet" method="post">
				<table>
								<tr>
									<td><label><b>Brands</b></label></td>
									<td>
										<select id="brand" name="brand">
											<option value="-1">Select Brands</option>
											<c:forEach var="record" items="${brands.brands}">
												<option value="${record.brandID}"><c:out value="${record.brandName}"></c:out></option>
											</c:forEach>
											
										</select>
									</td>
								</tr>
								
								<tr>
									<td><label><b>Products</b></label></td>
									<td>
										<select id="products" name="products">
											<option value="-1">Select Products</option>
											<c:forEach var="productrecord" items="${products.products}">
												<option value="${productrecord.productID}"><c:out value="${productrecord.productName}"></c:out></option>
											</c:forEach>
											
										</select>
									</td>
								</tr>
								
								
							</table>
							<br />
							
						<div align="justify">
							<input type="hidden" id="PageName" name="PageName" value="AddBrandProduct" /> 
							<input type="hidden" id="ACTION" name="ACTION" value="1">
							<input type="hidden" id="selectedID" name="selectedID" value=""/>
						</div>
						
						<input type="submit" value="Add Brand Product" name="Save" onclick="setAction (1);">
						<input type="button" id="Delete" name="Delete" value="Delete Brand Product" onclick="setAction (2);">
								
					
						<br/>
					<div id="storesDiv">
								<table id="resultTable" align="right" class="table table-responsive table-bordered table-hover">
									<thead>
										<tr>
											<th><u>Brand Product Code</u></th>
											<th><u>Brand Name</u></th>
											<th><u>Product Name</u></th>
											
											
											
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="brandProduct" items="${brandProduct}">
											<tr>
												<td><c:out value="${brandProduct.brandProductID}"></c:out></td>
												<td><c:out value="${brandProduct.brandName}"></c:out></td>
												<td ><c:out value="${brandProduct.productName}"></c:out></td>
												
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