package models;

import java.sql.*;

public class Rating{
	//################### FIELDS ########################
	private Integer ratingId;
	private String rating;
	private	User userId;
	private	Book bookId;

	//################### CONSTRUCTORS ########################
	public Rating(){
		
	}

	public Rating(String rating,User userId,Book bookId){
		super();
		this.rating = rating;
		this.userId = userId;
		this.bookId = bookId;
	}

	//################### OTHER-METHODS ########################
	public static String collectRating(Integer b_id){
		Connection con = null;
		String rating = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select avg(rating) from ratings where book_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,b_id);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				rating = rs.getString(1);
			}
		
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return rating;
	}


	public void giveRating(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "insert into ratings (user_id,book_id,rating) value (?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId.getUserId());
			pst.setInt(2,bookId.getBookId());
			pst.setString(3,rating);

			pst.executeUpdate();
		
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public static String collectSingleRating(Integer b_id,Integer u_id){
		Connection con = null;
		String rating = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select rating from ratings where book_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,b_id);
			pst.setInt(2,u_id);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				rating = rs.getString(1);
			}
		
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return rating;
	}

	//################### GETTER-SETTER ########################
	public Integer getRatingId(){
		return ratingId;
	}

	public void setRatingId(Integer ratingId){
		this.ratingId = ratingId;
	}

	public String getRating(){
		return rating;
	}

	public void setRating(String rating){
		this.rating = rating;
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
}