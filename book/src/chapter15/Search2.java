package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

/**
 * Servlet implementation class Search2
 */
@WebServlet("/chapter15/search2")
public class Search2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try
		{
			String keyword = request.getParameter("keyword");
			
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search(keyword);
			
			for(Product p: list)
			{
				out.println(p.getId());
				out.println("：");
				out.println(p.getName());
				out.println("：");
				out.println(p.getPrice());
				out.println("<br>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace(out);
		}
		
		
		Page.footer(out);
	}

}