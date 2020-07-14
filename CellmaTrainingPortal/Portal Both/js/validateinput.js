
function allowOnlyDigit(ev) {
	var key = ev.keyCode || ev.which || ev.charCode;
	return (key >= 48 && key <= 57);
}


function allowOnlyDigitAndDot(ev) {
	"use strict";
	var key = ev.keyCode || ev.which || ev.charCode;
	return key >= 48 && key <= 57 || key === 46;
}

function allowOnlyChar(e) {	
"use strict";			
    var key = e.keyCode || e.which || e.charCode;
	return (key > 64 && key < 91)  || (key > 96 && key < 123) || (key == 39) || (key == 146) || (key == 45);
}

function allowCharDigit(ev){
	var key = ev.keyCode || ev.which || ev.charCode;
	return ((key > 64 && key < 91)  || (key > 96 && key < 123) || (key >= 48 && key <= 57));
}

function allowOnlyCharAndDot(e) {				
    var key = e.keyCode || e.which || e.charCode;
	return (key > 64 && key < 91)  || (key > 96 && key < 123) || (key == 39) || (key == 46);
}

function allowOnlyCharHyphenApostropheSpace(e) {				
    var key = e.keyCode || e.which || e.charCode;
    return (key > 64 && key < 91)  || (key > 96 && key < 123) || (key == 39) || (key == 45) || (key == 32) || (key == 146);
}

function allowOnlyCharHyphenApostropheSpaceForwardSlash(e) {				
    var key = e.keyCode || e.which || e.charCode;
    return (key > 64 && key < 91)  || (key > 96 && key < 123) || (key == 39) || (key == 45) || (key == 32) || (key == 146) || (key == 47);
}

function allowOnlyCharForwardSlashSpace(e) {				
    var key = e.keyCode || e.which || e.charCode;
    return (key > 64 && key < 91)  || (key > 96 && key < 123) || (key == 39) || (key == 45) || (key == 32) || (key == 47) || (key == 146);
}

function allowOnlyDigitAndColon(ev)  {
	var key = ev.keyCode || ev.which || ev.charCode;
	return key >= 48 && key <= 57 || key == 58;
}

function allowOnlyDigitDollar(ev, value) {
	var key = ev.keyCode || ev.which || ev.charCode;
	var eValue = value;
	
	return ( (key >= 48 && key <= 57 ) || (key == 46 && eValue.value.indexOf('.') == -1) || (key == 36));
}

function allowOnlyDigitPercent(ev, value) {
	var key = ev.keyCode || ev.which || ev.charCode;
	var eValue = value;
	
	return ( (key >= 48 && key <= 57) || (key == 46 && eValue.value.indexOf('.') == -1) || (key == 37));
}


/* mobile num should be 10 digit numeric value
function validateMnum(key)
{
//getting key code of pressed key
var keycode = (key.which) ? key.which : key.keyCode;
var phn=$('#useMobile').val();
//comparing pressed keycodes
if ((keycode < 48 || keycode > 57))
{
return false;
}
else
{
//Condition to check textbox contains ten numbers or not
if (phn.value.length ===10)
{
return true;
}
else
{
return false;
}
}
}

*/


function passwordValidate()
{
	
	        document.getElementById('password_strength').style.display='block';
	       
            //Regular Expressions.
            var regex = new Array();
            regex.push("[A-Z]"); //Uppercase Alphabet.
            regex.push("[a-z]"); //Lowercase Alphabet.
            regex.push("[0-9]"); //Digit.
            regex.push("[$@$!%*#?&]"); //Special Character.
 
            var passed = 0;
 
            //Validate for each Regular Expression.
            for (var i = 0; i < regex.length; i++)
			{
                if (new RegExp(regex[i]).test($("#usePassword").val())) 
				{
                    passed++;
                }
            }

            //Validate for length of Password.
            if (passed >2  && ($("#usePassword").val()).length > 8)
			 {
                passed++;
            }
 
            //Display status.
            var color = "";
            var strength = "";
            switch (passed)
			 {
                case 0:
                case 1:
				case 2:
				case 3:
				case 4:
                    strength = "Weak";
                    color = "#f10e0e";
					
                    break;
                case 5:
                    strength = "Strong";
                    color = "green";
                    break;
            }
			var pwd=$('#usePassword').val();
			$('#usePassword').css('border-color','#cccccc');
			$("#msgusePassword").html(""); 
            $("#password_strength").html(strength);
            $("#password_strength").css("color", color);
			if(strength == "Weak") {
				return false;
			}
			return true;
			
		
}

