/**
 * @author LZD		2018/02/08
 */
/*
 * �������ݿ�����
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	//���ݿ������Լ���¼�����ݿ�·��
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "1219";
	private static final String url = "jdbc:mysql://localhost:3306"
			+ "/shopping?useUnicode=true&characterEncoding=UTF-8";
	
	//�������Ӷ���
	private static Connection conn = null;
	
	//��̬����鸺���������
	static {
		try {
			Class.forName(driver);
			System.out.println("�ѳɹ���������");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
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
	
	//���Դ���
	public static void main(String[] args) {
		
		Connection conn = DBHelper.getConnection();
		if(conn != null) {
			System.out.println("���ݿ���������");
		}else {
			System.out.println("���ݿ������쳣");
		}
	}
	
	
}
