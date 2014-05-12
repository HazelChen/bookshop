package edu.nju.bookHouse.action;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.nju.bookHouse.model.Customer;

public class CustomerBarAction extends BaseAction{
	private static final long serialVersionUID = 5144563963912658234L;
	
	private int id;
	private Customer customer;
	

	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 判断用户是否登录，如果登录，就给界面用户的信息
	 */
	@Override
	public String execute () throws ServletException, IOException {
		Customer sessionCustomer = (Customer)session.get("customer");
		if (sessionCustomer == null) {
			return "notLogon";
		} else {
			this.customer = sessionCustomer;
			return "logon";
		}
	}
}
