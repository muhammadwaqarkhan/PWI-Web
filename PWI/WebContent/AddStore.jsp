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
<script type="text/javascript" src="AddStore.js"></script>

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
		
		
		var storeName = $('td', this).eq(1).text();
		var branchName = $('td', this).eq(2).text();
		var street = $('td', this).eq(3).text();
		var city = $('td', this).eq(4).text();
		var postCode = $('td', this).eq(5).text();
		var country = $('td', this).eq(6).text();
		
		var branchID = $('td', this).eq(7).text();
		
		$('#storeName').val(storeName);
		
		$('#branchstreet').val(street);
		$('#city').val(city);
		$('#postal').val(postCode);
		$('#country').val(country);
		$('#branch').val(branchName);
		
		
		
		
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
				<form id="addStore" action="ApplicationServlet" method="post">
				<table>
								<tr>
									<td><label for="reportPeriod"><b>Store Name:</b></label></td>
									<td><input type="text" id="storeName" name="storeName" irequired="1" imask="alphanumericplusspecial"  value=""></td>
								</tr>
								<tr>
									<td><label><b>Street</b></label></td>
									<td><input type="text" id="branchstreet" name="branchstreet" irequired="1" imask="alphanumericplusspecial"  value=""></td>
								</tr>
								
								<tr>
									<td><label><b>City</b></label></td>
									<td><input type="text" id="city" name="city" irequired="1" imask="alphanumericplusspecial" value=""></td>
								</tr>
								<tr>
									<td><label><b>Postal</b></label></td>
									<td><input type="text" id="postal" name="postal" irequired="1" imask="alphanumericplusspecial" value=""></td>
								</tr>
								<tr>
									<td><label><b>Country</b></label></td>
									<td><input type="text" id="country" name="country" irequired="1" imask="alphanumericplusspecial" value=""></td>
								</tr>
								<tr>
									<td><label><b>Branches</b></label></td>
									<td>
										<select id="branch" name="branch">
											<option value="-1">Select Branch</option>
											<c:forEach var="record" items="${branches}">
												<option value="${record.branchID}"><c:out value="${record.branchName}"></c:out></option>
											</c:forEach>
											
										</select>
									</td>
								</tr>
								
								
								
						
							</table>
							<br />
							
						<div align="justify">
							<input type="hidden" id="PageName" name="PageName" value="AddStore" /> 
							<input type="hidden" id="ACTION" name="ACTION" value="1">
							<input type="hidden" id="selectedID" name="selectedID" value=""/>
						</div>
						
						<input type="submit" value="Add Store" name="Save" onclick="return setAction (1);">
						<input type="button" id="Delete" name="Delete" value="Delete Store" onclick="return setAction (2);">
								
					
						<br/>
					<div id="storesDiv">
								<table id="resultTable" align="right" class="table table-responsive table-bordered table-hover">
									<thead>
										<tr>
											<th><u>Store Code</u></th>
											<th><u>Store Name</u></th>
											<th><u>Branch Code</u></th>
											<th><u>Branch Name</u></th>
											<th><u>Street</u></th>
											<th><u>City</u></th>
											<th><u>Postal Code</u></th>
											<th><u>Country</u></th>
											
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="storeRecord" items="${stroes}">
											<tr>
												<td><c:out value="${storeRecord.storeID}"></c:out></td>
												<td><c:out value="${storeRecord.storeName}"></c:out></td>
												<td ><c:out value="${storeRecord.branchID}"></c:out></td>
												<td><c:out value="${storeRecord.brancheName}"></c:out></td>
												<td><c:out value="${storeRecord.address.street}"></c:out></td>
												<td><c:out value="${storeRecord.address.city}"></c:out></td>
												<td><c:out value="${storeRecord.address.postalCode}"></c:out></td>
												<td><c:out value="${storeRecord.address.country}"></c:out></td>
												
												
												
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