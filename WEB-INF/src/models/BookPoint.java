package models;

import java.sql.*;
import java.util.ArrayList;
public class BookPoint{
	private Integer bookPointId;
	private Book bookId;
	private String pointHeader;
	private String pointValue;
	//################### CONSTRUCTOR ########################
	public BookPoint(){
	
	}

	public BookPoint(Book bookId,String pointHeader,String pointValue){
		this.bookId = bookId;
		this.pointHeader = pointHeader;
		this.pointValue = pointValue;
	}

	
	public BookPoint(Integer bookPointId,String pointHeader,String pointValue){
		this.bookPointId = bookPointId;
		this.pointHeader = pointHeader;
		this.pointValue = pointValue;
	}

	//################### OTHER-METHODS ########################
	public static boolean saveBookPoints(Integer bookId,String[] pointTitels,String[] pointValues){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "insert into book_points (book_id,point_header,point_value) value (?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1,bookId);

			for(int i=0;i<pointTitels.length;i++){
				
				pst.setString(2,pointTitels[i]);
				pst.setString(3,pointValues[i]);

				int rs = pst.executeUpdate();
				if(rs >= 1){
					flag = true;
				}			
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
		return flag;
	}


	public static ArrayList<BookPoint> collectPoints(int bookid){
		Connection con = null;
		ArrayList<BookPoint> collBkps = new ArrayList<BookPoint>(); 

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_point_id,point_header,point_value from book_points where book_id = "+bookid;

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				collBkps.add(new BookPoint(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return collBkps;
	}

    public static void updateBookPoints(Integer bookId,String[] pnames,String[] pvalues){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "delete from book_points where book_id ="+bookId;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();

			query = "insert into book_points (book_id,point_header,point_value) value (?,?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1,bookId);

			for(int i=0;i<pnames.length;i++){
				
				pst.setString(2,pnames[i]);
				pst.setString(3,pvalues[i]);

				pst.executeUpdate();
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
	public Integer getBookPointId(){
		return bookPointId;
	}

	public void setBookPointId(Integer bookPointId){
		this.bookPointId = bookPointId;
	}

	public Book getBookId(){
		return bookId;
	}

	public void setBookId(Book bookId){
		this.bookId = bookId;
	}

	public String getPointHeader(){
		return pointHeader;
	}

	public void setPointHeader(String pointHeader){
		this.pointHeader = pointHeader;
	}

	public String getPointValue(){
		return pointValue;
	}

	public void setPointValue(String pointValue){
		this.pointValue = pointValue;
	}
}