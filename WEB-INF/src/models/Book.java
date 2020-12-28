package models;

import java.sql.*;
import java.util.ArrayList;

public class Book{
	//################### FIELDS ########################
	private Integer bookId;
	private Category category;
	private FileType fileType;
	private String title;
	private String author;
	private String description;	
	private Integer price;	
	private String payment;
	private String bookFile;

	//############# CONSTRUCTORS ########################
	public Book(){
	}

    public Book(Integer bookId){
		this.bookId = bookId;
	}

	public Book(Category category,String title,String author,Integer price){
		this.category = category;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(Category category,String title,Integer price,String author,String description,FileType fileType,String payment){
		super();
		this.category = category;
		this.title = title;
		this.price = price;
		this.author = author;
		this.description = description;
		this.fileType = fileType;
		this.payment = payment;
	}

	public Book(Integer bookId,String title,String author,Integer price){
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Book(Integer bookId,String title,String author,Integer price,FileType fileType){
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.author = author;
		this.fileType = fileType;
	}

	public Book(Integer bookId,String title,String author,String bookFile,Integer price){
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.bookFile = bookFile;
		this.price = price;
	}

	//############# OTHER-METHODS ########################
	public boolean saveBook(){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "insert into books (category_id,title,price,author,description,file_type_id,payment) value (?,?,?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1,category.getCategoryId());
			pst.setString(2,title);
			pst.setInt(3,price);
			pst.setString(4,author);
			pst.setString(5,description);
			pst.setInt(6,fileType.getFileTypeId());
			pst.setString(7,payment);

			int res = pst.executeUpdate();
			if(res == 1){
				flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
					bookId = rs.getInt(1);
				}
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return flag;
	}

	
	public static boolean saveBookFile(Integer pId,String file){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "update books set bookfile=? where book_id=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,file);
			pst.setInt(2,pId);

			int res = pst.executeUpdate();
			if(res == 1){
				flag = true;
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return flag;
	}
	

	
	public static ArrayList<Book> categoryBooks(int cater){
		Connection con = null;
		ArrayList<Book> arbk = null;
		try{
			arbk = new ArrayList<Book>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,price from books where category_id = ?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,cater);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				arbk.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}			

		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return arbk;
	}



	public static ArrayList<Book> allBooks(){
		Connection con = null;
		ArrayList<Book> arbk = null;
		try{
			arbk = new ArrayList<Book>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,price from books";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				arbk.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}			

		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return arbk;
	}

	public static ArrayList<Book> searchBooks(String searchedBook){
		Connection con = null;
		ArrayList<Book> searchBks = new ArrayList<Book>(); 

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,price from books where title like '"+searchedBook+"%'";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				searchBks.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return searchBks;
	}


	public static boolean deleteBook(int bookiD){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "delete from book_points where book_id="+bookiD;
			PreparedStatement pst = con.prepareStatement(query);
			int res = pst.executeUpdate();
			
			query = " delete from purchase where book_id="+bookiD;
			pst = con.prepareStatement(query);
			res = pst.executeUpdate();
			
			query = " delete from ratings where book_id="+bookiD;
			pst = con.prepareStatement(query);
			res = pst.executeUpdate();
			
			query = "delete from book_pics where book_id="+bookiD;
			pst = con.prepareStatement(query);
			res = pst.executeUpdate();
			
			query = "delete from books where book_id="+bookiD;
			pst = con.prepareStatement(query);
			res = pst.executeUpdate();
			if(res == 1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	public void getBookdetails(Integer bookid){
		User user = null;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,description,price,bookfile,payment,file_type_id,category_id from books where book_id="+bookid;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
					bookId = rs.getInt(1);
					title = rs.getString(2);
					author = rs.getString(3);
					description = rs.getString(4);
					price = rs.getInt(5);
					bookFile = rs.getString(6);
					payment = rs.getString(7);
					fileType = new FileType(rs.getInt(8));
					category = new Category(rs.getInt(9));
					category.setCategory(category.returnCategory());
				}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{ con.close();  }catch(SQLException e){e.printStackTrace();}
		}
	}

	public static String collectBookFile(int bkId){
		String picPath = null;

		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select bookfile from books where book_id="+bkId;

			PreparedStatement ps = con.prepareStatement(query);
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

	public boolean updateBook(int bookid){
	Connection con = null;
	boolean flag = false;

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
		bookId = bookid;
		String query = "update books set category_id = ?,title=?,price=?,author=? where book_id = "+bookId;
		PreparedStatement ps = con.prepareStatement(query);
		
			ps.setInt(1,category.getCategoryId());
			ps.setString(2,title);
			ps.setInt(3,price);
			ps.setString(4,author);

			int res = ps.executeUpdate();
			if(res==1){
				flag = true;
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



	public void updateBookFile(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "update books set bookfile=? where book_id=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,bookFile);
			pst.setInt(2,bookId);
			
			pst.executeUpdate();
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	}

	public static ArrayList<Book> getEBooks(){
		Connection con = null;
		ArrayList<Book> audiobk = null;
		try{
			audiobk = new ArrayList<Book>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,bookfile,price from books where file_type_id=1";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				audiobk.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}			

		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return audiobk;
	}

	public static ArrayList<Book> getAudioBooks(){
		Connection con = null;
		ArrayList<Book> audiobk = null;
		try{
			audiobk = new ArrayList<Book>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select book_id,title,author,bookfile,price from books where file_type_id=2";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				audiobk.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}			

		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){
				e.printStackTrace();}
		}
		return audiobk;
	}

	//###################BookDescription#######################
     public void getBookDescription(){
		Connection con = null;		

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "select title,author,description,price from books where book_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,bookId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				title = rs.getString(1);
				author= rs.getString(2);
			    description = rs.getString(3);
				price = rs.getInt(4);
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

	public boolean updateDescription(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "update books set description=? where book_id=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,description);
			pst.setInt(2,bookId);
			
			int res = pst.executeUpdate();

			if(res==1){
				flag = true;
			}			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	
		return flag;
	}

	public boolean updatePayment(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "update books set payment=?,file_type_id=? where book_id=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,payment);
			pst.setInt(2,fileType.getFileTypeId());
			pst.setInt(3,bookId);
			
			int res = pst.executeUpdate();

			if(res==1){
				flag = true;
			}			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	
		return flag;
	}

	//################### GETTER-SETTER ########################
	public Integer getBookId(){
		return bookId;
	}

	public void setBookId(Integer bookId){
		this.bookId = bookId;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle(){
		return title; 
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getAuthor(){
		return author; 
	}

	public void setAuthor(String author){
		this.author = author;
	}	

	/*public String getPublication(){
		return publication; 
	}

	public void setPublication(String publication){
		this.publication = publication;
	}	*/

	public String getDescription(){
		return description; 
	}

	public void setDescription(String description){
		this.description = description;
	}	

	public Integer getPrice(){
		return price; 
	}

	public void setPrice(Integer price){
		this.price = price;
	}	

	/*public String getDiscount(){
		return discount; 
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}*/
	
	public String getPayment(){
		return payment; 
	}

	public void setPayment(String payment){
		this.payment = payment;
	}

	public String getBookFile(){
		return bookFile; 
	}

	public void setBookFile(String bookFile){
		this.bookFile = bookFile;
	}

	public FileType getFileType(){
		return fileType; 
	}

	public void setFileType(FileType fileType){
		this.fileType = fileType;
	}
}