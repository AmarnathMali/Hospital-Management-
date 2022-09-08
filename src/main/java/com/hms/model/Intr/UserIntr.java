package com.hms.model.Intr;

import java.util.List;
import java.util.Map;

import com.hms.model.User;

public interface UserIntr {

	public void insertUser(User user);
	public Map selectUser(int id);
	public List getAllUser();
	public void updateUser(User user);
	public void deleteUser(int id);
}
