package httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletCookies2
 */
//@WebServlet("/ServletCookies2")
public class ServletCookies2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = null;
		try {
				pw = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Cookie  ck[]  =request.getCookies();
		    if(ck!=null)
		    {
		    	String name=ck[0].getValue();
		    	if(!name.equals("")||name!=null)
		    		pw.print("welcome  "+name);
		    } 
		  	else
			{
				pw.println("login first then ");
			//	pw.println("hi man");
			//	pw.println("its not a easy task");
				try {
					request.getRequestDispatcher("index").include(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}	
			
			
		
	}

}
