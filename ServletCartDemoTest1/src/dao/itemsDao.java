/**
 * @author LZD		2018/02/08
 */
/*
 * ��Ʒ��ҵ���߼���
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import entity.Item;
import util.DBHelper;


public class itemsDao {
	
	//��ȡ������Ʒ��Ϣ
	public ArrayList<Item> getAllItems() {

		//������Ҫ�Ķ���
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from items;";
		
		//��ȡ������Ʒ�ļ���
		ArrayList<Item> items = new ArrayList<>();
		
		//��ȡ���ݿ�����
		conn = DBHelper.getConnection();
		try {
			//��ý����
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//������õĽ����
			/*
			 * int id, String name, String city,
			 * int price, int number, String picture
			 */
			while(rs.next()) {
				Item i = new Item(rs.getInt("id"), rs.getString("name"),
						rs.getString("city"), rs.getInt("price"),
						rs.getInt("number"), rs.getString("picture"));
				System.out.println(i);
				items.add(i);
			}
			
			return items;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			//�ر���Դ
			if(rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	//��ȡ��Ʒ����
	public Item getItemById(int id) {
		Item i = null;
		String sql = "select * from items where id = ?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = new Item(rs.getInt("id"), rs.getString("name"),
						rs.getString("city"), rs.getInt("price"),
						rs.getInt("number"), rs.getString("picture"));
				return i;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
