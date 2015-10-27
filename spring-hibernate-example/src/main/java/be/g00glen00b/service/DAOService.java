package be.g00glen00b.service;

import be.g00glen00b.entities.UserEntity;

public interface DAOService {

	public abstract UserEntity getUser(int id);

}