package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto User);
	UserDto getUser(String email);

	UserDto getUserByUserId(String id);

    UserDto updateUser(String id, UserDto userDto);
}
