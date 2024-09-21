package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserName(String username);
	void update(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUserName(String username);
	boolean register(String email,String password, String username, String fullname);
	boolean checkExistUserNameAndEmail(String username, String email);
	boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword);
}
 