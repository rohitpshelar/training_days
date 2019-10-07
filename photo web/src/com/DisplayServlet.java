package com;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DisplayServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    public DisplayServlet()
    {
        conn = null;
        stmt = null;
        rs = null;
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        System.out.println(">>>>>>>>>>>>IMage id is<<<<<<<<<<<<<<");
        int imageId = Integer.parseInt(request.getParameter("id"));
        System.out.println((new StringBuilder(">>>>>>>>>>>>IMage id is<<<<<<<<<<<<<<")).append(imageId).toString());
        System.out.println(imageId);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
            stmt = conn.prepareStatement((new StringBuilder("select * from contacts where cid=")).append(imageId).toString());
            rs = stmt.executeQuery();
            if(rs.next())
            {
                System.out.println("Inside RS");
                byte bytearray[] = new byte[0x100000];
                int size = 0;
                InputStream sImage = rs.getBinaryStream(4);
                response.reset();
                response.setContentType("image/jpeg");
                while((size = sImage.read(bytearray)) != -1) 
                {
                    response.getOutputStream().write(bytearray, 0, size);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
