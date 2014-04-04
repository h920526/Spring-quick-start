package service;

import java.util.List;

import model.User;

public interface UserService {

	public void createUser(User user);

	public User findUserByKey(int userKey);

	public List<User> findAllUsers();

	public User findUserById(String userId);

	public void updateUser(User user);

	public void deleteUserByKey(int userKey);

}
