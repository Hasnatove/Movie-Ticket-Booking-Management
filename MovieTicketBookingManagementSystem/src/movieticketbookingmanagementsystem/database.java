/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketbookingmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
class database {
        public static Connection connectDb() {
        try {
            String url = "jdbc:mysql://localhost:3306/moviebook"; 
            String user = "root"; //
            String password = ""; 

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
