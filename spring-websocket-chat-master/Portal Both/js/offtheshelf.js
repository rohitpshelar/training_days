

// # hiding this as registration from portal is disabled
// $(document).ready(function(){
	

		// loadEstablishments();
		// loadClinics();
	
	// loadUserGroupsGroupings();
// });


function validateUserRegistration()
{
	
	var givenName=$('#useFirstname').val();
	var familyName=$('#useSurname').val();
	var UserName=$('#useUsername').val();
	var pwd=$('#usePassword').val();
	var conpwd=$('#confirmPassword').val();
	var email=$('#useEmail').val();
	var mobile=$('#useMobile').val();
	var code=$('#codeInput').val();
	var useEstId = $( "#useEstId option:selected" ).val();
	var useCliId = $( "#useCliId option:selected" ).val();
	var useUggId = $( "#useUggId option:selected" ).val();

	if(givenName==='')
	 {
		 $('#useFirstname').css('border-color','#f10e0e');
		 $("#msguseFirstname").css('color', '#f10e0e');
		 $("#msguseFirstname").html("Please fill the given name"); 
		 
	 }	
	 
	 
	 
	 if(familyName==='')
	 {
		 $('#useSurname').css('border-color','#f10e0e');
		 $("#msguseSurname").css('color', '#f10e0e');
		 $("#msguseSurname").html("Please fill the family name");
		 
	 }
	 
	 if(UserName==='')
	 { 
	   $('#useUsername').css('border-color','#f10e0e');
	   $("#msguseUsername").css('color', '#f10e0e');
	   $("#msguseUsername").html("Please fill the user name");
	  
	  }
	 
	 
	 if(pwd==='')
	  { 
	   $('#usePassword').css('border-color','#f10e0e');
	   $("#msgusePassword").css('color', '#f10e0e');
	   $("#msgusePassword").html("Please fill the password");
	   	
	  }
	  else
	  {
		 
		   if(passwordValidate()===true)		
	        {
			   $("#msgusePassword").html("");
			   $('#usePassword').css('border-color','#cccccc');
				
			}
			 else
			 {
				 $('#usePassword').css('border-color','#f10e0e');
				 $("#msgusePassword").css('color', '#f10e0e');
				 $("#msgusePassword").html("Invalid password");
				 $("#password_strength").html("");
			 }
				 
	} 
	
		
	
	  
	 
	 if(conpwd==='')
	 { 
	    if(pwd==='')
		{
		//if password is not filled then not to display msg for fill confirm pwd
	   $("#msgconfirmPassword").html("");
	   $('#confirmPassword').css('border-color','#f10e0e');
		}
		else
		{
	   $('#confirmPassword').css('border-color','#f10e0e');
	   $("#msgconfirmPassword").css('color', '#f10e0e');
	   $("#msgconfirmPassword").html("Please fill the confirm password");
	 
		}
	 }
	 else
	 {
		  if(checkPasswordMatch()===true)		
	        {
			$("#msgconfirmPassword").html("");
		    }
			else
			{
			$('#confirmPassword').css('border-color','#f10e0e');
	        $("#msgconfirmPassword").css('color', '#f10e0e');
	        $("#msgconfirmPassword").html("Password does not match");
			
			}
	 }
	 
	 if(email==='')
	 { 
	  
	  $('#useEmail').css('border-color','#f10e0e');  
	  $("#msguseEmail").css('color', '#f10e0e');
	  $("#msguseEmail").html("Please fill the email id");
	
	  }
	   else
	 {
		  if(emailValidate()===true)		
	        {
			$("#msguseEmail").html("");
		    }
			else
			{
			$('#confirmPassword').css('border-color','#f10e0e');
	        $("#msguseEmail").css('color', '#f10e0e');
	        $("#msguseEmail").html("Email invalid");
			}
			if(!isEmailRejected(email)) {
			$('#useEmail').css('border-color','#f10e0e');
			$("#msguseEmail").css('color', '#f10e0e');
			$("#msguseEmail").html("Email is not in approved list,<br /> Please contact Administrator");
			}
	 }
	  
	  
	 
	  if(mobile==='')
	 {
       $('#useMobile').css('border-color','#f10e0e');
	   $("#msguseMobile").css('color', '#f10e0e');
	   $("#msguseMobile").html("Please fill the mobile number"); 
	  
	 }
	/*else
	 {
		 if(mobileValidate()===true)		
	        {
			return true;
		    }
			else
			{
			$('#useMobile').css('border-color','#f10e0e');
	        $("#msguseMobile").css('color', '#f10e0e');
	        $("#msguseMobile").html("Mobile number should have 10 digit");
			}
	 }*/
	 
	 
	
	 
	 if(code==='')
	 { 
	  $('#codeInput').css('border-color','#f10e0e'); 
	  $("#msgCode").css('color', '#f10e0e');
	  $("#msgCode").html("Please fill the code");
	  c=1;
	  }
	 else
	  {
		 if(codeValidate()===true)		
	        {
				$("#msgCode").html("");
		      
		    }
			else
			{
			$('#codeInput').css('border-color','#f10e0e'); 
	        $("#msgCode").css('color', '#f10e0e');
	        $("#msgCode").html("Invalid code");
			}
	  }
	
	if(useEstId==='')
	 {
		 $('#useEstId').css('border-color','#f10e0e');
		 $("#msguseEst").css('color', '#f10e0e');
		 $("#msguseEst").html("Please select establishment name"); 
	 }
	 else
	 {
		$("#msguseEst").html(""); 
		$('#useEstId').css('border-color','#cccccc');
	 }
	
	
	if(useCliId==='')
	 {
		 $('#useCliId').css('border-color','#f10e0e');
		 $("#msguseService").css('color', '#f10e0e');
		 $("#msguseService").html("Please select service name"); 
	 }
	 else
	 {
		  $("#msguseService").html(""); 
		  $('#useCliId').css('border-color','#cccccc');
	 }
	 
	
	if(useUggId==='')
	 {
		 $('#useUggId').css('border-color','#f10e0e');
		 $("#msguseGroup").css('color', '#f10e0e');
		 $("#msguseGroup").html("Please select group"); 
	 }
	 else
	 {
		 $("#msguseGroup").html("");
		 $('#useUggId').css('border-color','#cccccc');
	 }
	 
	if(givenName !== ''&& familyName !== '' && UserName !=='' && pwd !== '' && conpwd !=='' && email !=='' && mobile !=='' && code !=='' && useEstId!=='' && useUggId !=='')
	{
	     if(passwordValidate()==true && checkPasswordMatch() == true && emailValidate()==true && codeValidate()==true && isEmailRejected(email)==true)
		 {
			registerUser();
			
		}
	}
	else
	{
		alert("Please fill the mandatory fields");
	}
	

}


  
function loadEstablishments(){
	var settings = {
		async: true,
		data: 'type=establishments',
		crossDomain: true,
		url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do?',
		method: "POST"
	}
	$.ajax(settings).done(function (data) {
		if(data != null && data.length > 0){
			var myJsonObj = JSON.parse(data);
			$('#useEstId').html('<option value="">Select your Establishment</option>');
			for (i = 0; i < myJsonObj.length; i++) {
				var optionsText = '<option value="' + myJsonObj[i].estId + '">'+ myJsonObj[i].estName +'</option>';
				$('#useEstId').append(optionsText);
			}
		}
	});
	}

