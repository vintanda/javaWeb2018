/**
 * @author LZD		2018/02/08
 */
/*
 * 商品的业务逻辑类
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
	
	//获取所有商品信息
	public ArrayList<Item> getAllItems() {

		//定义需要的对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from items;";
		
		//获取所有商品的集合
		ArrayList<Item> items = new ArrayList<>();
		
		//获取数据库连接
		conn = DBHelper.getConnection();
		try {
			//获得结果集
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//遍历获得的结果集
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
			//关闭资源
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
	
	
	//获取商品详情
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
