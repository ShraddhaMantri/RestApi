package com.example.egen.egen;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.egen.egen.entity.Alerts;
import com.example.egen.egen.repository.AlertsDao;
import com.example.egen.egen.service.AlertsService;
import com.example.egen.egen.service.VehicleService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class AlertsTest {

	List<Alerts> alertsList;
	
	@Autowired
	private AlertsService alertsService;
	
	@TestConfiguration
	static class AlertsServiceMock {
		@Bean
		public AlertsService getVehicleService() {
			return new AlertsService();
		}
	}
	
	@MockBean
	private AlertsDao alertsDao;
	
	@Before
	public void setUp() {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR, 3);
		Date dateToLookBackAfter = (Date) calendar.getTime();
		System.out.println("--------------------------------------"+dateToLookBackAfter);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sm.format(dateToLookBackAfter);
		System.out.println(time);
		Date ds = null;
		try {
			ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alerts alerts = new Alerts();
		alerts.setAlertid(101);
		alerts.setCaptureTime(ds);
		alerts.setPriority("HIGH");
		alerts.setVin("TestId");
		
		alertsList = Collections.singletonList(alerts);
		Mockito.when(alertsDao.findAll()).thenReturn(alertsList);
	}
	
	@Test
	public void testInsertAlerts() {

	}

	@Test
	public void testFetchHighAlerts() {
		List<Alerts> alerts = alertsService.fetchHighAlerts();
		Assert.assertEquals(alerts, alertsList);
	}

	@Test
	public void testFetchAlertsByVehicle() {

	}

}
