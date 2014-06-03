package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.UserService;

public class AdminLoginAction extends BaseAction{
	private static final long serialVersionUID = -2093645795785499476L;
	
	private UserService userService;
	
	@Override
	public String execute() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User admin = userService.adminLoginVerify(username, password);
		
		if (admin != null) {
			session.put("admin", admin);
			return SUCCESS;
		} else {
			session.put("loginError", "用户名或密码错误。");
			return INPUT;
		}
	}
	
	public String logout() {
		session.remove("admin");
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