function loadEstablishmentData(){
	$('#useEstId').css('border-color','#cccccc');
	$("#msguseEst").html(""); 
	
	
	$("#useCliId").prop("disabled", true);
	 $("#useCliId").empty();
	 $('#useCliId').append('<option value="">Select your Service</option>');
	 
	$("#useUggId").prop("disabled", true);
	 $("#useUggId").empty();
	 $('#useUggId').append('<option value="">Select your Group</option>');
	/*
	$('#useCliId').css('border-color','#cccccc');
	$("#msguseService").html(""); 
	
	
	$('#useUggId').css('border-color','#cccccc');
	$("#msguseGroup").html(""); 
	*/
	//establishment should have data to load clinic data
	var useEstId = $( "#useEstId option:selected" ).val();

	if(useEstId != '')
	{
    $("#useCliId").removeAttr("disabled");

	loadClinics();
	
	}
	
}


function loadUserGroupsGroupings() {
	var moduleList = "ePharmacy, Pathology, Imaging, Electronic Patient Record, Ward and Bed management, Theatre and Surgery, Supplies and Inventory Management, Document Management, Maintenance, Porters, Finance billing and insurance, Dietetics and Kitchen, Business intelligence and reporting, Communication";
	var clinicId = trainingSiteCliId;
		if(clinicId == ""){
			clinicId = $('#useCliId option:selected').val();
		}
	if (clinicId != '') {
		$("#useUggId").removeAttr("disabled");
		$('#useUggId').html('<option value="">Select your Module</option>');
		var estId = trainingSiteEstId;
		if(estId == ""){
			estId = $('#useEstId option:selected').val();
		}
		if (estId != null && estId != '') {
			var settings = {
				async: true,
				data: 'type=groupsGroupings&estId=' + estId,
				crossDomain: true,
				url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do?',
				method: "POST"
			}
			$.ajax(settings).done(function (data) {
				if (data != null && data.length > 0 && data != '') {
					var myJsonObj = JSON.parse(data);
					for (i = 0; i < myJsonObj.length; i++) {
						if(moduleList.includes(myJsonObj[i].uggName)){
						var optionsText = '<option value="' + myJsonObj[i].uggId + '">' + myJsonObj[i].uggName + '</option>';
						$('#useUggId').append(optionsText);
						}
						// var optionsText = '<option value="' + myJsonObj[i].uggId + '">' + myJsonObj[i].uggName + '</option>';
						// $('#useUggId').append(optionsText);
					}
				} else {
					$("#useUggId").empty();
					$('#useUggId').append('<option  style="color:red;" value="">Please contact Administrator</option>');
				}
			});
		}
	}
}

