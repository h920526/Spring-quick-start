package service;

import java.util.List;

import model.User;

public interface UserService {

	public void createUser(User user);

	public User findUserByKey(int userKey);

	public User findUserByName(String userName);

	public List<User> findAllUsers();

	public void updateUser(User user);

	public void deleteUserByKey(int userKey);

}
