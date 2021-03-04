<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.billstracker9.entities.Payee,com.billstracker9.entities.User, java.util.List" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
    
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
		
	<title>All bills</title>
	<style>
		body, html {
  		height: 100%;
  		margin: 0 0 0 0;
	}
	
	.invalid {
  		color: red;
	}
	
	.valid {
	  color: green;
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
      <li class="nav-item active">
        <a class="nav-link" href="#" value="${firstName}">My profile &nbsp; ${firstName} <span class="sr-only">(current)</span></a>
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
          <a class="dropdown-item" href="${contextPath}/newBill">Add bill</a>
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

<div class="row content ">
	<div class="col-xs-2 col-sm-2 col-md- col-lg-2 " id="left">
		<h1></h1>
	</div>
	<div class=" col-xs-8 col-sm-8 col-md-8 col-lg-8 center" id="center" >
		<div class="main_container">
		<div class="form_container" id="formContainer">
			<form class="form" method="POST" action="addBill"" id="form-signin" modelAttribute="billForm" class="form-signin" >
			  <div class=" col-xs-7 col-sm-7 col-md-7 col-lg-7 center" id="center">
			  
			  <div class="form-group">
			      <label for="payeeName" class="label label-lg"><h5>Payee name</h5></label>
			      <select class="form-control form-control-lg" id="payeeName" name="payeeName" >
			       <c:forEach items="${payeeList}" var="payee" >
			       	 <option>${payee.getPayeeName()}</option>
			       </c:forEach>
			       
			      </select>
			   </div>
			  
			    <br>
			    
			     <input type="text" class="form-control form-control-lg" id="accountNumber"  name="accountNumber" aria-describedby="" 
			    placeholder="Account number" required>
			    
			   
				<br>
			    <input type="text" class="form-control form-control-lg" id="amount"  name="amount" aria-describedby="" 
			    placeholder="Amount" required >
			    <br>
			   	
			   	<label name="billDate" for="date" id="billDate" "><h5>Bill Date</h5></label>
			   
			    <input type="date" class="form-control form-control-lg" id="transactionDate"  name="transactionDate" aria-describedby="" 
			    placeholder="Bill Date" required>
			    <br>
			    
			    <label name="dueDateLabel" for="dueDate" id="dueDateLabel" "><h5>Due Date</h5></label>
			    
			    <input type="date" class="form-control form-control-lg" id="dueDate"  name="dueDate" aria-describedby="" 
			    placeholder="Due Date" required>
			    <br>
			    
			    <input type="text" class="form-control form-control-lg" id="describtion"  name="describtion" aria-describedby="" 
			    placeholder="Describtion" required>
			    <br>
			    
			  </div>
			 
			  <div class="form-group form-check">
			  </div>
			  <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 center">
				  <button type="submit" class="btn btn-primary btn-lg btn-block">Add bill</button>
			  </div> 
			  <label name="sucessmessage" class="valid" value="${sucessmessage}"><h3>${sucessmessage}</h3></label>
			  <label name="errormessage" class="invalid" value="${errormessage}">${errormessage}</label>
			  
			  <br>
			</form>
		</div>
		
	
						

		
	</div>

	</div>
</div>

<script type="text/javascript" src="../script/allbills.js"></script> 

</body>
</html>