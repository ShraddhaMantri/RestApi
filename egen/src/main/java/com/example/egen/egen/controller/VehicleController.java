package com.example.egen.egen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.egen.egen.entity.Alerts;
import com.example.egen.egen.entity.Readings;
import com.example.egen.egen.entity.Tires;
import com.example.egen.egen.entity.Vehicle;
import com.example.egen.egen.service.AlertsService;
import com.example.egen.egen.service.ReadingsService;
import com.example.egen.egen.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@CrossOrigin("*")
@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ReadingsService readingsService;
	
	@Autowired
	private AlertsService alertsService;
	
	@PutMapping("/vehicles")
	public int insertVehicle(@RequestBody List<Vehicle> param) {
		try {
		
		    vehicleService.putVehicle(param);
		}
		catch(Exception e) {
			
		}
		return -1;
	}
	
	@PostMapping("/readings")
	public void insertReadings(@RequestBody Readings param) {
		try {
			readingsService.postReadings(param);
			alertsService.insertAlerts(param);
		}
		catch(Exception e) {
			
		}
	}
	
	@GetMapping("/getVehicles")
	public List<Vehicle> getVehicles(){
		List<Vehicle> veh = new ArrayList<Vehicle>();
		try {
			veh = vehicleService.getVehicle();
		}
		catch (Exception e) {
			
		}
		return veh;
	}
	
	@GetMapping("/fetchHighAlerts")
	public List<Alerts> fetchHighAlerts(){
		List<Alerts> alerts = new ArrayList<Alerts>();
		try {
			alerts = alertsService.fetchHighAlerts();
		}
		catch(Exception e) {
			
		}
		return alerts;
	}
	
	@GetMapping("fetchGeolocations/{vehiclenumber}")
	public List<Readings> fetchGeolocations(@PathVariable String vehiclenumber){
		List<Readings> readings = new ArrayList<Readings>();
		try {
			readings = readingsService.fetchGeolocations(vehiclenumber);
		}
		catch(Exception e) {
			
		}
		
	
		return readings;
	}
	
	@GetMapping("fetchAlertsByVehicle/{vehiclenumber}")
	public List<Alerts> fetchAlertsByVehicle(@PathVariable String vehiclenumber){
		List<Alerts> alerts = new ArrayList<Alerts>();
		try {
			alerts = alertsService.fetchAlertsByVehicle(vehiclenumber);
		}
		catch(Exception e) {
			
		}
		return alerts;
	}
	
}
