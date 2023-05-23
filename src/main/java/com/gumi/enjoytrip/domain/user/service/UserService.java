package com.gumi.enjoytrip.domain.user.service;

import com.gumi.enjoytrip.domain.user.dto.UserCreateDto;
import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.dto.UserUpdateDto;

public interface UserService {
	UserDto getLoginUser(String userId, String password);
	UserDto getUser(long id);
	UserDto getUser(String userId);
	void changePassword(long id, String password);
	void updateUser(long id, UserUpdateDto dto);
	void createUser(UserCreateDto dto);
	void deleteUser(long id);
}
