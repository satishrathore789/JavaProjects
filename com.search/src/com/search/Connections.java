package com.search;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connections {
	private static Connection con;

    public static Connection getCon() {
        try {
        	
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
            }
        	
        } catch (SQLException|ClassNotFoundException exception) {
            exception.printStackTrace();
    
        }
        return con;
    }


}
