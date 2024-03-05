package userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import connection.ConnectionString;
import java.sql.*;

/**
 * Servlet implementation class SelectPlace
 */
@WebServlet("/SelectPlace")
public class SelectPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packagename =  request.getParameter("packagename");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			Connection con=ConnectionString.getCon();//getting db connection
			PreparedStatement ps = con.prepareStatement("select place from bookpackage where packagename ='"+packagename+"' and email='"+session.getAttribute("email")+"'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
