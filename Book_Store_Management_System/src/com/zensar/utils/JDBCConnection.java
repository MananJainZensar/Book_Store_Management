package com.zensar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static Connection con = null;

    public static Connection createDBConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/book_store";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverClass);
            System.out.println("Driver Class Initialized");

            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(dbUrl, "root", "root");
                System.out.println("Connection to DB book_store Successful !");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found Exception: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return con;
    }

    public static void closeDBConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Connection to DB book_store closed.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}