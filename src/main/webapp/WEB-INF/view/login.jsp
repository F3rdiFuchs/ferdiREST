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
      <form id="signin" class="navbar-form navbar-right" role="form">
         <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
              <input id="email" type="email" class="form-control" name="email" value="" placeholder="Email Address">                                        
        </div>

        <div class="input-group">
           <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
           <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">                                        
        </div>
           <button type="submit" class="btn btn-primary">Login</button>
                   </form>
    			</div>
  			</div>
		</nav>
	</body>
</html>