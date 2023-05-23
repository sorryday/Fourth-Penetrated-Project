package com.gumi.enjoytrip.domain.user.service;

import com.gumi.enjoytrip.domain.user.dao.UserDaoImpl;
import com.gumi.enjoytrip.domain.user.dto.UserCreateDto;
import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.dto.UserUpdateDto;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	@Override
	public UserDto getLoginUser(String userId, String password) {
		return UserDaoImpl.getInstance().getLoginUser(userId, password);
	}

	@Override
	public UserDto getUser(long id) {
		return UserDaoImpl.getInstance().getUser(id);
	}

	@Override
	public UserDto getUser(String userId) {
		return UserDaoImpl.getInstance().getUser(userId);
	}

	@Override
	public void changePassword(long id, String password) {
		UserDaoImpl.getInstance().changePassword(id, password);
	}

	@Override
	public void updateUser(long id, UserUpdateDto dto) {
		UserDaoImpl.getInstance().updateUser(id, dto);
	}

	@Override
	public void createUser(UserCreateDto dto) {
		UserDaoImpl.getInstance().createUser(dto);
	}

	@Override
	public void deleteUser(long id) {
		UserDaoImpl.getInstance().deleteUser(id);
	}

}
