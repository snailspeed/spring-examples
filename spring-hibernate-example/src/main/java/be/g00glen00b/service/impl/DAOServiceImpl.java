package be.g00glen00b.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.g00glen00b.dao.UserDAO;
import be.g00glen00b.entities.UserEntity;
import be.g00glen00b.service.DAOService;

@Component("daoService")
public class DAOServiceImpl implements DAOService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public UserEntity getUser(int id) {
		return userDao.findById(id);
	}
}
