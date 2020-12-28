package models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemPurchase{
	private User user;
	private Integer memPurchaseId;
	private Membership membership = new Membership(0);
	private Integer credits=0;
	private Date purchaseDate;
	private Date expireDate;

	public MemPurchase(){}

	public MemPurchase(Membership membership){
	this.membership = membership;
	}
//########################OtherMethods###################################
	public boolean purchaseMembership(int userId){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			
			String query = "update users set membership_id = "+membership.getMembershipId()+" where user_id = "+userId;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();

			query = "insert into mem_purchases (membership_id,credits,purchase_date,expire_date,user_id) value (?,?,CURRENT_DATE,ADDDATE(CURRENT_DATE, INTERVAL 30 DAY),"+userId+")";
			pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1,membership.getMembershipId());
			if(membership.getMembershipId() == 1){
				pst.setInt(2,3);
				credits = 3;
			}
			else if(membership.getMembershipId() == 2){
				pst.setInt(2,7);
				credits = 7;
			}
			else if(membership.getMembershipId() == 3){
				pst.setInt(2,16);
				credits = 16;
			}
			int res = pst.executeUpdate();
			if(res == 1){
				flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
					memPurchaseId = rs.getInt(1);
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

	
	public void collectMemPurchase(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			Boolean flag = false;
			String query = "update users inner join mem_purchases set users.membership_id = 0 where (users.user_id = mem_purchases.user_id) AND CURRENT_DATE >= mem_purchases.expire_date";
			PreparedStatement pst = con.prepareStatement(query);
			int res = pst.executeUpdate();
			if(res == 1)
				user.setMembership(new Membership(0));

			query = "delete from mem_purchases where CURRENT_DATE >= expire_date";
			pst = con.prepareStatement(query);
			res = pst.executeUpdate();
			if(res == 1){
				query = "delete from purchase where (purchase_type = 1) AND user_id = "+user.getUserId();
				pst = con.prepareStatement(query);
				pst.executeUpdate();
			}
			query = "select mem_purchase_id,membership_id,credits,purchase_date,expire_date from mem_purchases where user_id = "+user.getUserId();
			pst = con.prepareStatement(query);
		
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				memPurchaseId = rs.getInt(1);
				membership = new Membership(rs.getInt(2));
				credits = rs.getInt(3);
				purchaseDate = rs.getDate(4);
				expireDate = rs.getDate(5);
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{ con.close();  }catch(SQLException e){e.printStackTrace();}
		}
	}

	
	public void decCredits(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarked?user=root&password=1234");
			--credits;
			String query = "update mem_purchases set credits = credits - 1 where user_id ="+user.getUserId();
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{ con.close(); }catch(SQLException e){e.printStackTrace();}
		}
	}
//#####################################################################
	public void setMemPurchaseId(Integer memPurchaseId){
		this.memPurchaseId = memPurchaseId;
	}

	public Integer getMemPurchaseId(){
		return memPurchaseId;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}


	public void setMembership(Membership membership){
		this.membership = membership;
	}

	public Membership getMembership(){
		return membership;
	}

	public void setCredits(Integer credits){
		this.credits = credits;
	}

	public Integer getCredits(){
		return credits;
	}

	public void setPurchaseDate(Date purchaseDate){
		this.purchaseDate = purchaseDate;
	}

	public Date getPurchaseDate(){
		return purchaseDate;
	}

	public void setExpireDate(Date purchaseDate){
		this.expireDate = expireDate;
	}

	public Date getExpireDate(){
		return expireDate;
	}
}