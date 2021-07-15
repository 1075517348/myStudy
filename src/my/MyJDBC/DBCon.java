package my.MyJDBC;

import java.sql.*;

/**
 * 用JDBC连接Mysql
 */
public class DBCon {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    /*
        1、MySQL 8.0 以上版本驱动包版本 mysql-connector-java-8.0.16.jar。
        2、com.mysql.jdbc.Driver 更换为 com.mysql.cj.jdbc.Driver。
        MySQL 8.0 以上版本不需要建立 SSL 连接的，需要显示关闭。
        allowPublicKeyRetrieval=true 允许客户端从服务器获取公钥。
        最后还需要设置 CST。
        加载驱动与连接数据库方式如下：
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/MyDb?useSSL=false
        &allowPublicKeyRetrieval=true&serverTimezone=UTC";
    */


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static Connection JavaCon() {
        try {
            //加载驱动程序
            Class.forName(JDBC_DRIVER);
            //创建数据库连接
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            return null;
        } catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            //加载驱动程序
            Class.forName(JDBC_DRIVER);
            //创建数据库连接
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from func");
            while(rs.next()){

            }
            conn.close();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
