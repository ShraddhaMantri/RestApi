package com.example.egen.egen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	private String vin;
	private String make;
	private String model;
	private int year;
	private int redlineRpm;
	private int maxFuelVolume;
	private Date lastServiceDate;
	
	public Vehicle() {
		
	}

	public Vehicle(String vin, String make, String model, int year, int redlineRpm, int maxFuelVolume,
			Date lastServiceDate) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm = redlineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public String getVin() {
		return vin;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public int getRedlineRpm() {
		return redlineRpm;
	}

	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm="
				+ redlineRpm + ", maxFuelValue=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]";
	}
}
