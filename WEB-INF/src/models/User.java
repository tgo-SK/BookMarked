package models;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{
	//############# FIELDS ########################
	private Integer userId;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private String activationCode;
	private Status status;
	private UserType userType;
	private String mobile;
	private String profPic;
	private Membership membership;

	//############# CONSTRUCTORS ########################
	public User(){
		
	}

	public User(Integer userId){
		this.userId = userId;
	}

	public User(String userName, String email, String password, String activationCode) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.activationCode = activationCode;
	}

	//############# OTHER METHODS ########################
	public boolean saveUser(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "insert into users (username,email,password,activation_code) value (?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,userName);
			pst.setString(2,email);
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			pst.setString(3,spe.encryptPassword(password));
			pst.setString(4,activationCode);

			pst.executeUpdate();

			flag = true;
			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{ con.close(); }catch(SQLException e){ e.printStackTrace(); }
		}

		return flag;
	}

	
	public static boolean activationAccount(String userName, String activationCode){
		boolean flag = false;
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
		String query = "Update users Set activation_code = '',status_id=1 Where username = ? And activation_code = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1,userName);
		pst.setString(2,activationCode);
		int res = pst.executeUpdate();
		if(res == 1)
			flag = true;
		}catch(SQLException | ClassNotFoundException e){
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
	

	public static boolean CheckUniqueKey(String key){
		Connection con = null;
		boolean flag = true;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
		String query = "Select * From users Where username = ? OR email = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,key);
		pst.setString(2,key);

		ResultSet rst = pst.executeQuery();
		if(rst.next())
			flag = false;

		}catch(SQLException | ClassNotFoundException e){
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
	

	public static User loginUser(String ukey,String password){
		User user = null;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			String query = "select password,user_id,username,email,first_name,middle_name,last_name,dob,user_type_id,status_id,mobile,profpic,membership_id from users where (username=? or email=?) and status_id=1";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,ukey);
			pst.setString(2,ukey);
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				String enPass = rs.getString(1);
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				if(spe.checkPassword(password,enPass)){
					user = new User();
					user.setUserId(rs.getInt(2));
					user.setUserName(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setFirstName(rs.getString(5));
					user.setMiddleName(rs.getString(6));
					user.setLastName(rs.getString(7));
					user.setDob(rs.getDate(8));
					user.setUserType(new UserType(rs.getInt(9)));
					user.setStatus(new Status(rs.getInt(10)));
					user.setMobile(rs.getString(11));
					user.setProfPic(rs.getString(12));
					user.setMembership(new Membership(rs.getInt(13)));
				}
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{ con.close();  }catch(SQLException e){e.printStackTrace();}
		}
		return user;
	}


	public void saveProfPic(){
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "update users set profpic=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
		
			pst.setString(1,profPic);
			pst.setInt(2,userId);
			
			pst.executeUpdate();			

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


	public boolean saveProfile(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");

			String query = "update users set first_name=?,middle_name=?,last_name=?,dob=?,mobile=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,firstName);
			pst.setString(2,middleName);
			pst.setString(3,lastName);
			pst.setDate(4,dob);
			pst.setString(5,mobile);

			pst.setInt(6,userId);
			
			int res = pst.executeUpdate();
			if(res==1){
				flag = true;
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{try{con.close();}catch(SQLException e){e.printStackTrace();}
		}	
		return flag;
	}

	//############# GETTER-SETTERS ########################
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setUserType(UserType userType){
		this.userType = userType; 
	}
	public UserType getUserType(){
		return userType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setProfPic(String profPic){
		this.profPic = profPic;
	}

	public String getProfPic(){
		return profPic;
	}
}