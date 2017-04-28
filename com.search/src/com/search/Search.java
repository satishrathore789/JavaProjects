package com.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       final static Logger LOGGER=Logger.getLogger(Search.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Connection con=Connections.getCon();
		String Name=request.getParameter("NewFirstName");
		String mobile=request.getParameter("Phone Number");
		String email=request.getParameter("EmailAddress");
		String builder=null;
		Statement stmt;
		if(!Name.isEmpty()||!mobile.isEmpty()||!email.isEmpty())
		{
			if(!Name.isEmpty()&&!mobile.isEmpty()&&!email.isEmpty())
		    builder="select *from registration where name='"+Name+"'and mobile='"+mobile+"' and email='"+email+"'" ;
			else if(!Name.isEmpty()&&!mobile.isEmpty())
             builder="select *from registration where name='"+Name+"'and mobile='"+mobile+"'";
			else if(!email.isEmpty())
			  builder="select *from registration where email='"+email+"'";
			else if(!Name.isEmpty()&&!email.isEmpty())
				builder="select *from registration where name='"+Name+"' and email='"+email+"'";
			else if(!mobile.isEmpty())
				builder="select *from registration where  mobile='"+mobile+"'";
			else if(!mobile.isEmpty()&&!email.isEmpty())
				builder="select *from registration where  mobile='"+mobile+"' and email='"+email+"'";
			else if(!Name.isEmpty())
				builder="select *from registration where  name='"+Name+"'";
			}
		else
		{
	    pw.println("-----all values are empty---------");
		LOGGER.error("------all null set-----------");
		}
		try {
			stmt=con.createStatement();
			ResultSet resultSet=(ResultSet) stmt.executeQuery(builder);
			boolean b=resultSet.next();
			if(b)
			{
			while(resultSet.next())
			{
				LOGGER.info("---i am in while block--");
			pw.println(resultSet.getString(1)+"--"+resultSet.getString(2)+"--"+resultSet.getString(3)+"--"+resultSet.getString(4)+"<br>");
			}
			}
			else
			{
			  LOGGER.info("not match with database");	
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("----i am in catch block------------"+e.getMessage());
			e.printStackTrace();
		}
		
	}
		
		
	}


