<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<html>
	<head>

		<title>Insert title here</title>
	</head>
	<body>
		sassasasa
		<div align="center">
			display page
			<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/login";//Here the "test" is the Database name 
		FileInputStream fis = null;
		try {
			System.out.println("inside jsp try");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, "root", "root");

			Statement st = null;
			st = con.createStatement();
			String sql = "select image from image where id=1";
			System.out.println("sql----" + sql);
			rs = st.executeQuery(sql);
			//rs = st.executeQuery("select image from demoimage where id='1'"); 	
		//	<div style="border: solid 1px red; width: 10px; height:20px; background-image: url('imgcontainer.jsp?id=1');"></div>
			String imgLen = "";
			while (rs.next()) {
				imgLen = rs.getString(1);
				System.out.println(imgLen.length());
				int len = imgLen.length();
				byte[] rb = new byte[len];
				InputStream readImg = rs.getBinaryStream(1);
				int index = readImg.read(rb, 0, len);
				System.out.println("Index.........." + index);
System.out.println("readImg="+readImg);
		//		response.reset();
		//		response.setContentType("image/jpg");
			//	response.getOutputStream().write(rb, 0, len);
		//		response.getOutputStream().flush();
				System.out.println("rd="+rb);
				System.out.println("len="+len);
			}
			

			//  response.getContentType(); 
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	%>
		</div>
	  <fieldset>
<legend>Product</legend>
        <table border="0"> 
         <%  
          
if(rs.next()) {     
rs.beforeFirst();  // for making sure you dont miss the first record.   
while(rs.next())   
{                        // opening while loop brackets.   
   
         %>     
     
    
  
 <td>
        <div style=""><img border="1"
            src="<%=rs.getString("Image") %>" height="160" width="160" /></div>
            <a href="ProductDesc.jsp?Image=<%=rs.getString("Image")%>"></a>
        </td>
         
         
<%     
                } //closing while loop bracket   
             }     
             else {     
                 //if no record is found, simply display a no record message     
         %>     
 Nothing.     
 <%     
             }     
          %>  
           
           </table> 
           </fieldset> 
	</body>
</html>
