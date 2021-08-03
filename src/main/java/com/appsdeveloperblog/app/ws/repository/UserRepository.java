package com.appsdeveloperblog.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
    UserEntity findByUserId(String userId);
    UserEntity findUserByEmailVerificationToken(String token);
}
