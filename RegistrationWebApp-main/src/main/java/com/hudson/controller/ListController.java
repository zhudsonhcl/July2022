package com.hudson.controller;

import java.io.IOException;

import com.hudson.dao.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListController extends HttpServlet{
	 private EmployeeDAO employeeDAO;

	    @Override
		public void init() {
	        employeeDAO = new EmployeeDAO();
	    }

	    @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	        try {
	            employeeDAO.listAllEmployees(request, response);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
}
}