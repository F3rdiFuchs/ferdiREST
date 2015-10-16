<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Doku:</title>
	</head> 
	<body>
		<table border = "1">
			<tr>
				<td><b>Aktion:</b></td>
				<td><b>HttP:</b></td>
				<td><b>Url:</b></td>
				<td><b>Input:</b></td>
			</tr>
			<tr>
				<td>Liste aller User:</td>
				<td>GET</td>
				<td>/user</td>
				<td> - </td>
			</tr>
			
			<tr>
				<td>Benutzer anlegen:</td>
				<td>POST</td>
				<td>/user</td>
				<td>Bsp: {"userName": "FakeAccount", "name": "Timmy", "lastName": "Eggs","eMail": "t.eggs@gmail.com","password": "abc123"} </td>
			</tr>
			
			<tr>
				<td>Benutzer löschen:</td>
				<td>DELETE</td>
				<td>/user/id</td>
				<td> - </td>
			</tr>
			
			<tr>
				<td>Benutzer bearbeiten:</td>
				<td>PUT</td>
				<td>user/</td>
				<td>Bsp: {"userId":"9","userName": "Timmy","name": "Eggs","lastName": "Dualegg","eMail": "abc@gmail.com","password": "abc123"}</td>
			<tr>
			
			<tr>
				<td>Einzelne Benutzer ausgeben:</td>
				<td>GET</td>
				<td>/user/id</td>
				<td> - </td>
			</tr>
		</table>
	</body>
</html>
