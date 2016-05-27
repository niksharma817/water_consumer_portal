package com.polimi.user.dao;

import com.polimi.user.model.User;

public interface UserDAO 
{
	public void insert(User user);
	public User findByUserId(int userId);
}