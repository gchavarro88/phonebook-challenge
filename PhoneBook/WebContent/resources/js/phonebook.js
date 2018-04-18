/* Phonebook */
var app = angular.module('phoneBookApp', []).controller('phoneBookController', function($scope, $http) {
    
	$scope.contacts;
	$scope.keyWord  ="";
	$scope.firstName = "";
	$scope.lastName = "";
	$scope.phone;
	
	const IP = "http://localhost:";
	const PORT = "8084";
	const PRODUCT = "/PhoneBook/";
	const PATH = "contact/";
	const ADD_OPERATION = "addContact";
	const READ_OPERATION = "readContacts";
	const SEARCH_OPERATION = "searchContact";
	const ENDPOINT = IP+PORT+PRODUCT+PATH;
	
	//Load list of contacts when the page is loaded
	readContacts();
	
	/**
	 * This function valid if the keyword is not empty
	 **/
	$scope.search = function(){
		if($scope.keyWord != null){
			if($scope.keyWord.trim().length > 0){
				searchContact($scope.keyWord);
			}
			else{
				readContacts();
			}
		}
		else{
			alert("Please insert a valid value!");
		}
	}
	
	$scope.addContact = function(){
		if($scope.firstName.trim().length < 2){ //Minimun 2 caracteres
			alert("Please insert a valid first name!");
		}
		else if($scope.lastName.trim().length < 2){
			alert("Please insert a valid last name!");
		}
		else if($scope.phone == null || 
				$scope.phone < 1000000){ //Minimun 7 digits
			alert("Please insert a valid phone!");
		}
		else{
			var contact = {};
			contact.firstName = $scope.firstName;
			contact.lastName = $scope.lastName;
			contact.phone = $scope.phone;
			addContact(contact);
		}
	}
	
	function addContact(contact){
		doRequest(ADD_OPERATION, contact, responseSuccessfulAdd, responseError);
	}
	
	function searchContact(keyWord){
		doRequest(SEARCH_OPERATION, keyWord, responseSuccessful, responseError);
	}
	
	function readContacts(){
		doRequest(READ_OPERATION, null, responseSuccessful, responseError);
	}
	
	function responseSuccessful(response){
		console.log(response);
		$scope.contacts = response.data;
		$scope.keyWord  ="";
	}
	
	function responseSuccessfulAdd(response){
		console.log(response);
		readContacts();
		$scope.firstName = "";
		$scope.lastName = "";
		$scope.phone = null;
	}
	
	function responseError(response){
		console.log(response);
		alert("An error ocurred, please try again");
	}
   /**
    * Common function to do request to the backend, 
    * operation parameter allows to define which method call 
    * at the backend
    **/
	function doRequest(operation, data, success, error){
		var request = 
		{
			 method: 'POST',
			 url: ENDPOINT+operation,
			 headers: {
			   "Content-Type": "application/json"
			 },
			 data: data
		}
		console.log("REQUEST::::" + JSON.stringify(request));
	 return $http(request).then(success,error);	
	}
   
	
  });



