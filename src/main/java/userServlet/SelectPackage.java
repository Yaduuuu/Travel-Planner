package userServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import connection.ConnectionString;

/**
 * Servlet implementation class SelectePackage
 */
@WebServlet("/SelectPackage")
public class SelectPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cost = request.getParameter("cost");
		HttpSession session =request.getSession();
		
		try{
			Connection con=ConnectionString.getCon();//getting db connection
			PreparedStatement ps = con.prepareStatement("select cost from package where cost= '"+cost+"'");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			rs.getString(1);
			session.setAttribute("cost1", rs.getString(1));
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
