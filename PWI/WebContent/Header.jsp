<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="resources/css/AdminDesktop.css" rel="stylesheet" type="text/css"> -->
</head>
<body>
	<div id="HeaderDiv">
	
		<p style="margin-left: 100px ">
			<div id="iErrorPanel" style="margin-left: -100; color: red;" name="iErrorPanel">${iErrorPanel}</div>
		<div id="menu">
		    <ul class="menu">
		       
		        <li><a href="#" class="parent"><span>Branches</span></a>
		            <ul>
						<li>
							<a href="${pageContext.request.contextPath}/ApplicationServlet?PageName=AddBranch&ACTION=0"><span>Manage Branch</span></a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/ApplicationServlet?PageName=AddStore&ACTION=0"><span>Manage Store</span></a>
						</li>
						
					</ul>
		        </li>
		       
		        <li><a href="#"><span>Products</span></a>
		        	<ul>
						<li>
							<a href="${pageContext.request.contextPath}/ApplicationServlet?PageName=AddProduct&ACTION=0"><span>New Product</span></a>
						</li>
						
					</ul>
		        </li>
		        
		        <li><a href="#"><span>Store Product</span></a>
		        	<ul>
						<li>
							<a href="${pageContext.request.contextPath}/ApplicationServlet?PageName=AddStoreProduct&ACTION=0"><span>Manage Store Product</span></a>
						</li>
						
					</ul>
		        </li>
		         <li><a href="#"><span>Brand Product</span></a>
		        	<ul>
						<li>
							<a href="${pageContext.request.contextPath}/ApplicationServlet?PageName=AddBrandProduct&ACTION=0"><span>Manage Brand Product</span></a>
						</li>
						
					</ul>
		        </li>
		    </ul>
		</div>

		</p>


	</div>
	<br />
	
	<div id="userDialog" style="display: none">
	</div>
</body>
</html>