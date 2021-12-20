package com.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Funds;

@Repository
public interface FundsRepository extends CrudRepository<Funds, Integer>{
	
	Funds findByfundsName(String name);

}
