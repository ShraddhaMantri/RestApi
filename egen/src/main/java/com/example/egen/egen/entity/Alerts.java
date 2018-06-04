package com.example.egen.egen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Alerts.fetchHighAlerts", query = "SELECT a FROM Alerts a WHERE a.priority = 'HIGH' AND a.captureTime > :input"),
	@NamedQuery(name = "Alerts.fetchAlertsByVehicle", query = "SELECT a FROM Alerts a WHERE a.vin = :input")
})
public class Alerts {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int alertid;
	private String vin;
	private String priority;
	private Date captureTime;
	
	public Alerts() {
		
	}

	public Alerts(int alertid, String vin, String priority, Date captureTime) {
		super();
		this.alertid = alertid;
		this.vin = vin;
		this.priority = priority;
		this.captureTime = captureTime;
	}

	public int getAlertid() {
		return alertid;
	}

	public String getVin() {
		return vin;
	}

	public String getPriority() {
		return priority;
	}

	public Date getCaptureTime() {
		return captureTime;
	}

	public void setAlertid(int alertid) {
		this.alertid = alertid;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setCaptureTime(Date captureTime) {
		this.captureTime = captureTime;
	}
}
