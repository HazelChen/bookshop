package edu.nju.bookHouse.action;

import edu.nju.bookHouse.service.CustomerService;

public class CustomerRegisterAction extends BaseAction{
	private static final long serialVersionUID = 5184604638086022635L;
	
	private CustomerService customerService;
	
	@Override
	public String execute() {
		session.remove("registerError");
		String username = request.getParameter("username");
		
		if (customerService.exists(username)) {
			session.put("registerError", "用户名已存在");
			return INPUT;
			
		} else {
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String birthdayString = request.getParameter("birthday");
			String bankId = request.getParameter("bankId");
			customerService.addCustomer(username, password, sex, address, birthdayString, bankId);
		}
		
		session.put("userId", username);
		return SUCCESS;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
