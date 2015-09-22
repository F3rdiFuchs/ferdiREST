<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <c:url var="loginUrl" value="/login" />
      <form action="${loginUrl}" method="POST" id="signin" class="navbar-form navbar-right" role="form">
         <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
              
              <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter Username" required>  
                                                    
        </div>

        <div class="input-group">
           
           <input type="password" class="form-control" id="passWord" name="passWord" placeholder="Enter Password" required> 
                                                  
        </div>
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
           <button type="submit" class="btn btn-primary">Login</button>
                   </form>
    			</div>
  			</div>
		</nav>
	</body>
</html>