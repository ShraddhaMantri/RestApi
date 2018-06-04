package com.example.egen.egen.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egen.egen.entity.Alerts;
import com.example.egen.egen.entity.Readings;
import com.example.egen.egen.entity.Vehicle;
import com.example.egen.egen.repository.AlertsDao;
import com.example.egen.egen.repository.VehicleDao;

@Service
public class AlertsService {
	
	@Autowired
	private AlertsDao alertsDao;
	
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Transactional
	public void insertAlerts(Readings readings) {
		Alerts alerts = new Alerts();
		String vin = readings.getVin();
		Optional<Vehicle> veh = vehicleDao.findById(vin);
		if(veh.isPresent()) {
			if(readings.getEngineRpm() > veh.get().getRedlineRpm()) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("HIGH");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.getFuelVolume() < (veh.get().getMaxFuelVolume() * 10/100)) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("MEDIUM");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("LOW");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("LOW");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("LOW");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("LOW");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
			if(readings.isEngineCoolantLow() == true || readings.isCheckEngineLightOn() == true) {
				alerts.setCaptureTime(readings.getTimestamp());
				alerts.setPriority("LOW");
				alerts.setVin(vin);
				alertsDao.save(alerts);
			}
		}
	}
	
	public List<Alerts> fetchHighAlerts(){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());

		calendar.add(Calendar.HOUR, -2);//substract the number of days to look back
		Date dateToLookBackAfter = (Date) calendar.getTime();
		System.out.println(dateToLookBackAfter);
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
		
		
		List<Alerts> alerts = new ArrayList<Alerts>();
		alerts = alertsDao.fetchHighAlerts(ds);
		return alerts;
	}
	
	public List<Alerts> fetchAlertsByVehicle(String vin){
		List<Alerts> alerts = new ArrayList<Alerts>();
		alerts = alertsDao.fetchAlertsByVehicle(vin);
		return alerts;
	}
}
