package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment6{
	static Connection con;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//Set connection to the julyfsd database
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "root");
		
		//Setting up test data for new database
		
		//addUser(1, "Bob", 26);
		//addUser(2, "Jessie", 30);
		//addUser(3, "Walter", 22);
		//addUser(4, "Sandra", 37);
		//addUser(5, "Josh", 20);
		//addUser(6, "Pinnochio", 28);
		
		//Set up scanner to receive input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello user, type which option you would like to perform?");
		System.out.println("1: Get list of employees");
		System.out.println("2: Update an employee");
		System.out.println("3: Delete an employee");
		System.out.println("4: Get an employee" + "\n");
		
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			getList();
			break;
			
		case 2:
			System.out.println("Which update would you like to perform?");
			System.out.println("1: Update name");
			
			System.out.println("2: Update age");
			int updateOption = scanner.nextInt();
			if(updateOption == 1) {
				System.out.println("Input user id");
				int user = scanner.nextInt();
				System.out.println("Input name to change to");
				String name = scanner.nextLine();
				updateUserName(user, name);
			}
			else if(updateOption == 2) {
				System.out.println("Input user id");
				int user = scanner.nextInt();
				System.out.println("Input age to change to");
				int age = scanner.nextInt();
				updateUserAge(user, age);
			}
			else {
				System.out.println("Invalid input");
			}
			break;
			
		case 3:
			System.out.println("Input user id");
			int delUser = scanner.nextInt();
			deleteUser(delUser);
			break;
			
		case 4:
			System.out.println("Input user id");
			int getUser = scanner.nextInt();
			getUser(getUser);
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	
	//Problem I: get the list of employees
	public static void getList() throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from emp");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getInt(3));
        }
	}
	
	public static void addUser(int id, String name, int age) throws SQLException {
		PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, age);
		int x = pst.executeUpdate();
		System.out.println(x+" record(s) inserted");
	}
	
	//Problem II: update existing employee based on id
	public static void updateUserName(int id, String name) throws SQLException {
		CallableStatement cst = con.prepareCall("{call updateEmpName(?,?)}");
		cst.setInt(1, id);
		cst.setString(2, name);
		cst.execute();
		System.out.println("callablestatement record inserted");
	}
	
	public static void updateUserAge(int id, int age) throws SQLException{
		CallableStatement cst = con.prepareCall("{call updateEmpAge(?,?)}");
		cst.setInt(1, id);
		cst.setInt(2, age);
		cst.execute();
		System.out.println("callablestatement record inserted");
	}
	
	//Problem III: delete employee based on ID
	public static void deleteUser(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from emp where id=?");
		pst.setInt(1, id);
		int x = pst.executeUpdate();
		System.out.println(x + " record(s) deleted");
		
	}
	
	//Problem IV: get employee based on ID
	public static void getUser(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from emp where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
            System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getInt(3));
        }
	}
	
}
