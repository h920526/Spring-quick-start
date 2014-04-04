package dao;

import model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userName=:userName")
	public User findUserByName(@Param("userName") String userName);

}
