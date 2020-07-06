package com.sim.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.sim.app.dao.SimCardDao;
import com.sim.app.entities.Users;

@Service
public class SimCardService {

	@Autowired
	private SimCardDao simCardDao;

	public Users createUser(Users user) {
		return simCardDao.save(user);
	}

	// @Cacheable(value = "userCache", key = "#userId", unless = "#result==null")
	public Users getUserById(Long userId) throws RuntimeException {
		Users findOne = simCardDao.findOne(userId);
		return findOne;
	}

	public Iterable<Users> getAllUsers() {
		return simCardDao.findAll();
	}

	@CacheEvict(value = "userCache", key = "#userId")
	public void deleteUser(Long userId) {
		simCardDao.delete(userId);
	}

	public List<Users> getListOfUSersByNetwoek(int operator) {
		List<Users> listOfUsers = simCardDao.fetchListOfUsersByNetwork(operator);
		return listOfUsers;
	}
}
