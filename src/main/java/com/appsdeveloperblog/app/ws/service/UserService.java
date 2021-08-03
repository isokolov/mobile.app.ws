package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto User);
	UserDto getUser(String email);
	UserDto getUserByUserId(String id);
    UserDto updateUser(String id, UserDto userDto);
	void deleteUser(String id);
	boolean verifyEmailToken(String token);
//	boolean requestPasswordReset(String email);
//	boolean resetPassword(String token, String password);
	List<UserDto> getUsers(int page, int limit);
}
