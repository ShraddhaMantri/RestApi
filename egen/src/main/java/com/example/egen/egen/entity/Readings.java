package com.example.egen.egen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Readings.fetchGeolocations", query = "SELECT r.latitude, r.longitude FROM Readings r WHERE r.vin = :input1 AND r.timestamp > :input2")
public class Readings {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int vehicleId;
	private String vin;
	private double latitude;
	private double longitude;
	private Date timestamp;
	private double fuelVolume;
	private int speed;		
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private int engineRpm;
	@OneToOne
	private Tires tires;
	
	public Readings() {
		
	}

	public Readings(String vin, double latitude, double longitude, Date timestamp, double fuelVolume, int speed,
			int engineHp, boolean checkEngineLightOn, boolean engineCoolantLow, boolean cruiseControlOn, int engineRpm,
			Tires tires) {
		super();
		this.vin = vin;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.fuelVolume = fuelVolume;
		this.speed = speed;
		this.engineHp = engineHp;
		this.checkEngineLightOn = checkEngineLightOn;
		this.engineCoolantLow = engineCoolantLow;
		this.cruiseControlOn = cruiseControlOn;
		this.engineRpm = engineRpm;
		this.tires = tires;
	}

	public String getVin() {
		return vin;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public double getFuelVolume() {
		return fuelVolume;
	}

	public int getSpeed() {
		return speed;
	}

	public int getEngineHp() {
		return engineHp;
	}

	@Override
	public String toString() {
		return "Readings [vehicleId=" + vehicleId + ", vin=" + vin + ", latitude=" + latitude + ", longitude="
				+ longitude + ", timestamp=" + timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed
				+ ", engineHp=" + engineHp + ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow="
				+ engineCoolantLow + ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires="
				+ tires + "]";
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public int getEngineRpm() {
		return engineRpm;
	}

	public Tires getTires() {
		return tires;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}
	
	
}
