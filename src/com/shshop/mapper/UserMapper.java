package com.shshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shshop.domain.Product;
import com.shshop.domain.User;

public interface UserMapper {
	public int getUserCount();

	public User getUserById(@Param("userId") int userId);
	
	public User getUserByEmail(@Param("email") String email, @Param("password") String password);
	
	public List<User> getAllUsers();
	
	public User getSingleUser(@Param("userId") int userId);

	public void insertUser(User user);

	public List<Product> getAllProducts(@Param("userId") int userId);

	public void updateUser(User user);
}



