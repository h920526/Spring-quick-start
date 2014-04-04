package service.impl;

import java.util.List;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User findUserById(String userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUserByKey(int userKey) {
		userDao.delete(userKey);
	}

	@Override
	public User loadAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			String userId = ((UserDetails) principal).getUsername();
			return findUserById(userId);
		}
		return null;
	}

}
