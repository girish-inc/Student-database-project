package com.itvedant.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    static Connection con = null;
    public static Connection getConnection(){

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "Pass@123";
        con = DriverManager.getConnection(url, user, pass);
        if (con.isClosed()) {
            System.out.println("Connection is not created");
        } else {
            System.out.println("Hurray! connection is created!");
        }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
    return con;
    }
    public static void closeConnection(){
        try{
            con.close();
        }catch (Exception e){
      System.out.println(e.getMessage());
        }
    }
}
