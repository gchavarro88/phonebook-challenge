<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="phoneBookApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<meta charset="utf-8">
    	<title>PhoneBook</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<script src="<c:url value="/resources/js/phonebook.js"/>"></script>
	<script src="<c:url value="/resources/js/filters.js"/>"></script>
</head>
<body>
	<div class="container" ng-controller="phoneBookController">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="<c:url value="/resources/img/phonebook.png"/>">
					<p>v 1.0</p>
				</div>
			</div>
		</div>
		<div class="pure-g">
		    <div class="pure-u-sm-1 pure-u-1-3">
		    	<div class="box">
		    		<h2><i class="fa fa-user-plus"></i>New contact</h2>
		    		<form class="pure-form">
					    <fieldset class="pure-group">
					        <input type="text" class="pure-input-1-2" placeholder="First Name" ng-model="firstName">
					        <input type="text" class="pure-input-1-2" placeholder="Last Name" ng-model="lastName">
					        <input type="number" class="pure-input-1-2" placeholder="Phone" ng-model="phone">
					    </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" ng-click="addContact()">
					    <i class="fa fa-user-plus"></i>Add</button>
					</form>
				</div>
			</div>
		    <div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-search"></i>Search contact</h2>
		    		<form class="pure-form">
		    			<fieldset class="pure-group">
					    	<input type="text" class="pure-input-1-2" ng-model="keyWord">
					     </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" ng-click="search()">
					    <i class="fa fa-search"></i>Search</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-users"></i> Contacts</h2>
	    			<table class="pure-table">
					    <thead>
					        <tr>
					            <th>First Name</th>
					            <th>Last Name</th>
					            <th>Phone</th>
					        </tr>
					    </thead>
					
					    <tbody ng-repeat="contact in contacts">
					        <tr>
					            <td>{{contact.firstName}}</td>
					            <td>{{contact.lastName}}</td>
					            <td>{{contact.phone | phone}}</td>
					        </tr>
					    </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>