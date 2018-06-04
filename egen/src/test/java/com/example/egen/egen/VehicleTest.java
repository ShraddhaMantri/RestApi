package com.example.egen.egen;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.egen.egen.entity.Vehicle;
import com.example.egen.egen.repository.VehicleDao;
import com.example.egen.egen.service.VehicleService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class VehicleTest {
	List<Vehicle> vehicleList;
	@Autowired
	private VehicleService vehicleService;
	
	@TestConfiguration
	static class VehicleServiceMock {
		@Bean
		public VehicleService getVehicleService() {
			return new VehicleService();
		}
	}
	
	@MockBean
	private VehicleDao vehicleDao;
	
	@Before
	public void setUp() {
		Vehicle vehicle = new Vehicle();
		vehicle.setLastServiceDate(new Date());
		vehicle.setMake("TestMake");
		vehicle.setMaxFuelVolume(100);
		vehicle.setModel("TestModel");
		vehicle.setRedlineRpm(10);
		vehicle.setVin("TestId");
		vehicle.setYear(2018);
		
		vehicleList = Collections.singletonList(vehicle);
		Mockito.when(vehicleDao.findAll()).thenReturn(vehicleList);
	}
	
	@Test
	public void testPutVehicle() {

	}

	@Test
	public void testGetVehicle() {
		List<Vehicle> vehicle = vehicleService.getVehicle();
		Assert.assertEquals(vehicle, vehicleList);
	}

}
