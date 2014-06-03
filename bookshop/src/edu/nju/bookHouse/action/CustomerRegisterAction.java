package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.UserService;

public class CustomerRegisterAction extends BaseAction{
	private static final long serialVersionUID = 5184604638086022635L;
	
	private UserService userService;
	
	@Override
	public String execute() {
		session.remove("registerError");
		String username = request.getParameter("username");
		
		if (userService.exists(username)) {
			session.put("registerError", "用户名已存在");
			return INPUT;
			
		} else {
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String birthdayString = request.getParameter("birthday");
			String bankId = request.getParameter("bankId"); 
			User user = userService.addCustomer(username, password, sex, address, birthdayString, bankId);
			session.put("customer", user);
			return SUCCESS;
		}
	}

	public void setUserService(UserService customerService) {
		this.userService = customerService;
	}
	
	
}
