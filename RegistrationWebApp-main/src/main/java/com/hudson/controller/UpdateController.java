package com.hudson.controller;

import java.io.IOException;

import com.hudson.dao.EmployeeDAO;
import com.hudson.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	 private EmployeeDAO employeeDAO;

	    @Override
		public void init() {
	        employeeDAO = new EmployeeDAO();
	    }

	    @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	    	String id = request.getParameter("id");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String contact = request.getParameter("contact");

	        Employee employee = new Employee();//model object

	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setUsername(username);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);
	        employee.setId(Integer.parseInt(id));

	        try {
	            employeeDAO.updateEmployee(employee);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        response.sendRedirect("success.jsp");
}
}