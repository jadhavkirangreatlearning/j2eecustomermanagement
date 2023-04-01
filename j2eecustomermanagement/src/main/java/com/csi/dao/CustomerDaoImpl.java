package com.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csi.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = null;

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eecustomermanagement", "root",
						"root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into customer(custid, custname, custaddress, custcontactnumber, custage, custaccountbalance, custgender, custdob, custemailid, custpassword)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, customer.getCustId());
			preparedStatement.setString(2, customer.getCustName());
			preparedStatement.setString(3, customer.getCustAddress());
			preparedStatement.setLong(4, customer.getCustContactNumber());
			preparedStatement.setInt(5, customer.getCustAge());
			preparedStatement.setDouble(6, customer.getCustAccountBalance());
			preparedStatement.setString(7, customer.getCustGender());
			preparedStatement.setDate(8, new java.sql.Date(customer.getCustDOB().getTime()));
			preparedStatement.setString(9, customer.getCustEmailId());
			preparedStatement.setString(10, customer.getCustPassword());

			preparedStatement.executeUpdate();

			System.out.println("Signup Done Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;
		for (Customer customer : getAllData()) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub

		Customer customer = new Customer();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where custid=?");

			preparedStatement.setInt(1, custId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customer.setCustId(resultSet.getInt(1));
				customer.setCustName(resultSet.getString(2));
				customer.setCustAddress(resultSet.getString(3));
				customer.setCustContactNumber(resultSet.getLong(4));
				customer.setCustAge(resultSet.getInt(5));
				customer.setCustAccountBalance(resultSet.getDouble(6));
				customer.setCustGender(resultSet.getString(7));
				customer.setCustDOB(resultSet.getDate(8));
				customer.setCustEmailId(resultSet.getString(9));
				customer.setCustPassword(resultSet.getString(10));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub

		List<Customer> customers = new ArrayList<Customer>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Customer customer = new Customer();
				customer.setCustId(resultSet.getInt(1));
				customer.setCustName(resultSet.getString(2));
				customer.setCustAddress(resultSet.getString(3));
				customer.setCustContactNumber(resultSet.getLong(4));
				customer.setCustAge(resultSet.getInt(5));
				customer.setCustAccountBalance(resultSet.getDouble(6));
				customer.setCustGender(resultSet.getString(7));
				customer.setCustDOB(resultSet.getDate(8));
				customer.setCustEmailId(resultSet.getString(9));
				customer.setCustPassword(resultSet.getString(10));

				customers.add(customer);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update customer set custname=?, custaddress=?, custcontactnumber=?, custage=?, custaccountbalance=?, custgender=?, custdob=?, custemailid=?, custpassword=? where custid=?");

			preparedStatement.setString(1, customer.getCustName());
			preparedStatement.setString(2, customer.getCustAddress());
			preparedStatement.setLong(3, customer.getCustContactNumber());
			preparedStatement.setInt(4, customer.getCustAge());
			preparedStatement.setDouble(5, customer.getCustAccountBalance());
			preparedStatement.setString(6, customer.getCustGender());
			preparedStatement.setDate(7, new java.sql.Date(customer.getCustDOB().getTime()));
			preparedStatement.setString(8, customer.getCustEmailId());
			preparedStatement.setString(9, customer.getCustPassword());

			preparedStatement.setInt(10, custId);

			preparedStatement.executeUpdate();

			System.out.println("Data Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where custid=?");

			preparedStatement.setInt(1, custId);

			preparedStatement.executeUpdate();

			System.out.println("Data Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("truncate table customer");

			preparedStatement.executeUpdate();

			System.out.println("All Data Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
