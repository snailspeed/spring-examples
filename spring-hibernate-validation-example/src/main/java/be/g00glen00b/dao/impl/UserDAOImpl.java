package be.g00glen00b.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.g00glen00b.dao.GenericDAOImpl;
import be.g00glen00b.dao.UserDAO;
import be.g00glen00b.entities.UserEntity;

@Repository("userDao")
@Transactional
public class UserDAOImpl extends GenericDAOImpl<UserEntity, Integer> implements UserDAO {

}