function loadClinics() {
	var estId = $('#useEstId option:selected').val();
	if (estId != null && estId != '') {
		var clinicId = $('#useCliId option:selected').val();
		if (clinicId == '') {
			 $("#msguseService").html(""); 
		     $('#useCliId').css('border-color','#cccccc'); 
			$("#useCliId").empty();
			$('#useCliId').append('<option value="">Select your Service</option>');
			var settings = {
				async: true,
				data: 'type=clinics&estId=' + estId,
				crossDomain: true,
				url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do?',
				method: "POST"
			}
			$.ajax(settings).done(function (data) {
				if (data != null && data.length > 0) {
					var myJsonObj = JSON.parse(data);
					for (i = 0; i < myJsonObj.length; i++) {
						var optionsText = '<option value="' + myJsonObj[i].cliId + '">' + myJsonObj[i].cliName + '</option>';
						$('#useCliId').append(optionsText);
					}
				}
			});
		}
		loadUserGroupsGroupings();
	}
}

function clearUserRegistrationForm(){
	DrawCaptcha();
	$('#useFirstname').val('');
	$('#useSurname').val('');
	$('#useUsername').val('');
	$('#usePassword').val('');
	$('#confirmPassword').val('');
	$('#useEmail').val('');
	$('#codeInput').val('');
	
	$('#useUggId').html('<option value="">Select your Module</option>');
	$('#useCliId').html('<option value="">Select your Service</option>');
	
	$('#useEstId option:first').attr('selected','selected');
	$('#useCliId option:first').attr('selected','selected');
	$('#useUggId option:first').attr('selected','selected');
	$('#useMobile').val('');
	

		 $('#useFirstname').css('border-color','#cccccc'); 
		 $("#msguseFirstname").html(""); 
	
		 $('#useSurname').css('border-color','#cccccc'); 
		 $("#msguseSurname").html(""); 
	
		 $('#useUsername').css('border-color','#cccccc'); 
		 $("#msguseUsername").html(""); 
	
		 $('#usePassword').css('border-color','#cccccc'); 
		 $("#msgusePassword").html(""); 
		 $("#password_strength").html(""); 
	
		 $('#confirmPassword').css('border-color','#cccccc'); 
		 $("#msgconfirmPassword").html(""); 
	 
		 $('#useEmail').css('border-color','#cccccc'); 
		 $("#msguseEmail").html(""); 
	 
		 $('#useMobile').css('border-color','#cccccc'); 
		 $("#msguseMobile").html(""); 
	
		 $('#txtInput').css('border-color','#cccccc'); 
		 $("#msgCode").html(""); 
	
		 $('#useEstId').css('border-color','#cccccc');
		 $("#msguseEst").html("");
		 
		 $('#useCliId').css('border-color','#cccccc');
		 $("#msguseService").html("");
		 
		 $('#useUggId').css('border-color','#cccccc');
		 $("#msguseGroup").html("");
		 
		 $('#codeInput').css('border-color','#cccccc');
		 $("#msgCode").html("");
		
		loadUserGroupsGroupings();
}




