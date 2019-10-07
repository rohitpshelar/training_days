<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  
  <link href="runnable.css" rel="stylesheet" /> --%>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
  <script type="text/javascript" src="js/jquery.validate.min.js"></script>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="enquiry_form" method="post" id="enquiry_form">

    Full Name *
    <input class="input-style" name="name"  id="name" type="text"/>
    <br>
    Email *
    <input class="input-style" name="email"  id="email" type="email"><br><%--
    Phone * 
        <input id="mobile" name="mobile"  id="mobile"></input><br>--%>
<input type="number"  pattern="\d{3}[\-]\d{3}[\-]\d{4}" required> <br>
    <input type="submit" value="SUBMIT"  id="enq_submit">

</form>
<script type="text/javascript">
$('#enquiry_form').validate({
    rules:{
    name:"required",
    email:{
    required:true,
    email:true
    },
    mobile:{
    required:true,
    minlength:9,
    maxlength:10,
    }
    },
    messages:{
    name:"Please enter your username..!",
    email:"Please enter your email..!",
    mobile:"Enter your mobile no"
    },

    submitHandler: function(form) {
     alert("working");
   
    document.enquiry_form.action="saveData.action";
   document.enquiry_form.submit(); 
    
    }
    });


</script>
</body>
</html>