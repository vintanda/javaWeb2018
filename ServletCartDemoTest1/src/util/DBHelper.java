/**
 * @author LZD		2018/02/08
 */
/*
 * 加载数据库连接
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	//数据库驱动以及登录和数据库路径
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "1219";
	private static final String url = "jdbc:mysql://localhost:3306"
			+ "/shopping?useUnicode=true&characterEncoding=UTF-8";
	
	//创建连接对象
	private static Connection conn = null;
	
	//静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
			System.out.println("已成功加载驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
	}
	
	//测试代码
	public static void main(String[] args) {
		
		Connection conn = DBHelper.getConnection();
		if(conn != null) {
			System.out.println("数据库连接正常");
		}else {
			System.out.println("数据库连接异常");
		}
	}
	
	
}
