package chapter05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Greeting
 */
@WebServlet("/chapter5/greeting")
public class Greeting extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		
		Page.header(out);
		if(user != null && !user.equals(""))
		{
			out.println("<p>こんにちは，" + user + "さん！</p>");
		}
		else
		{
			out.println("<p>名前を取得できませんでした。</p>");
		}
		Page.footer(out);
	}

}
