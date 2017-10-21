
<%@page import="com.pwi.constants.ApplicationCodes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="resources/css/login.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PWI</title>
</head>
<body>

	<div id="loginPage" align="center">
	<div id="iErrorPanel" style="margin-left: -100; color: red;" name="iErrorPanel">${iErrorPanel}</div>
		<form id="LoginPage" action="ApplicationServlet" method="post">

			<div id="main">
				<div id="sidebar" style="background-image: url(resources/images/login-image.jpg);  height: 250px; width: 400px; border: 1px solid black; margin: 80px 20px 40px 0px;">
				</div>
			</div>
			<div id="page-wrap">
				<div id="pageBody">
					<table>
						<tr>
							<td>
								<label for="username" >User name</label> 
							</td>
							<td>
								<input type="text" name="username" id="username"    />
							</td>
						</tr>
						<tr>
							<td>
								
							</td>
							
						</tr>
						
						<tr>
							<td>
								<label for="password">Password </label> 
							</td>
							<td>
								 <input type="password" name="password" required="required"/> 
							</td>
						</tr>
					</table>
					
					<br/>
					 
					<input type="submit" value="Login" name="action">
					<input type="hidden" id="PageName" name="PageName" value="LoginPage" />
					<input type="hidden" id="<%=ApplicationCodes.ACTION %>" name="<%=ApplicationCodes.ACTION %>" value="<%=ApplicationCodes.ACTION_READ %>">
				</div>
			</div>

		</form>
	</div>

<script type="text/javascript">


</script>
</body>
</html>