function checkPasswordMatch()
 {
    var password = $("#usePassword").val();
    var confirmPassword = $("#confirmPassword").val();
		
    if(password !== confirmPassword)
	{
		$('#confirmPassword').css('border-color','#f10e0e');
	    $("#msgconfirmPassword").css('color', '#f10e0e');
	    $("#msgconfirmPassword").html("Password does not match");
		return false;
	}
    else
	{    
	    $("#msgconfirmPassword").html("");
		$('#confirmPassword').css('border-color','#cccccc');
		return true;	
	}
}

 function emailValidate()
 {

	   var re = /^([\w-']+(?:\.[\w-']+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
       var emailval=$("#useEmail").val();
	   var testval = re.test(emailval);
	if(testval===true)
	{
		return true;
	}
	else
	{
		return false;
	}
    
				    
 }

function lengthChk()
{
	var mnum=$('#useMobile').val();
	if(mnum.length < 8)
	{
		    $("#msguseMobile").css('color', '#f10e0e');
	        $("#msguseMobile").html("Mobile number should be between 8 - 10 digit");
	}
	else
	{
		$('#useMobile').css('border-color','#cccccc');
	    $("#msguseMobile").html("");
	
	}
}

/* function mobileValidate()
{
	var mnum=$('#useMobile').val();
	//var pattern = /^\d{10}$/;
	//var mchk=pattern.test(mnum);

	if(mnum.length===10)
	{
		return true;
	}
	else
	{
		
		return false;
	}
    

	  //(mnum.match('[0-9]{10}'))===true)
       // var pattern = /^\d{10}$/;
        //if (pattern.test(mobile)) 
	 // if(!mnum.match('[0-9]{10}')) 
	  // {
                
       //         return false;
      // }  
	 //  else
	 //  {
	//return true;
	 //  }
}
*/
function DrawCaptcha()
    {
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        var f = Math.ceil(Math.random() * 10)+ '';  
        var g = Math.ceil(Math.random() * 10)+ '';  
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("txtCaptcha").value = code;
		
    }

function uggNameValidate() {
	var useUggId = $( "#useUggId option:selected" ).val();
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
}


function codeValidate()
 {
   
	 var str1 = removeSpaces(($("#txtCaptcha").val()));
     var str2 = removeSpaces(($("#codeInput").val()));

		
    if(str1 === str2)
		
	{
		$('#codeInput').css('border-color','#cccccc'); 
		$("#msgCode").html("");
		return true;
       
	}
    else
	{
		$('#codeInput').css('border-color','#f10e0e'); 
	    $("#msgCode").css('color', '#f10e0e');
	    $("#msgCode").html("Invalid code");
		return false;
        	
	}
}
    
    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
    
 function clearGivenName()
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
	  
	  	if(givenName!='')
	 {
		 $('#useFirstname').css('border-color','#cccccc'); 
		 $("#msguseFirstname").html(""); 
	 }
	 	if(familyName!='')
	 {
		 $('#useSurname').css('border-color','#cccccc'); 
		 $("#msguseSurname").html(""); 
	 }
	 	if(UserName!='')
	 {
		 $('#useUsername').css('border-color','#cccccc');
		$('#useUsername').val(UserName); 
		 $("#msguseUsername").html(""); 		 
		if(duplicateCheckUsername(UserName)){
			$('#useUsername').css('border-color','#f10e0e');
			$("#msguseUsername").css('color', '#f10e0e');
			$("#msguseUsername").html("User name already exist");
		}
		 
		
	 }
	 
	 
	 
	 if(pwd!='')
	 {
		 $('#usePassword').css('border-color','#cccccc'); 
		 $("#msgusePassword").html(""); 
		 $("#password_strength").html(""); 
	 }
	 	if(conpwd!='')
	 {
		 $('#confirmPassword').css('border-color','#cccccc'); 
		 $("#msgconfirmPassword").html(""); 
	 }
	 if(email!='')
	 {
		 $('#useEmail').css('border-color','#cccccc'); 
		 $("#msguseEmail").html(""); 
		 if(!isEmailRejected(email) ){
			$('#useEmail').css('border-color','#f10e0e');
			$("#msguseEmail").css('color', '#f10e0e');
			$("#msguseEmail").html("Email is not in approved list,<br /> Please contact Administrator");
		}
	 }
	 if(mobile!='')
	 {
		 $('#useMobile').css('border-color','#cccccc'); 
		 $("#msguseMobile").html(""); 
	 }
	 if(code!='')
	 {
		 $('#codeInput').css('border-color','#cccccc'); 
		 $("#msgCode").html(""); 
	 }

 }
 
function clearUsername(){
	var userName=$('#username').val();
	if(userName!=''){	

			$('#username').val(userName); 
		
	}
}
 