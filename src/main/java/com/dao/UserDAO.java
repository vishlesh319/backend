package com.dao;

import com.model.User;

public interface UserDAO
{

		public void insertUser(User user);
		public User getUserId(String email);



}

