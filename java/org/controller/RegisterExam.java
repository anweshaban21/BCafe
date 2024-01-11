package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mis.ConnectSql;


/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterHere")
public class RegisterExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterExam() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String phno=request.getParameter("contact");
	String pass=request.getParameter("pass");
	//String answer=request.getParameter("address");
	HttpSession session=request.getSession();
	

	Connection con;
	Connection conn;
	//Connection conn;
	PreparedStatement pstm;
	PreparedStatement pstm2;
	//PreparedStatement pstm2;
	
	
	String Name=null;
	String email2 = null;
	String phn=null;
	String pass2=null;
	 con = null;
	 conn=null;
	 pstm = null;
	ResultSet rs = null;
	boolean status=true;
	try {
	con= ConnectSql.createC2();
	pstm = con.prepareStatement("select * from user");
	rs = pstm.executeQuery();

	while (rs.next()) {
	Name=rs.getString(1);
	email2=rs.getString(2);
	phn=rs.getString(3);
	pass2=rs.getString(4);
	if(email.equals(email2))
		status=false;
	
	}
	}catch(Exception e) {};
	
	if(status) {
	try
	{
		conn=ConnectSql.createC2();
		pstm2=conn.prepareStatement("insert into user(name,email,phno,pass) values(?,?,?,?);");
		pstm2.setString(1, name);
		pstm2.setString(2, email);
		pstm2.setString(3, phno);
		pstm2.setString(4, pass);
		pstm2.executeUpdate();
	}catch(Exception e) {}
		response.sendRedirect("regExam.jsp");
	}
	else {
		response.sendRedirect("demo2.jsp");
	}
	
	
	}

}
