package com.hms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hms.model.User;
import com.hms.model.Intr.UserIntr;

public class UserDao implements UserIntr{

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void insertUser(User user) {
		
		//jt.update("insert into new_table(name,bloodgroup,disease) values ('"+user.getName()+"'+'"+user.getBgroup()+"'+'"+user.getDisease()+"'"+")");
		jt.update(
			    "INSERT INTO new_table (name,bgroup,disease) VALUES (?, ?, ?)",
			    user.getName(),user.getBgroup(),user.getDisease()
			);
		
	}

	public Map selectUser(int id) {
		Map m = jt.queryForMap("select * from new_table where id='"+id+"'");
		return m;
	}

	public List getAllUser() {
		List l = jt.queryForList("select * from new_table");
		return l;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		jt.update("update new_table set name='"+user.getName()+"',bgroup='"+user.getBgroup()+"',disease='"+user.getDisease()+"'where id='"+user.getId()+"'");
		
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		jt.update("delete from new_table where id='"+id+"'");
		
	}
	
	
}
