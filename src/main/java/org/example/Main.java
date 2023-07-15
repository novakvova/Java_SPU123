package org.example;

import java.sql.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String databaseName="java_salo";
    public static void main(String[] args) {
        System.out.println("Привіт козаки");
        // Load the MariaDB JDBC driver
        //createDatabase();
        //createTable();
        insertDataTable();
    }
    public static void createDatabase() {
        String url = "jdbc:mariadb://localhost:3306";
        String user="root";
        String password="123456";
        String dbName = "";
        try(Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Вкажіть назву БД:");
            Scanner in = new Scanner(System.in);
            dbName = in.nextLine();
            // Create a Statement object to execute SQL statements
            Statement stmt = con.createStatement();
            // SQL query to check if the database exists
            String checkDbQuery = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
            // Execute the query to check if the database exists
            ResultSet rs = stmt.executeQuery(checkDbQuery);
            // Check if the result set has any rows (database exists)
            boolean databaseExists = rs.next();
            rs.close();
            if (databaseExists) {
                System.out.println("-------База з даним ім'ям уже існує-------.");
            } else {
                // SQL query to create the new database
                String createDbQuery = "CREATE DATABASE " + dbName;
                // Execute the query to create the database
                stmt.executeUpdate(createDbQuery);
                System.out.println("Базу даних створнео успішно :)");
            }
            // Close the Statement and Connection
            stmt.close();
        }
        catch(Exception ex) {
            System.out.println("Problem connection database "+ ex.getMessage());
        }
    }
    public static void createTable() {
        String url = "jdbc:mariadb://localhost:3306/"+databaseName;
        String user="root";
        String password="123456";
        String dbName = "";
        try(Connection con = DriverManager.getConnection(url, user, password)) {
            // Create a Statement object to execute SQL statements
            Statement stmt = con.createStatement();

            // SQL query to create a table
            String createTableQuery = "CREATE TABLE users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) NOT NULL" +
                    ")";

            // Execute the query to create the table
            stmt.executeUpdate(createTableQuery);
            System.out.println("Таблиця користувачі створено успішно");
            stmt.close();
        }
        catch(Exception ex) {
            System.out.println("Problem connection database "+ ex.getMessage());
        }
    }
    public static void insertDataTable() {
        String url = "jdbc:mariadb://localhost:3306/"+databaseName;
        String user="root";
        String password="123456";
        try(Connection con = DriverManager.getConnection(url, user, password)) {
            // Create a Statement object to execute SQL statements
            Statement stmt = con.createStatement();
            // Create a statement
            PreparedStatement statement = con.prepareStatement("INSERT INTO users (username, email) VALUES (?, ?)");
            // Set the parameters
            statement.setString(1, "ivan");
            statement.setString(2, "ivan@example.com");
            // Execute the statement
            int rowsAffected = statement.executeUpdate();
            System.out.println("Успішно додано дані");
            stmt.close();
        }
        catch(Exception ex) {
            System.out.println("Problem connection database "+ ex.getMessage());
        }
    }
}