<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert an Image into MySQL Database</title>
	</head>
	<body>
		<h1>
			Insert an Image into MySQL Database!
		</h1>
		<%
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String url = "jdbc:mysql://localhost:3306/login";//Here the "test" is the Database name
			FileInputStream fis = null;

			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String photo = request.getParameter("photo");
Part
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(email);
			System.out.println(photo);

			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(url, "root", "root");

				       File image = new File("C:/Users/chinny/Desktop/images.jpg");
			//	File image = new File(photo);

				pstmt = conn
				.prepareStatement("insert into image(firstname, lastname, image, email) "
						+ "values(?,?,?,?)");
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(4, email);

				
				fis = new FileInputStream(image);

				System.out.println(image.getAbsolutePath());
				pstmt.setBinaryStream(3, (InputStream) fis, (int) (image
				.length()));

				int count = pstmt.executeUpdate();
				if (count > 0) {
					System.out
					.println("The image has been inserted successfully");
				} else {
					System.out.println("The image did not insert successfully");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (rs != null) {
				rs.close();
				rs = null;
					}
					if (pstmt != null) {
				pstmt.close();
				pstmt = null;
					}
					if (conn != null) {
				conn.close();
				conn = null;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		%>
		<br><div align="center"><br><font color="#0000ff" size="7"><strong><a style="font-size: xx-large;" href="display.jsp">Display Image</a> 
		</strong></font><br> 
 
 
	</div></body>
</html>
