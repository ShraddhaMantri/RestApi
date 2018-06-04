package com.example.egen.egen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.egen.egen.entity.Alerts;

@Repository
public interface AlertsDao extends CrudRepository<Alerts, String> {
	public List<Alerts> fetchHighAlerts(@Param("input") Date input);
	public List<Alerts> fetchAlertsByVehicle(@Param("input") String input);
}

