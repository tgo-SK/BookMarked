package models;

import java.sql.*;
import java.util.ArrayList;

public class Purchase{
	private Integer purchaseId;
	private Integer purchaseType;
	private User userId;
	private Book bookId;

	//################### CONSTRUCTORS ########################

	//################### OTHER-METHODS ########################
	public static void savePurchasedBook(Integer userId,Integer bookId,Integer purchaseType){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "insert into purchase (user_id,book_id,purchase_type) value (?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1,userId);
			pst.setInt(2,bookId);
			pst.setInt(3,purchaseType);

			pst.executeUpdate();

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}	
	
	
	public ArrayList<Book> recentBooks(Integer userId){
		Connection con = null;
		ArrayList<Book> recentBks = new ArrayList<Book>(); 

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select books.book_id,title,author,price,file_type_id from books inner join purchase on books.book_id = purchase.book_id where user_id = "+userId;

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				recentBks.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),new FileType(rs.getInt(5))));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return recentBks;
	}

	public static boolean checkPurchase(Integer userId,Integer bookId){
		Connection con = null;
		Boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "select purchase_id from purchase where user_id=? and book_id=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1,userId);
			pst.setInt(2,bookId);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				flag = true;
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	//################### GETTER-SETTER ########################
	public Integer getPurchaseId(){
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId){
		this.purchaseId = purchaseId;
	}

	public User getUserId(){
		return userId;
	}

	public void setUserId(User userId){
		this.userId = userId;
	}

	public Book getBookId(){
		return bookId;
	}

	public void setBookId(Book bookId){
		this.bookId = bookId;
	}

	public Integer getPurchaseType(){
		return purchaseType;
	}

	public void setPurchaseType(Integer purchaseType){
		this.purchaseType = purchaseType;
	}
}