package com.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Investors;

@Repository
public interface InvestorsRepository extends CrudRepository<Investors, Integer>{

}
