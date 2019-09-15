<%--<jsp:useBean id="data" class="com.Student" scope="request"></jsp:useBean>

--%><jsp:useBean id="log" class="com.Student" scope="request">

<jsp:setProperty name="log" property="rollno"  />
<jsp:setProperty name="log" property="name"  />

</jsp:useBean>
<html>
  <head>
    

  </head>
  
  <body><%--
    
   		<jsp:getProperty name="data" property="rollno"/>
   		<jsp:getProperty name="data" property="name" />
 
 --%><br>
 
 
   		<jsp:getProperty name="log" property="rollno"/>
   		<jsp:getProperty name="log" property="name" />
   		
   		<%=request.getParameter("name") %>
  </body>
</html>
