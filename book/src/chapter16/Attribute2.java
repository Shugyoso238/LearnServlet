package chapter16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class Attribute2
 */
@WebServlet("/chapter16/attribute2")
public class Attribute2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search("");
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("attribute2.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace(response.getWriter());
		}
	}

}
