package httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Servletcookies
 */
//@WebServlet("/Servletcookies")
public class Servletcookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
  final static Logger LOGGER=Logger.getLogger(Servletcookies.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String s=request.getParameter("userName");
		pw.print("hiii "+s);
		
		if(s.equals("satish"))
		{
			LOGGER.info("----if block----");
			pw.print("You are successfully logged in!");  
            pw.print("<br>Welcome, "+s);  
		Cookie ck=new Cookie("uname",s);
		response.addCookie(ck);
		  request.getRequestDispatcher("Servlet2").include(request, response);
		  //LOGGER.info("-----end if block---");
		}
		else {
			 LOGGER.info("------else block------");
			  pw.println("name should be correct");
			 request.getRequestDispatcher("ind").include(request,response);
			 LOGGER.error(request);
		}
		
	
	}
}
