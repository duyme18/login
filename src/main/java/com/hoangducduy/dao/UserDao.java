package com.hoangducduy.dao;

import java.util.ArrayList;
import java.util.List;

import com.hoangducduy.model.Login;
import com.hoangducduy.model.User;

public class UserDao {
	private static List<User> users;
	static {
		users = new ArrayList<User>();
		User user1 = new User();
		user1.setAccount("duy");
		user1.setName("Duy");
		user1.setAge(23);
		user1.setEmail("duyme18@gmail.com");
		user1.setPassword("123456");
		users.add(user1);

		User user2 = new User();
		user2.setAccount("cong");
		user2.setName("Công");
		user2.setAge(24);
		user2.setEmail("minhcongvghy@gmail.com");
		user2.setPassword("123456");
		users.add(user2);

		User user3 = new User();
		user3.setAccount("trang");
		user3.setName("Trang");
		user3.setAge(23);
		user3.setEmail("trang.nguyen@codegym.vn");
		user3.setPassword("123456");
		users.add(user3);
	}

	public static User CheckLogin(Login login) {
		for(User user:users) {
			if(user.getAccount().equals(login.getAccount())&&user.getPassword().equals(login.getPassword())) {
				return user;
			}
		}
		return null;
	}
}
