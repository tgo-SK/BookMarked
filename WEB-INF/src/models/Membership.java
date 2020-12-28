package models;

public class Membership{
	private Integer membershipId;
	private String membershipName;
	private Integer price;

	public Membership(Integer membershipId){
		this.membershipId = membershipId;
		if(membershipId == 0){
			price = 0;
			membershipName = "Normal User";
		}else if(membershipId == 1){
			price = 199;
			membershipName = "Lecturer";
		}else if(membershipId == 2){
			price = 399;
			membershipName = "Reader";
		}else if(membershipId == 3){
			price = 799;
			membershipName = "Professor";
		}
	}

	public void setMembershipName(String membershipName){
		this.membershipName = membershipName;
	}

	public String getMembershipName(){
		return membershipName;
	}

	public void setMembershipId(Integer membershipId){
		this.membershipId = membershipId;
	}

	public Integer getMembershipId(){
		return membershipId;
	}

	public void setPrice(Integer price){
		this.price = price;
	}

	public Integer getPrice(){
		return price;
	}
}