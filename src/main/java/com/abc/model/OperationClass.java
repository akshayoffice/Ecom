package com.abc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abc.bean.Customer;
import com.abc.bean.SignInPOJO;

public class OperationClass {
	public static Connection  getConnection(){
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/ecomzone";
	final String user = "root";
	final String password = "";
	Connection conn = null;
	
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	public static void connectionClose(){
		try{
		getConnection().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean userValidate(SignInPOJO signInPOJO){
		
		//Connection conn = getConnection();// getting connection object
		PreparedStatement stmt;
		boolean flag = false;
		try {
			String sql = "select count(*) from customer where email =?  and password = ?";
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, signInPOJO.getEmail());
			stmt.setString(2, signInPOJO.getPassword());
			
			flag =  true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public static List<Customer> getUserName(String email){
		System.out.println("sign in email value is "+email);
		PreparedStatement stmt;
		List<Customer> customerList = new ArrayList<Customer>();
		try{
			String sql = "select firstName,lastName from customer where email = ?";
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			//System.out.println("outside rs next ");
			while(rs.next()){
				//System.out.println("inside rs next while loop");
				Customer customerObj = new Customer();
				customerObj.setFirstName(rs.getString("firstName"));
				customerObj.setLastName(rs.getString("lastName"));
				//System.out.println("frist name is "+rs.getString("firstName")+"last name is "+rs.getString("lastName"));
				customerList.add(customerObj);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			
		}finally{
			connectionClose();
		}
		
		return customerList;
	}
}
