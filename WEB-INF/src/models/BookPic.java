package models;

import java.sql.*;
import java.util.ArrayList;

public class BookPic{
	private Integer bookPicId;
	private Book bookId;
	private String bookPic;

	public BookPic(){
	
	}

	public BookPic(Integer bookPicId,String bookPic){
		this.bookPicId = bookPicId;
		this.bookPic = bookPic;
	}


	//################### OTHER-METHODS ########################
	public static boolean saveBookPics(Integer bookId,ArrayList<String> bookPics){
		Connection con = null;
		Boolean flag = false;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "insert into book_pics (book_id,book_pic) value (?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,bookId);

			for(String bokPic : bookPics){
				ps.setString(2,bokPic);
				ps.executeUpdate();
			}
			
			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static String collectPic(int bkId){
		String picPath = null;

		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select book_pic from book_pics where book_id=? limit 1";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,bkId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				picPath = rs.getString(1);
			}			

		}catch(SQLException|ClassNotFoundException  e){
			e.printStackTrace();
		}finally{
			try{
				con.close();	
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return picPath;
	}

	public static void updateBookPics(Integer bookId,ArrayList<String> bookPics){
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "delete from book_pics where book_id ="+bookId;
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();

			query = "insert into book_pics (book_id,book_pic) value (?,?)";

			ps = con.prepareStatement(query);

			ps.setInt(1,bookId);
			
			for(String bookPic : bookPics){
				ps.setString(2,bookPic);
				ps.executeUpdate();
			}		

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

		
	//################### GETTER-SETTER ########################
	public void setBookPicId(Integer bookPicId){
		this.bookPicId = bookPicId;
	}

	public Integer getBookPicId(){
		return bookPicId;
	}

	public void setBookId(Book bookId){
		this.bookId = bookId;
	}

	public Book getBookId(){
		return bookId;
	}

	public void setBookPic(String bookPic){
		this.bookPic = bookPic;
	}

	public String setBookPic(){
		return bookPic;
	}
}