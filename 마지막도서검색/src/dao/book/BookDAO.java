package dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.book.BookEntity;

public class BookDAO {

	public ArrayList<BookEntity> search(BookEntity entity) {
		ArrayList<BookEntity> result=new ArrayList<BookEntity>();
		try {
			Connection con=common.DBTemplate.getConnection();
			String sql="select * from books where btitle like ? or bauthor like ? or bisbn like ? ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,'%'+entity.getKeyword()+'%');
			pstmt.setString(2, '%'+entity.getKeyword()+'%');
			pstmt.setString(3, '%'+entity.getKeyword()+'%');
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BookEntity entitytemp=new BookEntity();
				entitytemp.setBtitle(rs.getString("btitle"));
				entitytemp.setBimgurl(rs.getString("bimgurl"));
				entitytemp.setBauthor(rs.getString("bauthor"));
				entitytemp.setBprice(rs.getInt("bprice"));
				entitytemp.setBisbn(rs.getString("bisbn"));
				result.add(entitytemp);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public ArrayList<BookEntity> listCart(String[] list) {
		ArrayList<BookEntity> result=new ArrayList<BookEntity>();
		try {
			Connection con=common.DBTemplate.getConnection();
			for(int i=0;i<list.length;i++){
				String sql="select * from books where bisbn=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,list[i]);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					BookEntity entitytemp=new BookEntity();
					entitytemp.setBtitle(rs.getString("btitle"));
					entitytemp.setBimgurl(rs.getString("bimgurl"));
					entitytemp.setBauthor(rs.getString("bauthor"));
					entitytemp.setBprice(rs.getInt("bprice"));
					entitytemp.setBisbn(rs.getString("bisbn"));
					result.add(entitytemp);
				}
				rs.close();
				pstmt.close();
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
}
