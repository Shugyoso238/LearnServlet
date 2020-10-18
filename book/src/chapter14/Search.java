package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

/**
 * Servlet implementation class Search
 */
@WebServlet("/chapter14/search")
public class Search extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try
		{
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();
			
			String keyword = request.getParameter("keyword");
			PreparedStatement st = con.prepareStatement("select * from PRODUCT where NAME like ?");
			st.setString(1, "%"+keyword+"%");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				out.println(rs.getInt("ID"));
				out.println("：");
				out.println(rs.getString("NAME"));
				out.println("：");
				out.println(rs.getInt("PRICE"));
				out.println("<br>");
			}
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(out);
		}
		
		Page.footer(out);
	}

}
