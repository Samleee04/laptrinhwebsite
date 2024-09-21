package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService{
 // lấy toàn bộ hàm trong tầng Dao của user
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void update(UserModel user) {
		userDao.update(user); //xem lai
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUserName(String username) {
		return userDao.checkExistUserName(username);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname) {
		if(userDao.checkExistEmail(email))
		{
			return false;
		}
		if(userDao.checkExistUserName(username))
		{
			return false;
		}
		userDao.insertregister(new UserModel(username, email, fullname, password,1,"chua co codea"));
		return true;
	}

	@Override
	public boolean checkExistUserNameAndEmail(String username, String email) {
		return userDao.checkExistUserNameAndEmail(username, email);
	}

	@Override
	public boolean updatePasswordByUsernameAndEmail(String username, String email, String newPassword) {
		return userDao.updatePasswordByUsernameAndEmail(username, email, newPassword);
	
	}

}
