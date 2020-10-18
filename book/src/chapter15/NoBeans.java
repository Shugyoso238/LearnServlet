package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class NoBeans
 */
@WebServlet("/chapter15/nobean")
public class NoBeans extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		int id = 1;
		String name = "まぐろ";
		int price = 100;
		
		out.println(id);
		out.println("：");
		out.println(name);
		out.println("：");
		out.println(price);
		
		Page.footer(out);
	}

}
