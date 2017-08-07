package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	private UserDAO dao;
	
	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public UserDTO getUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.getUser(dto);
	}
	
}
