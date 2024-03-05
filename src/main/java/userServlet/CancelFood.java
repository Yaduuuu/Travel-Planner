package userServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import connection.ConnectionString;

/**
 * Servlet implementation class CancelFood
 */
@WebServlet("/CancelFood")
public class CancelFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodType = request.getParameter("foodType");
		String foodName = request.getParameter("foodName");
		String packagename = request.getParameter("packagename");
		String place = request.getParameter("place");
		HttpSession session = request.getSession();
		
		try{
			Connection con=ConnectionString.getCon();//getting db connection
			PreparedStatement ps = con.prepareStatement("delete from bookfood where type='"+foodType+"'and foodName='"+foodName+"'and packagename='"+packagename+"'and place='"+place+"'and email='"+session.getAttribute("email")+"'");
			ps.executeUpdate();
			response.sendRedirect("User/ModifyFood.jsp");
			
			} catch (Exception e) {
			e.printStackTrace();
			}
	}

}