function registerUser() {
	/*
	Error codes
	RC100 : User registered successfully
	RC101 : Can not register user, insufficient data provided or invalid input
	RC102 : Can not register user, Missing values are Username, passsword etc
	RC103 : Can not register user, maximum user limit reached for establishment
	RC104 : Can not register user, maximum user limit reached for service
	RC105 : User already exist
	RC106 : User email already exist
	RC107 : Server side internal error
	 */
	 $("#loadingModal").modal();
	var userDataJson = $('#registerModal').find('select, textarea, input').serializeJSON();
	userDataJson["useTrainingAssignedModules"] = $("#useUggId option:selected").text();
	if(trainingSiteEstId != '' && trainingSiteCliId != ''){
		userDataJson["useEstId"] = trainingSiteEstId;
		userDataJson["useCliId"] = trainingSiteCliId;
	}
	var userDataJsonString = JSON.stringify(userDataJson);

	var settings = {
		async: true,
		data: "userData=" + encodeURIComponent(userDataJsonString),
		crossDomain: true,
		url: trainingSiteDomain + 'cellmaWEB/TrainingProtalUserRegistration.do?',
		method: "POST"
	}
	$.ajax(settings).done(function (responseCode) {
		if (responseCode != null && responseCode == 'RC100') {
			clearUserRegistrationForm();
			alert('Successfully Register');

			var un = userDataJson.useUsername;
			var pw = userDataJson.usePassword;

			if (un != "" & pw != "" & un != null & pw != null) {
				loginWithUsernameAndPassword(un,pw);
			}
		}else{
			
			if(responseCode == 'RC101'){
			    alert("Error Code : "+responseCode + ": Can not register user, insufficient data provided or invalid input");
			}
			else if(responseCode == 'RC102'){
			    alert("Error Code : "+responseCode + ": Can not register user, Missing values are Username, passsword etc");
			}
			else if(responseCode == 'RC103'){
			    alert("Error Code : "+responseCode + ": Can not register user, maximum user limit reached for establishment");
			}
			else if(responseCode == 'RC104'){
			    alert("Error Code : "+responseCode + ": Can not register user, maximum user limit reached for service");
			}
			else if(responseCode == 'RC105'){
			    alert("Error Code : "+responseCode + ": User already exist");
			}
			else if(responseCode == 'RC106'){
			    alert("Error Code : "+responseCode + ": User email already exist");
			}
			else if(responseCode == 'RC107'){
			    alert("Error Code : "+responseCode + ": Server side internal error");
			}
			else{
			    alert("Error Code : "+responseCode);
			}
		}
	});
}