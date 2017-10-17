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
<script type="text/javascript" src="AddStoreProduct.js"></script>



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
		
		
		var store = $('td', this).eq(1).text();
		var products = $('td', this).eq(2).text();
		var quantity = $('td', this).eq(3).text();
		var reorderPoint = $('td', this).eq(4).text();
		var InTransit = $('td', this).eq(5).text();
		var instock = $('td', this).eq(6).text();
		
		
		
		$('#store').val(store);
		
		$('#products').val(products);
		$('#instock').val(instock);
		$('#InTransit').val(InTransit);
		$('#quantity').val(quantity);
		$('#reorderPoint').val(reorderPoint);
		
		
		
		
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
				<form id="addStoreProduct" action="ApplicationServlet" method="post">
				<table>
								<tr>
									<td><label><b>Store</b></label></td>
									<td>
										<select id="store" name="store">
											<option value="-1">Select Store</option>
											<c:forEach var="record" items="${stores.stores}">
												<option value="${record.storeID}"><c:out value="${record.storeName}"></c:out></option>
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
								
								<tr>
									<td><label><b>In Stock</b></label></td>
									<td><input type="checkbox" name="instock" value="1"> </td>
								</tr>
								<tr>
									<td><label><b>In Transit</b></label></td>
									<td><input type="text" id="InTransit" name="InTransit"  value=""></td>
								
								</tr>
								<tr>
									<td><label><b>Quantity</b></label></td>
									<td><input type="text" id="quantity" name="quantity"  value=""></td>
								</tr>
								<tr>
									<td><label><b>Reorder Point</b></label></td>
									<td><input type="text" id="reorderPoint" name="reorderPoint"  value=""></td>
								</tr>
								
								
						
							</table>
							<br />
							
						<div align="justify">
							<input type="hidden" id="PageName" name="PageName" value="AddStoreProduct" /> 
							<input type="hidden" id="ACTION" name="ACTION" value="1">
							<input type="hidden" id="selectedID" name="selectedID" value=""/>
						</div>
						
						<input type="submit" value="Add Store" name="Save" onclick="setAction (1);">
						<input type="button" id="Delete" name="Delete" value="Delete Store" onclick="setAction (2);">
								
					
						<br/>
					<div id="storesDiv">
								<table id="resultTable" align="right" class="table table-responsive table-bordered table-hover">
									<thead>
										<tr>
											<th><u>SP Code</u></th>
											<th><u>Store Name</u></th>
											<th><u>Product Name</u></th>
											<th><u>Quantity</u></th>
											<th><u>Reorder point</u></th>
											<th><u>In transit</u></th>
											<th><u>inStocl</u></th>
											
											
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="storeProduct" items="${stroesProduct}">
											<tr>
												<td><c:out value="${storeProduct.storeProductID}"></c:out></td>
												<td><c:out value="${storeProduct.storeName}"></c:out></td>
												<td ><c:out value="${storeProduct.productName}"></c:out></td>
												<td><c:out value="${storeProduct.quantity}"></c:out></td>
												<td><c:out value="${storeProduct.reorderPoint}"></c:out></td>
												<td><c:out value="${storeProduct.inTransit}"></c:out></td>
												<td><c:out value="${storeProduct.instock}"></c:out></td>
								
												
												
												
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