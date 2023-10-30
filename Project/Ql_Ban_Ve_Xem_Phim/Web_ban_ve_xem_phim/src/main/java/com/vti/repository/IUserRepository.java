package com.vti.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

//	boolean existsByUsername(String username);
//
//	User findByUsername(String username);
//	
//	@Query("FROM Account WHERE id IN(:ids)")
//	List<User> getListAccountByListId(@Param ("ids") Set<Integer> ids);
}
