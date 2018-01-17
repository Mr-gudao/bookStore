package bookstore.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Create by wdb on 2017/10/26 15:47
 */
public class jdbcUtil {


    private static String url;
    private static String driverClass;
    private static String user;
    private static String password;



    static {
        try {


            ClassLoader cl = jdbcUtil.class.getClassLoader();

            InputStream inputStream = cl.getResourceAsStream("/bookstore/user/util/jdbc.properties");

            Properties info = new Properties();

            info.load(inputStream);

            driverClass = info .getProperty("driverClass");
            url = info.getProperty("url");
            user = info.getProperty("user");
            password = info.getProperty("password");


            Class.forName(driverClass);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException("你Driver类的路径写错了");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public static Connection getConnection(){
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(
                url,
                user,
                password
        );
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("出现了错误!");

    }

    return conn;

}

    public  static  void close(ResultSet rs){

        close(rs,null,null);
    }

    public  static  void close(Statement stt){

        close(null,stt,null);
    }

    public  static  void close(Connection conn){

        close(null,null,conn);
    }


    public static void close(ResultSet rs , Statement stt,Connection conn){

    if (rs != null){

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (stt != null){
        try {
            stt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   if (conn != null){
       try {
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }


    }

}
