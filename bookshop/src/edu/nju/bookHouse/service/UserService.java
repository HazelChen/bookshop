package edu.nju.bookHouse.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import edu.nju.bookHouse.dao.UserDao;
import edu.nju.bookHouse.model.Bank;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.Role;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.model.analyse.UserAddress;
import edu.nju.bookHouse.model.analyse.UserAge;
import edu.nju.bookHouse.model.analyse.UserGender;
import edu.nju.bookHouse.model.analyse.UserMonthAdd;
import edu.nju.bookHouse.service.linearRegression.DataPoint;
import edu.nju.bookHouse.service.linearRegression.LinearRegression;

public class UserService {
	private BankService bankService;
	private UserDao userDao;
	
	private DateChanger dateChanger;
	
	public User find(String username) {
		User user = userDao.find(username);
		return user;
	}
	
	public boolean exists(String username) {
		User user = find(username);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public List<User> getAllCustomers() {
		return userDao.getAllCustomers();
	}
	
	public User addCustomer(String username, String password, String sex, String address, String birthdayString, String bankId) {
		Calendar calendar = Calendar.getInstance();
		Date registerDay = calendar.getTime();
		
		Date birthDay = dateChanger.StringToDate(birthdayString);
		
		Bank bank = bankService.find(bankId); 
		
		CustomerInfo info = new CustomerInfo(sex, address, birthDay, registerDay, bank);
		User user = new User(username, password, new Role(1, "customer"), info);
		userDao.add(user);
		return user;
	}
	
	public User adminLoginVerify(String username, String password) {
		User user = loginVerify(username, password);
		if (user != null && user.admin()) {
			return user;
		} else {
			return null;
		}
	}
	
	public User customerLoginVerify(String username, String password) {
		User user = loginVerify(username, password);
		if (user != null && user.customer()) {
			return user;
		} else {
			return null;
		}
	}
	
	public User managerLoginVerify(String username, String password) {
		User user = loginVerify(username, password);
		if (user != null && user.manager()) {
			return user;
		} else {
			return null;
		}
	}
	
	private User loginVerify(String username, String password) {
		User user = userDao.find(username);
		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDateChanger(DateChanger dateChanger) {
		this.dateChanger = dateChanger;
	}

	public CustomerInfo getCustomerInfo(String customerId) {
		int id = Integer.parseInt(customerId);
		return userDao.findCustomerInfo(id);
	}
	
	public void analyse() {
		userDao.removeAllStatics();
		analyseAddress();
		analyseAge();
		analyseGender();
		analyseMonthAdd();
	}

	private void analyseMonthAdd() {
		Calendar nowCalendar = Calendar.getInstance();
		for (int i = 0; i < 3; i++) {
			Date maxDate = nowCalendar.getTime();
			nowCalendar.add(Calendar.MONTH, -1);
			Date minDate = nowCalendar.getTime();
			String maxDateString = dateChanger.normalDateToString(maxDate);
			String minDateString = dateChanger.normalDateToString(minDate);
			int count = (int) userDao.getRegisterDateCount(minDateString, maxDateString);
			
			UserMonthAdd userMonthAdd = new UserMonthAdd("Past " + i + " Months", count);
			userDao.add(userMonthAdd);
		}
	} 

	private void analyseGender() {
		int maleCount = (int) userDao.getMaleCount();
		int femaleCount = (int) userDao.getFemaleCount();
		int total = maleCount + femaleCount;
		double malePercentage = ((int)((maleCount + 0.0) / total * 100)) / 100.0;
		double femalePercentage = ((int)((femaleCount + 0.0) / total * 100)) / 100.0;
		
		UserGender maleUserGender = new UserGender("Male", maleCount, malePercentage);
		UserGender femaleUserGender = new UserGender("Female", femaleCount, femalePercentage);
		
		userDao.add(maleUserGender);
		userDao.add(femaleUserGender);
	}

	private void analyseAge() {
		Calendar nowCalendar = Calendar.getInstance();
		List<UserAge> userAges = new ArrayList<UserAge>();
		double totalCount = 0;
		for (int i = 0; i < 5; i++) {
			Date maxYearDate = nowCalendar.getTime();
			nowCalendar.add(Calendar.YEAR, -20);
			Date minYearDate = nowCalendar.getTime();
			String maxYear = dateChanger.normalDateToString(maxYearDate);
			String minYear = dateChanger.normalDateToString(minYearDate);
			int count = (int) userDao.getAgeCount(minYear, maxYear);
			UserAge userAge = new UserAge(i * 20+ "-" + (i + 1) * 20, count);
			userAges.add(userAge);
			totalCount += count;
		}
		
		for (UserAge userAge : userAges) {
			double percentage = (userAge.getCount() + 0.0) / totalCount;
			double percentageTwoDemical = ((int)(percentage * 100)) / 100.0;
			userAge.setPercentage(percentageTwoDemical);
			userDao.add(userAge);
		}
	}

	private void analyseAddress() {
		List<Object[]> list = userDao.getUserAddressObject();
		
		int totalCount = 0;
		List<UserAddress> userAddresses = new ArrayList<UserAddress>();
		for (Iterator<Object[]> iterator = list.iterator();iterator.hasNext();) {
			Object[] object = (Object[])iterator.next();
			String place = (String)object[0];
			int provinceIndex = place.indexOf("省");
			String address = place.substring(0, provinceIndex);
			long count = (Long)object[1];
			totalCount += count;
			UserAddress userAddress = new UserAddress(address, (int)count);
			if (userAddresses.contains(userAddress)) {
				int containsIndex = userAddresses.indexOf(userAddress);
				UserAddress containsUserAddress = userAddresses.get(containsIndex);
				int newCount = (int) (containsUserAddress.getCount() + count);
				containsUserAddress.setCount(newCount);
			} else {
				userAddresses.add(userAddress);
			}
		}
		
		for (UserAddress userAddress : userAddresses) {
			double percentage = (userAddress.getCount() + 0.0) / totalCount;
			double percentageTwoDemical = ((int)(percentage * 100)) / 100.0;
			userAddress.setPercentage(percentageTwoDemical);
			userDao.add(userAddress);
		}
	}

	public List<UserMonthAdd> getAllUserMonthAdds() {
		return userDao.getAllUserMonthAdds();
	}

	public List<UserAddress> getAllUserAddresses() {
		return userDao.getAllUserAddresses();
	}

	public List<UserGender> getAllUserGenders() {
		return userDao.getAllUserGenders();
	}

	public List<UserAge> getAllUserAges() {
		return userDao.getAllUserAges();
	}
	
	public int getForecastUserAdd(List<UserMonthAdd> userMonthAdds) {
		int size = userMonthAdds.size();
		DataPoint[] dataPoints = new DataPoint[size];
		for (int i = 0; i < size;i++) {
			UserMonthAdd userMonthAdd = userMonthAdds.get(i);
			dataPoints[i] = new DataPoint(i, userMonthAdd.getCount());
		}
		LinearRegression linearRegression = new LinearRegression(dataPoints);
		double result = linearRegression.at(size);
		return (int)result;
	}
}
