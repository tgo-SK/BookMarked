package models;

import java.sql.*;
import java.util.*;

public class Category{
	private Integer categoryId;
	private String category;

	public Category(){
		
	}

	public Category(Integer categoryId){
		this.categoryId = categoryId;
	}

	public Category(Integer categoryId,String category){
		this.categoryId = categoryId;
		this.category = category;
	}

	//################### OTHER-METHODS ########################
	public static ArrayList<Category> collectCategory(){
		ArrayList<Category> cat = new ArrayList<Category>();
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select category_id,category from categories";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				cat.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){e.printStackTrace();}
		}
		return cat;
	}


	public String returnCategory(){
		String cat = null;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select category from categories where category_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,categoryId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				cat = rs.getString(1);

				setCategory(cat);
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){e.printStackTrace();}
		}
		return cat;
	}

	//################## GETTER-SETTER ########################
	public Integer getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public String getCategory(){
		return category;
	}

	public void setCategory(String category){
		this.category = category;
	}
}