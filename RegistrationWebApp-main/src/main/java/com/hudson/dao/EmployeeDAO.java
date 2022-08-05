package com.hudson.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hudson.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeDAO {

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    public void updateEmployee(Employee employee) throws ClassNotFoundException{
    	String INSERT_USERS_SQL = "UPDATE employee SET first_name = ?, last_name = ?, username = ?, password = ?,"
    			+ "address = ?, contact = ? WHERE id = ?";

            Class.forName("com.mysql.cj.jdbc.Driver");
          //try with resources-> it will close automatically. You dont have handle finally block
            try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, employee.getFirstName());
                preparedStatement.setString(2, employee.getLastName());
                preparedStatement.setString(3, employee.getUsername());
                preparedStatement.setString(4, employee.getPassword());
                preparedStatement.setString(5, employee.getAddress());
                preparedStatement.setString(6, employee.getContact());
                preparedStatement.setInt(7, employee.getId());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.execute();

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
    }

    public void deleteEmployee(int id) throws ClassNotFoundException{
    	String DELETE_USERS_SQL = "DELETE FROM employee WHERE id = ?";

    	 Class.forName("com.mysql.cj.jdbc.Driver");
         //try with resources-> it will close automatically. You dont have handle finally block
           try (Connection connection = DriverManager
               .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

               // Step 2:Create a statement using connection object
               PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
               preparedStatement.setInt(1, id);
               preparedStatement.execute();
               } catch(SQLException e) {
            	   printSQLException(e);
               }
    }

    public void listAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException{
    	String SELECTALL_USERS_SQL = "SELECT id, first_name, last_name, username, address, contact FROM employee";
    	List<Map> list = new ArrayList<>();

    	 Class.forName("com.mysql.cj.jdbc.Driver");
         //try with resources-> it will close automatically. You dont have handle finally block
           try (Connection connection = DriverManager
               .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

               // Step 2:Create a statement using connection object
               PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL_USERS_SQL)) {
               ResultSet rs = preparedStatement.executeQuery();
               while(rs.next()) {
            	   int id = rs.getInt("id");
            	   String first_name = rs.getString("first_name");
            	   String last_name = rs.getString("last_name");
            	   String username = rs.getString("username");
            	   String address = rs.getString("address");
            	   String contact = rs.getString("contact");

            	   Map map = new HashMap();
            	   map.put("id", id);
            	   map.put("first_name", first_name);
            	   map.put("last_name", last_name);
            	   map.put("username", username);
            	   map.put("address", address);
            	   map.put("contact", contact);
            	   list.add(map);
               }

               } catch(SQLException e) {
            	   printSQLException(e);
               }
           request.setAttribute("list", list);
           request.getRequestDispatcher("/searchresult.jsp").forward(request,response);
    }

    public void listEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException{
    	String SELECTALL_USERS_SQL = "SELECT id, first_name, last_name, username, address, contact FROM employee"
    			+ " WHERE id = ?";
    	
    	List<Map> list = new ArrayList<>();

    	 Class.forName("com.mysql.cj.jdbc.Driver");
         //try with resources-> it will close automatically. You dont have handle finally block
           try (Connection connection = DriverManager
               .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

               // Step 2:Create a statement using connection object
               PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL_USERS_SQL)) {
        	   preparedStatement.setInt(1, Integer.parseInt((String) request.getAttribute("id")));
               ResultSet rs = preparedStatement.executeQuery();
               while(rs.next()) {
            	   int id = rs.getInt("id");
            	   String first_name = rs.getString("first_name");
            	   String last_name = rs.getString("last_name");
            	   String username = rs.getString("username");
            	   String address = rs.getString("address");
            	   String contact = rs.getString("contact");

            	   Map map = new HashMap();
            	   map.put("id", id);
            	   map.put("first_name", first_name);
            	   map.put("last_name", last_name);
            	   map.put("username", username);
            	   map.put("address", address);
            	   map.put("contact", contact);
            	   list.add(map);
               }

               } catch(SQLException e) {
            	   printSQLException(e);
               }
           request.setAttribute("list", list);
           request.getRequestDispatcher("/searchresult.jsp").forward(request,response);
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}