package com.csi.service;

import java.util.List;

import com.csi.dao.CustomerDao;
import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDaoImpl = new CustomerDaoImpl();
	
	
	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUp(customer);
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDaoImpl.signIn(custEmailId, custPassword);
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.getDataById(custId);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getAllData();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.updateData(custId, customer);
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteDataById(custId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAllData();
	}

}
