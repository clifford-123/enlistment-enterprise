package com.orangeandbronze.test_jdbc;

import org.postgresql.ds.*;

public class RoomCapacityRetriever {

	public static void main(String[] args) {
		PGSimpleDataSource ds = new PGSimpleDataSource();
		ds.setDatabaseName("enlistment");
		ds.setUser("postgres");
		ds.setPassword("password");

	}
}
