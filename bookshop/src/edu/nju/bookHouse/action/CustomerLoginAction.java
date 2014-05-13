package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.Customer;
import edu.nju.bookHouse.service.CustomerService;

public class CustomerLoginAction extends BaseAction{
	private static final long serialVersionUID = 8124963048067029840L;
	
	private CustomerService customerService;
	
	@Override
	public String execute() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = customerService.loginVerify(username, password);
		
		if (customer != null) {
			session.put("customer", customer);
			return SUCCESS;
		} else {
			session.put("loginError", "用户名或密码错误。");
			return INPUT;
		}
	}
	
	public String logout() {
		session.remove("customer");
		return SUCCESS;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
