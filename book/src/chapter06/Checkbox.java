package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Checkbox
 */
@WebServlet("/chapter6/checkbox")
public class Checkbox extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String[] genre = request.getParameterValues("genre");
		
		Page.header(out);
		if(genre != null)
		{
			for(String item : genre)
			{
				out.println("「" + item + "」");
			}
			out.println("に関するお買いもの情報をお送りします。");
		}
		else
		{
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out);
	}

}
