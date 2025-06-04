/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thinhthutha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBHelper {
    //-- JDBC API la mot thu vien hay la 1 framework de ho tro ket noi hay tuong tac voi DBMS 
    //chi viet 1 lan bat chap su dung dung DBMS nao.
    public static Connection makeConnection()
    throws ClassNotFoundException, SQLException{
        //Buoc 12
        //1. load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. tao connection String de ket noi voi container
        //syntax: jdbc:sqlserver://ip:port;databaseName=...
        //dau "/" bien thanh dau ";"
        //jdbc bi phu thuoc vao dbms va dmbs khac nhau va chuan khac nhau
        String url = "jdbc:sqlserver://"
                + "localhost:1433;"
                + "databaseName=THINHNVC";
        //3. Mo ket noi su dung Driver Manager
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
