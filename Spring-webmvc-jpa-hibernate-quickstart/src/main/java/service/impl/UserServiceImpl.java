package service.impl;

import java.util.List;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.UserService;
import dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void createUser(User user) {
		userDao.save(user);
	}

	@Override
	public User findUserByKey(int userKey) {
		return userDao.findOne(userKey);
	}

	@Override
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUserByKey(int userKey) {
		userDao.delete(userKey);
	}

}
