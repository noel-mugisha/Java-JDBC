package com.rca.app.jdbcservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String studentClass = req.getParameter("class");
        int age = Integer.parseInt(req.getParameter("age"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/classDb";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name, class, age) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, studentClass);
            ps.setInt(3, age);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }
}
