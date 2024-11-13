package com._4.OnlineStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        // Connection parameters
        String url = "jdbc:sqlserver://localhost:1433;TrustServerCertificate=True";
        String username = "sa";
        String password = "304#sa#pw";

        try {
            // Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Open a connection
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute query to get all databases
            String sql = "SELECT name FROM sys.databases";
            ResultSet rs = stmt.executeQuery(sql);

            // Print results
            System.out.println("\nList of databases:");
            while (rs.next()) {
                String dbName = rs.getString("name");
                System.out.println(dbName);
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\nConnection closed.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}