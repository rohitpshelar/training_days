<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
<s:form action="login">

<s:textfield name="uname" label="Username"></s:textfield>
<s:password name="password" label="Password"></s:password>
<s:submit value="Login"></s:submit>
</s:form>

  </body>
</html>
