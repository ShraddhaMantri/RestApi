package com.example.egen.egen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.egen.egen.entity.Tires;

@Repository 
public interface TiresDao extends CrudRepository<Tires, String> {

}
