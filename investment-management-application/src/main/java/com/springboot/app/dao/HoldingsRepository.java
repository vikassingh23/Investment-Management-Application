package com.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Holdings;

@Repository
public interface HoldingsRepository extends CrudRepository<Holdings, Integer>{

}
