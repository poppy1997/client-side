<%@page import="model.Researcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
  width:200px;
}
</style>
<meta charset="ISO-8859-1">
<title>Sign-up</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/researcher.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h3>Researcher sign-up</h3>
<form id="formItem" name="formItem">
 Researcher code: 
 <input id="itemCode" name="itemCode" type="text" 
 class="form-control form-control-sm">
 <br> Researcher name: 
 <input id="itemName" name="itemName" type="text" 
 class="form-control form-control-sm">
 
 <br> Researcher description: 
 <input id="itemDesc" name="itemDesc" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 Researcher itemObj = new Researcher(); 
  out.print(itemObj.readItems());
 %>
</div>
</div> </div> </div> 
</body>
</html>