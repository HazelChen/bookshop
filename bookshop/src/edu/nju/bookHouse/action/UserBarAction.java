package edu.nju.bookHouse.action;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.nju.bookHouse.model.User;

public class UserBarAction extends BaseAction{
	private static final long serialVersionUID = 5144563963912658234L;
	
	private User user;
	
	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 判断用户是否登录，如果登录，就给界面用户的信息
	 */
	@Override
	public String execute () throws ServletException, IOException {
		User sessionCustomer = (User)session.get("customer");
		if (sessionCustomer == null) {
			return "notLogon";
		} else {
			this.user = sessionCustomer;
			return "logon";
		}
	}
	
	public String adminBar() throws ServletException, IOException {
		User sessionAdmin = (User)session.get("admin");
		if (sessionAdmin == null) {
			return "notLogon";
		} else {
			this.user = sessionAdmin;
			return "logon";
		}
	}
	
	public String managerBar() throws ServletException, IOException {
		User sessionManager = (User)session.get("manager");
		if (sessionManager == null) {
			return "notLogon";
		} else {
			this.user = sessionManager;
			return "logon";
		}
	}

	public User getUser() {
		return user;
	}
}
