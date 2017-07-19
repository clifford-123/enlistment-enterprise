package com.orangeandbronze.test_jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.ds.PGSimpleDataSource;

public class RoomInfoRetriever {

	public static void main(String[] args) {    
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("postgres");
        ds.setCurrentSchema("enlistment");
        ds.setUser("postgres");
        ds.setPassword("postgres");
        try (Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM rooms")) {
        	while (rs.next()) {
                System.out.println(rs.getString("room_name") 
                        + " - " + rs.getInt("capacity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
