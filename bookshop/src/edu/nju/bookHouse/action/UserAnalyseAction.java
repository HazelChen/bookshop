package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.UserAddress;
import edu.nju.bookHouse.model.UserAge;
import edu.nju.bookHouse.model.UserGender;
import edu.nju.bookHouse.model.UserMonthAdd;
import edu.nju.bookHouse.service.UserService;

public class UserAnalyseAction extends BaseAction{
	private static final long serialVersionUID = 5567292210796686339L;
	
	private List<UserMonthAdd> userMonthAdds;
	private List<UserAddress> userAddresses;
	private List<UserGender> userGenders;
	private List<UserAge> userAges;
	private int newUserAddCount;
	
	private UserService userService;
	
	@Override
	public String execute() {
		userMonthAdds = userService.getAllUserMonthAdds();
		userAddresses = userService.getAllUserAddresses();
		userGenders = userService.getAllUserGenders();
		userAges = userService.getAllUserAges();
		newUserAddCount = userService.getForecastUserAdd(userMonthAdds);
		return SUCCESS;
	}

	public List<UserMonthAdd> getUserMonthAdds() {
		return userMonthAdds;
	}

	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public List<UserGender> getUserGenders() {
		return userGenders;
	}

	public List<UserAge> getUserAges() {
		return userAges;
	}
	
	public int getNewUserAddCount() {
		return newUserAddCount;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
