package com.hudson.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hudson.model.User;
//Controller-> Navigates between your model and view
@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String uname=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		
		User u1=new User();
		u1.setUsername(uname);
		u1.setPassword(pwd);
		req.setAttribute("abc", u1);
		 
		
		try {
		boolean status = u1.validateUserNamePwd();
		
		//model
		if(status) {
			 RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
			 rd.forward(req, res);
		
		}else {
			 RequestDispatcher rd=req.getRequestDispatcher("failure.jsp");
			 rd.forward(req, res);			 
		}
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	} 
		protected void doGet(HttpServletRequest req,HttpServletResponse res)
					throws ServletException,IOException{
			 doPost(req,res);
		}
	
}
