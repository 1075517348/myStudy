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

    /**
     * 一个数据库连接方法
     *
     * @return 返回一个数据库连接
     */
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

    /**
     * 向数据库添加数据
     *
     * @return 返回插入是否成功的boolean值
     */
    public static boolean insertData() {
        //上面访问数据库实例的方法调用获取一个连接对象实例
        Connection conn = JavaCon();
        //在连接对象的基础上创建会话对象
        try {
            Statement stmt = conn.createStatement();
            //插入数据库的SQL语句
            String sql = "Insert into Test VALUES('1','名字','性别','1989-10-13')";
            //插入数据库，并返回受影响行数
            int rs = stmt.executeUpdate(sql);
            //关闭会话对象
            stmt.close();
            //关闭连接对象
            conn.close();
            //如果受影响的数据大于0，就插入成功，否则失败
            return rs > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 删除数据库数据
     *
     * @return 返回删除是否成功的boolean值
     */
    public static boolean deleteData() {
        //上面访问数据库实例的方法调用获取一个连接对象实例
        Connection conn = JavaCon();
        try {
            //在连接对象的基础上创建会话对象
            Statement stmt = conn.createStatement();
            //删除数据的SQL语句
            String sql = "DELETE FROM Test WHERE id=1";
            //执行，并返回受影响行数
            int rs = stmt.executeUpdate(sql);
            //关闭会话对象
            stmt.close();
            //关闭连接对象
            conn.close();
            //如果受影响的数据大于0，就删除成功，否则失败
            return rs > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 修改数据库数据
     *
     * @return 返回修改是否成功的boolean值
     */
    public static boolean editData() {
        //上面访问数据库实例的方法调用获取一个连接对象实例
        Connection conn = JavaCon();
        try {
            //在连接对象的基础上创建会话对象
            Statement stmt = conn.createStatement();
            //修改数据的SQL语句
            String sql = "UPDATE Test SET name='梁文浩' WHERE id=1";
            //执行，并返回受影响行数
            int rs = stmt.executeUpdate(sql);
            //关闭会话对象
            stmt.close();
            //关闭连接对象
            conn.close();
            //如果受影响的数据大于0，就修改成功，否则失败
            return rs > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 查询数据库数据
     */
    public static void queryData() {
        //上面访问数据库实例的方法调用获取一个连接对象实例
        Connection conn = JavaCon();
        try {
            //在连接对象的基础上创建会话对象
            Statement stmt = conn.createStatement();
            //查询数据库的sql执行语句
            String sql = "SELECT * FROM Test;";
            //调用查询方法获得结果集
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("pid") + "name:" + rs.getString("name"));
            }
            //关闭会话对象
            stmt.close();
            //关闭连接对象
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            while (rs.next()) {

            }
            conn.close();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
