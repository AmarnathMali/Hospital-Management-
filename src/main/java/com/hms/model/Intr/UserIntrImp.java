package com.hms.model.Intr;

import java.util.List;
import java.util.Map;

import com.hms.dao.UserDao;
import com.hms.model.User;

public class UserIntrImp implements UserIntr{

	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public UserDao getUserDao() {
		return userDao;
	}


	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
		
	}

	@Override
	public Map selectUser(int id) {
		// TODO Auto-generated method stub
		return userDao.selectUser(id);
	}

	@Override
	public List getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}
	
	
}
