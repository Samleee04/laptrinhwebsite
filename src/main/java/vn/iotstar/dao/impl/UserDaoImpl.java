package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;


public class UserDaoImpl extends DBConnectMySQL implements IUserDao{

	public Connection conn = null;
	public PreparedStatement ps = 	null;
	public ResultSet rs = null;
	@Override
	public List<UserModel> findAll() {
		String sql ="Select * from user";
		List<UserModel> list = new ArrayList<>(); // tao 1 list de truyen du lieu
		try {
			conn =new DBConnectMySQL().getDatabaseConnection() ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new UserModel(rs.getInt("id"),rs.getString("username"),rs.getString("email"), rs.getString("fullname"),rs.getString("image"), rs.getString("password"), rs.getString("phone"), rs.getInt("roleid"), rs.getDate("createdate")));
			}
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null; 
	
	}

	@Override
	public UserModel findByid(int id) {
	
		String sql ="select * from user where id = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection() ;
			ps = 	conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs =ps.executeQuery();
			while(rs.next())
			{
				 UserModel user = new UserModel();
		            user.setId(rs.getInt("id"));
		            user.setUsername(rs.getString("username"));
		            user.setPassword(rs.getString("password"));
		            user.setFullname(rs.getString("fullname"));
		            user.setEmail(rs.getString("email"));
		            user.setImage(rs.getString("image"));
		            user.setPhone(rs.getString("phone"));
		            user.setRoleid(rs.getInt("roleid"));
		            user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {///
		String sql = "INSERT INTO user(id,username,email,fullname,image,password,phone) VALUES (?,?,?,?,?,?,?)";
		try {
			conn =new DBConnectMySQL().getDatabaseConnection() ;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImage());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getPhone());
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		//userDao.insert(new UserModel(1,"sam","sam@gmail","nhansamle","1","sam123","0989873374","1",));
		List<UserModel> list  = userDao.findAll();
		for(UserModel user1 : list)
		{
			System.out.println(user1);
		}
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql ="select * from user where username = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection() ;
			ps = 	conn.prepareStatement(sql);
			ps.setString(1, username);
			rs =ps.executeQuery();
			while(rs.next())
			{
				 UserModel user = new UserModel();
		            user.setId(rs.getInt("id"));
		            user.setUsername(rs.getString("username"));
		            user.setPassword(rs.getString("password"));
		            user.setFullname(rs.getString("fullname"));
		            user.setEmail(rs.getString("email"));
		            user.setImage(rs.getString("image"));
		            user.setPhone(rs.getString("phone"));
		            user.setRoleid(rs.getInt("roleid"));
		            user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
