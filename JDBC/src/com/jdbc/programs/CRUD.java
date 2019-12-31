package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {
	static Connection con=null;
	static PreparedStatement pst=null;
	static Scanner sc=new Scanner(System.in);
	static Statement st=null;
	public static void add(){
		try {
			System.out.println("enter your id:");
			int sid =sc.nextInt();
			System.out.println("enter your name:");
			String sname =sc.next();
			System.out.println("enter your city:");
			String scity =sc.next();
			pst=con.prepareStatement("insert into student values(?,?,?)");
			pst.setInt(1, sid);
			pst.setString(2, sname);
			pst.setString(3, scity);
			pst.executeUpdate();
			System.out.println("Recorder inserted..!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void view(){
		try {
			System.out.println("enter student id:");
			int sid =sc.nextInt();
			pst=con.prepareStatement("select * from student where sid =?");
			pst.setInt(1, sid);
			ResultSet set=pst.executeQuery();
			while(set.next()){
				System.out.println(set.getInt(1)+set.getString(2)+set.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		try {
			System.out.println("enter student id:");
			int sid =sc.nextInt();
			pst=con.prepareStatement("delete from student where sid=?");
			pst.setInt(1, sid);
			pst.executeUpdate();
			System.out.println("Record Deleted..!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update(){
		try {
			System.out.println("enter city:");
			String scity =sc.next();
			System.out.println("enter id:");
			int sid =sc.nextInt();
			pst=con.prepareStatement("update student set scity=? where sid=?");
			pst.setString(1, scity);
			pst.setInt(2, sid);
			pst.executeUpdate();
			System.out.println("Record Updated..!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void AfterUpdate(){
		try {
			String q1="select * from student";
			st=con.createStatement();
			ResultSet set=st.executeQuery(q1);
			while(set.next()){
				
				System.out.println(set.getInt(1)+set.getString(2)+set.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// manipute the data by CRUD operation in student table
		try{
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo?useSSL=false","root","root");
			add();
			view();
			delete();
			update();
			AfterUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

}
