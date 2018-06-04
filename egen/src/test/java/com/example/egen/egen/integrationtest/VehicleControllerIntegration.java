package com.example.egen.egen.integrationtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.egen.egen.entity.Vehicle;
import com.example.egen.egen.repository.VehicleDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@ActiveProfiles("integration")
public class VehicleControllerIntegration {

	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private ObjectMapper objMapper;
	
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
		
		vehicleList.add(vehicle);
		vehicleDao.saveAll(vehicleList);
		
	}
	
	@After
	public void clear() {
		vehicleDao.deleteAll();
	}
	
	@Test
	public void testInsertVehicle() throws JsonProcessingException, Exception {
		ObjectMapper om = new ObjectMapper();
		Vehicle vehicle = new Vehicle();
		vehicle.setLastServiceDate(new Date());
		vehicle.setMake("TestMake");
		vehicle.setMaxFuelVolume(100);
		vehicle.setModel("TestModel");
		vehicle.setRedlineRpm(10);
		vehicle.setVin("TestId");
		vehicle.setYear(2018);
		
		mvc.perform(MockMvcRequestBuilders.put("/insertVehicle").content(objMapper.writeValueAsBytes(vehicle)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.vin",Matchers.notNullValue()));
	}

	@Test
	public void testInsertReadings() {

	}

	@Test
	public void testGetVehicles() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/getVehicles"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
	}

	@Test
	public void testFetchHighAlerts() {

	}

	@Test
	public void testFetchGeolocations() {

	}

	@Test
	public void testFetchAlertsByVehicle() {

	}

}
