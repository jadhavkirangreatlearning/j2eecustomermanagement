package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.csi.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOW_PAGE = "/show.jsp";
	String EDIT_PAGE = "/edit.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	/**
	 * Default constructor.
	 */
	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String redirect = "";

		String custId = request.getParameter("custid");

		String action = request.getParameter("action");

		if (custId != null && action.equals("signup")) {

			int customerId = Integer.parseInt(custId);

			String custName = request.getParameter("custname");

			String custAddress = request.getParameter("custaddress");

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			int custAge = Integer.parseInt(request.getParameter("custage"));

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			String custGender = request.getParameter("custgender");

			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(customerId, custName, custAddress, custContactNumber, custAge,
					custAccountBalance, custGender, custDOB, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("custList", customerServiceImpl.getAllData());
				redirect = SHOW_PAGE;
			} else {
				request.setAttribute("message", "Oops Please try again!!!!!");

				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {

			redirect = EDIT_PAGE;

		} else if (action.equals("edit")) {

			int customerId = Integer.parseInt(request.getParameter("custid"));

			String custName = request.getParameter("custname");

			String custAddress = request.getParameter("custaddress");

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			int custAge = Integer.parseInt(request.getParameter("custage"));

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			String custGender = request.getParameter("custgender");

			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(customerId, custName, custAddress, custContactNumber, custAge,
					custAccountBalance, custGender, custDOB, custEmailId, custPassword);

			customerServiceImpl.updateData(customerId, customer);

			request.setAttribute("custList", customerServiceImpl.getAllData());
			redirect = SHOW_PAGE;

		} else if (action.equals("deletebyid")) {

			int customerId = Integer.parseInt(request.getParameter("custid"));

			customerServiceImpl.deleteDataById(customerId);

			request.setAttribute("custList", customerServiceImpl.getAllData());
			redirect = SHOW_PAGE;

		} else if (action.equals("deletealldata")) {

			customerServiceImpl.deleteAllData();

			request.setAttribute("custList", customerServiceImpl.getAllData());
			redirect = SHOW_PAGE;

		} else if (action.equals("getdatabyid")) {

			int customerId = Integer.parseInt(request.getParameter("custid"));

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.filter(cust -> cust.getCustId() == customerId).collect(Collectors.toList()));

			redirect = SHOW_PAGE;

		} else if (action.equals("getdatabyname")) {

			String custName = request.getParameter("custname");

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.filter(cust -> cust.getCustName().equals(custName)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;

		} else if (action.equals("getdatabycontactnumber")) {

			Long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.filter(cust -> cust.getCustContactNumber() == custContactNumber).collect(Collectors.toList()));

			redirect = SHOW_PAGE;
		} else if (action.equals("getdatabyemailid")) {

			String custEmailId = request.getParameter("custemailid");

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.filter(cust -> cust.getCustEmailId().equals(custEmailId)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;
		} else if (action.equals("sortbyid")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingInt(Customer::getCustId)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Customer::getCustName)).collect(Collectors.toList()));
			redirect = SHOW_PAGE;
		} else if (action.equals("sortbyage")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingInt(Customer::getCustAge)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;

		} else if (action.equals("sortbydob")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Customer::getCustDOB)).collect(Collectors.toList()));
			redirect = SHOW_PAGE;
		} else if (action.equals("sortbyaccountbalance")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingDouble(Customer::getCustAccountBalance)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;
		} else if (action.equals("sortbyemailid")) {

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Customer::getCustEmailId)).collect(Collectors.toList()));

			redirect = SHOW_PAGE;
		} else if (action.equals("filterdatabyaccountbalance")) {

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			request.setAttribute("custList", customerServiceImpl.getAllData().stream()
					.filter(cust -> cust.getCustAccountBalance() >= custAccountBalance).collect(Collectors.toList()));
			redirect = SHOW_PAGE;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
