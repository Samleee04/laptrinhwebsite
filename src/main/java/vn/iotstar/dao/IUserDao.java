package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findByid(int id);
	void insert(UserModel user);
	UserModel findByUsername(String username);
	void insertregister(UserModel user);
	void update(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUserName(String username);
	boolean checkExistUserNameAndEmail(String username, String email);
	boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword);
}
