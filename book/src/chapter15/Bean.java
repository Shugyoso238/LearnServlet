package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Page;

/**
 * Servlet implementation class Bean
 */
@WebServlet("/chapter15/bean")
public class Bean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		Product p = new Product();
		
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);
		
		out.println(p.getId());
		out.println("：");
		out.println(p.getName());
		out.println("：");
		out.println(p.getPrice());
		
		Page.footer(out);
	}

}
