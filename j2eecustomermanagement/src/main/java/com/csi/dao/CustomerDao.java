package com.csi.dao;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerDao {

	public void signUp(Customer customer);

	public boolean signIn(String custEmailId, String custPassword);

	public Customer getDataById(int custId);

	public List<Customer> getAllData();

	public void updateData(int custId, Customer customer);

	public void deleteDataById(int custId);

	public void deleteAllData();

}
