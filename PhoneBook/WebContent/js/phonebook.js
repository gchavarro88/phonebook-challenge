/* Phonebook */


angular.module('phoneBookApp', []).controller('phoneBookController', function($scope, $http) {
    
	$scope.contacts;
	const IP = "http://localhost:";
	const PORT = "8084";
	const PRODUCT = "/PhoneBook/";
	const PATH = "bs/contact/";
	const ADD_OPERATION = "addContact";
	const READ_OPERATION = "readContacts";
	const SEARCH_OPERATION = "searchContact";
	const ENDPOINT = IP+PORT+PRODUCT+PATH;
	
	readContacts();
	
	
	function addContact(Contact){
		
	}
	
	function searchContact(keyWork){
		
	}
	
	function readContacts(){
		doRequest(READ_OPERATION, null, readContactsSuccessFul, readContactsError);
	}
	
	function readContactsSuccessFul(response){
		console.log(response);
		$scope.contacts = response;
	}
	
	function readContactsError(response){
		console.log(response);
		alert("¡An error ocurred reading the contacts!");
	}
   
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
	 return $http(request).success(success).error(error);	
	}
   
	
  });



