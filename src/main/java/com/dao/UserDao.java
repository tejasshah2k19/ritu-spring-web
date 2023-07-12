package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (firstName,email,password,role) values (?,?,?,?)", user.getFirstName(),
				user.getEmail(), user.getPassword(), user.getRole());
	}

	public UserBean getUserByEmail(String email) {
		// to read single user data we have queryForObject
		try {
		return stmt.queryForObject("select * from users where email = ? ", new BeanPropertyRowMapper<UserBean>(),
				new Object[] { email });
		}catch(Exception e) {
			
		}
		return null;
	}
}
