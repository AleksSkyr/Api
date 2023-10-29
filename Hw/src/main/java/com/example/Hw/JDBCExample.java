package com.example.Hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/ind11";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                var id = rs.getLong("id");
                var name = rs.getString("name");
                var age = rs.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}