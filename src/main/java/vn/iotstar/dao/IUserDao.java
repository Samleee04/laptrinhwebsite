package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findByid(int id);
	void insert(UserModel user);
	UserModel findByUsername(String username);
}
