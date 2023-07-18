package com.dao;

import java.util.List;

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
		stmt.update("insert into users (firstName,email,password,role,profilePath) values (?,?,?,?,?)", user.getFirstName(),
				user.getEmail(), user.getPassword(), user.getRole(),user.getProfilePath());
	}

	public UserBean getUserByEmail(String email) {
		// to read single user data we have queryForObject
		try {
			return stmt.queryForObject("select * from users where email = ? ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

}
