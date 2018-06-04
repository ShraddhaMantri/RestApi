package com.example.egen.egen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.egen.egen.entity.Readings;

@Repository
public interface ReadingsDao extends CrudRepository<Readings, String> {
	public List<Readings> fetchGeolocations(@Param("input1") String input1, @Param("input2") Date input2);
}
