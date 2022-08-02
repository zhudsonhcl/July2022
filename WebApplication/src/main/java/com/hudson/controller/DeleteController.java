package com.hudson.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hudson.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				
				res.setContentType("text/html");
				String uname=req.getParameter("un");
				String pwd="";
				
				User u1 = new User();
				u1.setUsername(uname);
				u1.setPassword(pwd);
				
				try {
					u1.deleteUser();
				} catch (ClassNotFoundException e) {
					System.out.println(e);
				} catch (SQLException e) {
					System.out.println(e);
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
	}
				protected void doGet(HttpServletRequest req,HttpServletResponse res)
							throws ServletException,IOException{
					 doPost(req,res);
				}
}
