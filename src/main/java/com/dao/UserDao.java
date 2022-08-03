package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	// db query
	@Autowired
	JdbcTemplate stmt;

	public boolean addUser(UserBean user) {
		stmt.update("insert into users (firstName,lastName,email,password,gender,dob,contactnum) values (?,?,?,?,?,?,?)", 
	
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPassword(),
				user.getGender(),
				user.getDob(),
				user.getContactNum()
				);
		return false;
	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public boolean updateUser(UserBean user) {
		stmt.update("update users set  firstname =   ? where userid = ? ", user.getFirstName(),user.getUserId());

		return false;
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);
	
	}

}
