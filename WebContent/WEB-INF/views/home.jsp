<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.billstracker9.entities.User,com.billstracker9.entities.Transaction,com.billstracker9.entities.Account ,com.billstracker9.entities.Payee, java.util.List" %>
  
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
   <%@ page import="com.billstracker9.entities.User" %>
    <!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
	<title>Home</title>
	<style>
		body, html {
  		height: 100%;
  		margin: 0 0 0 0;
	}
	</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="resources/images/Logo.png" width="50" height="50" alt="Logo">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link" href="#" value="${firstName}">My profile &nbsp; ${user.getfName()} <span class="sr-only">(current)</span></a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">my profile</a>
          <a class="dropdown-item" href="#">Add Bank</a>
          <a class="dropdown-item" href="#">Sign out</a>
          
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         My Bills
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${contextPath}/newBill?email=${user.getEmail()}">Add bill</a>
          <a class="dropdown-item" href="">Pay bill</a>
          <a class="dropdown-item" href="">View my bills</a>
          <a class="dropdown-item" href="${contextPath}/newPayee">Add payee</a>
          
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<div class="container-fluid text-left " style="max-width:800px;">    
  <div class="row content ">
	<div class="col-md-9 col-lg-9 " id="left">
		<h3>due soon</h3>
		<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Payee Name</th>
			      <th scope="col">Amount</th>
			      <th scope="col">Due Date</th>
			    
			      
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${dueSoonBillList}" var="bill" >
			  
			    <tr>
			      <td>${bill.getAccount().getPayee().getPayeeName()}</td>
			      <td>${bill.getAmount()}</td>
			      <td>${bill.getDueDate()}</td>
			      <td><a href="${pageContext.request.contextPath}/billDetails/${bill.getTransactionId()}">Bill details</a></td>
			    </tr>
			   </c:forEach>
			    
			  </tbody>
			  
		  </table>
			<br>
			
	</div>
	<div class=" col-md-3 col-lg-3 center" id="left" >
		<h3>Past Due</h3>
		<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Payee </th>
			      <th scope="col">Amount</th>

			    
			      
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${pastDueBillList}" var="bill" >
			  
			    <tr>
			      <td>${bill.getAccount().getPayee().getPayeeName()}</td>
			      <td>${bill.getAmount()}</td>

				      <td><a href="${pageContext.request.contextPath}/billDetails/${bill.getTransactionId()}">Details</a></td>
			    </tr>
			   </c:forEach>
			    
			  </tbody>
			  
		  </table>	</div>
	<div class="col-md-2 col-lg-2 " id="right">		<h1></h1>
	</div>
    
	

  </div>
</div>	
<script type="text/javascript" src="../script/allbills.js"></script> 

</body>
</html>