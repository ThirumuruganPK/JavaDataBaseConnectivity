package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String q1="insert into student values(?,?,?)";
		try(Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo?useSSL=false","root","root");
				PreparedStatement pst=con.prepareStatement(q1)){
				
				pst.setInt(1, 1);
				pst.setString(2, "thiur");
				pst.setString(3, "chennai");
				
				pst.executeUpdate();
				
				Statement st=con.createStatement();
				String q2="select * from student";
				//get the data from DB
				ResultSet rs=st.executeQuery(q2);
				while(rs.next()){
					System.out.println(rs.getInt(1) +" "+rs.getString(2)+ " "+rs.getString(3));
				}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
