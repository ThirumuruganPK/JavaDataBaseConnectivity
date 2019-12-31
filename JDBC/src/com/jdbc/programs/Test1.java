package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(null); //loading class or driver
			Connection con=DriverManager.getConnection(null);//getconnection
			String s1=" ";//write query
			Statement st=con.createStatement();//process 
			st.execute(s1);
			con.close();
			//close
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
