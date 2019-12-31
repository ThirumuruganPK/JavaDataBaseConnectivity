package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Adaper implements Runnable{
	public void run(){}
}
public class Test extends Adaper{
	public void run(){
		System.out.println("Hi this is Adapter clas method");
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		new Test().run();
		// step 1: load the driver
		//Class.forName("com.mysql.jdbc.Driver"); //optional
		System.out.println("driver load successfuly");
		
		//step 2: create connection
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo?useSSL=false","root","root");
		System.out.println("connection successful");
		
		//step 3: write a query
		//String q1="CREATE TABLE student (sid INT,sname VARCHAR(30),scity VARCHAR(30))";
		
		String q2="CALL addStudent;";
		//step 4: execute the query--> to execute the query first we have to create the statement object
		//then,by using the statement object execute the query by their methods
		Statement statement = con.createStatement();
		//int x=statement.executeUpdate(q1);
		//System.out.println("statement execute successful" + x);
		int x=statement.executeUpdate(q2);
		System.out.println("statement execute successful " + x);
		
		//step 5: close the connection
		con.close();
		System.out.println("close the connecton sucessfully");
		
		
		
	}
}