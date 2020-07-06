package com.sim.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sim.app.entities.Users;

public interface SimCardDao extends CrudRepository<Users, Long>{

	@Query("SELECT s FROM SimCard s WHERE s.operator = :#{operator}")
	List<Users> fetchListOfUsersByNetwork(@Param("operator") int operator);

}
