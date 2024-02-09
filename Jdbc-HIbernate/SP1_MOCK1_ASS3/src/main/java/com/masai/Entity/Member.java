package com.masai.Entity;

public class Member {
	private int memberId;
	private String memberName;
	private int age;
	private String membershipType;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(int memberId, String memberName, int age, String membershipType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.age = age;
		this.membershipType = membershipType;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", age=" + age + ", membershipType="
				+ membershipType + "]";
	}
	
	
}
