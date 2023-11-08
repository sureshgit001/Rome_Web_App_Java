package com.restaurent.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurent.models.UserInfo;
@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
	
	@Query(value = "select u from UserInfo u where u.userEmail = :email and u.userPassword = :pass")
	public UserInfo getUserByEmailAndPass(@Param(value = "email") String email, @Param(value = "pass") String pass);
	
	public UserInfo findByUserEmail(String UserEmail);
}
