package com.example.egen.egen;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.egen.egen.repository.ReadingsDao;
import com.example.egen.egen.service.ReadingsService;
import com.example.egen.egen.service.VehicleService;

@RunWith(SpringRunner.class)
public class ReadingsTest {

	@Autowired
	private ReadingsService readingsService;
	
	@TestConfiguration
	static class ReadingsServiceMock {
		@Bean
		public ReadingsService getVehicleService() {
			return new ReadingsService();
		}
	}
	
	@MockBean
	private ReadingsDao readingsDao;
	
	@Test
	public void testPostReadings() {

	}

	@Test
	public void testFetchGeolocations() {

	}

}
