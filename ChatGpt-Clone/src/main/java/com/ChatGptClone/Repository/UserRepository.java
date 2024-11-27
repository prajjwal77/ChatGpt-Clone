package com.ChatGptClone.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ChatGptClone.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	 Optional<User> findByUsername(String username);
}
