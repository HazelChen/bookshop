package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.UserService;

public class ManagerLoginAction extends BaseAction{
	private UserService userService;
	
	@Override
	public String execute() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User manager = userService.managerLoginVerify(username, password);
		
		if (manager != null) {
			session.put("manager", manager);
			return SUCCESS;
		} else {
			session.put("loginError", "用户名或密码错误。");
			return INPUT;
		}
	}
	
	public String logout() {
		session.remove("manager");
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
