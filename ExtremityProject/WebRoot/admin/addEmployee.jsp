<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>JavaScript Form Validation using a sample registration
			form</title>
		<meta name="keywords"
			content="example, JavaScript Form Validation, Sample registration form" />
		<meta name="description"
			content="This document is an example of JavaScript Form Validation using a sample registration form. " /><%--
		<link rel='stylesheet' href='js-form-validation.css' type='text/css' />
		<script src="sample-registration-form-validation.js"></script>
		--%><style>
		
		h1 {  
margin-left: 70px;  
}  
form li {  
list-style: none;  
margin-bottom: 5px;  
}  
  
form ul li label{  
float: left;  
clear: left;  
width: 100px;  
text-align: right;  
margin-right: 10px;  
font-family:Verdana, Arial, Helvetica, sans-serif;  
font-size:14px;  
}  
  
form ul li input, select, span {  
float: left;  
margin-bottom: 10px;  
}  
  
form textarea {  
float: left;  
width: 350px;  
height: 150px;  
}  
  
[type="submit"] {  
clear: left;  
margin: 20px 0 0 230px;  
font-size:18px  
}  
  
p {  
margin-left: 70px;  
font-weight: bold;  
}  

		</style>
		
<script type="text/javascript">
		
function formValidation()  
{ 
debugger; 
var uid = document.registration.userid;  
console.log(uid);
var passid = document.registration.passid;  
var uname = document.registration.username;  
var uadd = document.registration.address;  
var ucountry = document.registration.country;  
var uzip = document.registration.zip;  
var uemail = document.registration.email;  
if(userid_validation(uid,5,12))  
{  
if(passid_validation(passid,7,12))  
{  
if(allLetter(uname))  
{  
if(alphanumeric(uadd))  
{   
if(countryselect(ucountry))  
{  
if(allnumeric(uzip))  
{  
if(ValidateEmail(uemail))  
{  
 
}   
}  
}   
}  
}  
}  
}  
return false;  
  
} function userid_validation(uid,mx,my)  
{  
var uid_len = uid.value.length;  
if (uid_len == 0 || uid_len >= my || uid_len < mx)  
{  

document.getElementById("userid").innerHTML ="User Id should not be empty / length be between "+mx+" to "+my;
uid.focus();  
return false;  
}  
return true;  
}  
function passid_validation(passid,mx,my)  
{  
var passid_len = passid.value.length;  
if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
{  
alert("Password should not be empty / length be between "+mx+" to "+my);  
passid.focus();  
return false;  
}  
return true;  
}  
function allLetter(uname)  
{   
var letters = /^[A-Za-z]+$/;  
if(uname.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('Username must have alphabet characters only');  
uname.focus();  
return false;  
}  
}  
function alphanumeric(uadd)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(uadd.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('User address must have alphanumeric characters only');  
uadd.focus();  
return false;  
}  
}  
function countryselect(ucountry)  
{  
if(ucountry.value == "Default")  
{  
alert('Select your country from the list');  
ucountry.focus();  
return false;  
}  
else  
{  
return true;  
}  
}  
function allnumeric(uzip)  
{   
var numbers = /^[0-9]+$/;  
if(uzip.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('ZIP code must have numeric characters only');  
uzip.focus();  
return false;  
}  
}  
function ValidateEmail(uemail)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(uemail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
uemail.focus();  
return false;  
}  
}
 


		</script>
	</head>
	<body onload="document.registration.userid.focus();">
		<h1>
			Registration Form
		</h1>
		<p>
			Use tab keys to move from one input field to the next.
		</p>
		<form name='registration' onSubmit="return formValidation();">
			<ul>
				<li>
					<label for="userid">
						User id*:
					</label>
				</li>
				<li>
					<input type="text" name="userid" size="12" />&nbsp <div id="userid" style="color: red"></div>
				</li>
				<li>
					<label for="passid">
						Password*:
					</label>
				</li>
				<li>
					<input type="password" name="passid" size="12" /> &nbsp <div id="passid" style="color: red"></div>
				</li>
				<li>
					<label for="username">
						Name*:
					</label>
				</li>
				<li>
					<input type="text" name="username" size="50" />&nbsp <div id="username" style="color: red"></div>
				</li>
				<li>
					<label for="address">
						Address*:
					</label>
				</li>
				<li>
					<input type="text" name="address" size="50" />&nbsp <div id="address" style="color: red"></div>
				</li>
				<li>
					<label for="country">
						Country*:
					</label>
				</li>
				<li>
					<select name="country">
						<option selected="" value="Default">
							(Please select a country)
						</option>
						<option value="AF">
							Australia
						</option>
						<option value="AL">
							Canada
						</option>
						<option value="DZ">
							India
						</option>
						<option value="AS">
							Russia
						</option>
						<option value="AD">
							USA
						</option>
					</select> &nbsp <div id="address" style="color: red"></div>
				</li>
				<li>
					<label for="zip">
						ZIP Code*:
					</label>
				</li>
				<li>
					<input type="text" name="zip" />
				</li>
				<li>
					<label for="email">
						Email*:
					</label>
				</li>
				<li>
					<input type="text" name="email" size="50" />
				</li>
			
				<li>
					<input type="submit" name="submit" value="Submit" />
				</li>
			</ul>
		</form>
	</body>
</html>
