package com.csi.model;

import java.util.Date;

public class Customer {

	private int custId;

	private String custName;

	private String custAddress;

	private long custContactNumber;

	private int custAge;

	private double custAccountBalance;

	private String custGender;

	private Date custDOB;

	private String custEmailId;

	private String custPassword;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId, String custName, String custAddress, long custContactNumber, int custAge,
			double custAccountBalance, String custGender, Date custDOB, String custEmailId, String custPassword) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContactNumber = custContactNumber;
		this.custAge = custAge;
		this.custAccountBalance = custAccountBalance;
		this.custGender = custGender;
		this.custDOB = custDOB;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public double getCustAccountBalance() {
		return custAccountBalance;
	}

	public void setCustAccountBalance(double custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custContactNumber=" + custContactNumber + ", custAge=" + custAge + ", custAccountBalance="
				+ custAccountBalance + ", custGender=" + custGender + ", custDOB=" + custDOB + ", custEmailId="
				+ custEmailId + ", custPassword=" + custPassword + "]";
	}

}
