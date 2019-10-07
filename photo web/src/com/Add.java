package com;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Add extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private String dbURL;
    private String dbUser;
    private String dbPass;

    public Add()
    {
        dbURL = "jdbc:mysql://localhost:3306/login";
        dbUser = "root";
        dbPass = "root";
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String firstName;
        String lastName;
        InputStream inputStream;
        Connection conn;
        String message;
        System.out.println("=======");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        inputStream = null;
        Part filePart = request.getPart("photo");
        if(filePart != null)
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        conn = null;
        message = null;
        try
        {	
        	Class.forName("com.mysql.jdbc.Driver");
          
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String sql = "INSERT INTO contacts (cid,first_name, last_name, photo) values ('1',?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if(inputStream != null)
            {
                statement.setBlob(3, inputStream);
            }
            int row = statement.executeUpdate();
            if(row > 0)
            {
                message = "File uploaded and saved into database";
            }
           
        }
        catch(SQLException ex)
        {
            message = (new StringBuilder("ERROR: ")).append(ex.getMessage()).toString();
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        request.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
       
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        request.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        request.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
    }
}
