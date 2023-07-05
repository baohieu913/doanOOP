package com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDatabase {
//    public static void main(String[] args) {
//        Connection conn = null;
//
//        try {
//
//            String dbURL = "jdbc:sqlserver://LAPTOP-747FVP6Q\\SQLEXPRESS:1433;database=OPP_QLTV_N5_66IT5;encrypt=true;trustServerCertificate=true";
//            String user = "sa";
//            String pass = "123456";
//            conn = DriverManager.getConnection(dbURL, user, pass);
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (conn != null && !conn.isClosed()) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
    public Connection databaseLink;

    public Connection getConnection() {
        String dbURL = "jdbc:sqlserver://LAPTOP-747FVP6Q\\SQLEXPRESS:1433;database=OOP_QLTV_N5_IT5;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            databaseLink = DriverManager.getConnection(dbURL,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;

    }
}
