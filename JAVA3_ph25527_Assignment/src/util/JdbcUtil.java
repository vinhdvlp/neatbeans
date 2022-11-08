/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JdbcUtil {

    private static Connection conn;

    public static Connection getConnection() {
        if (JdbcUtil.conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123456", dbUrl = "jdbc:sqlserver://localhost:1433" + ";databaseName = ASSIGNMENT_PH25527_JAVA3";
                JdbcUtil.conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

}
