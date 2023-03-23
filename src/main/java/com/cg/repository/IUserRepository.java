package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

	boolean existsByuserId(String userId);

	Optional<User> findByuserId(String userId);

}
