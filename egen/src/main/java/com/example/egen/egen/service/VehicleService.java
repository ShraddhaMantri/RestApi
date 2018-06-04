package com.example.egen.egen.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egen.egen.entity.Vehicle;
import com.example.egen.egen.repository.VehicleDao;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleDao vehicledao;
	
	@Transactional
	public void putVehicle(List<Vehicle> vehicle) {
		vehicle.forEach( (veh) -> System.out.println(veh));
		vehicle.forEach(veh -> vehicledao.save(veh));	
	}
	
	@Transactional
	public List<Vehicle> getVehicle(){
		List<Vehicle> veh = new ArrayList<Vehicle>();
		veh = (List<Vehicle>) vehicledao.findAll();
		return veh;
	}
}
