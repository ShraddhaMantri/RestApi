package com.example.egen.egen.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egen.egen.entity.Readings;
import com.example.egen.egen.entity.Tires;
import com.example.egen.egen.repository.ReadingsDao;
import com.example.egen.egen.repository.TiresDao;

@Service
public class ReadingsService {
	
	@Autowired
	private ReadingsDao readingsDao;
	
	@Autowired
	private TiresDao tiresDao;
	
	public void postReadings(Readings param) {
		tiresDao.save(param.getTires());
		readingsDao.save(param);
	}
	
	public List<Readings> fetchGeolocations(String vin) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());

		calendar.add(Calendar.MINUTE, -30);//substract the number of days to look back
		Date dateToLookBackAfter = (Date) calendar.getTime();
		System.out.println(dateToLookBackAfter);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sm.format(dateToLookBackAfter);
		System.out.println(time);
		Date ds = null;
		try {
			ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Readings> readings = new ArrayList<Readings>();
		readings = readingsDao.fetchGeolocations(vin, ds);
		return readings;
	}
}
