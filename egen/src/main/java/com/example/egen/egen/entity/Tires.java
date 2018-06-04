package com.example.egen.egen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tires {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int TireId;
	private int frontLeft;
	private int frontRight;
	private int rearLeft;
	private int rearRight;
	
	public Tires() {
		
	}

	public Tires(int frontLeft, int frontRight, int rearLeft, int rearRight) {
		super();
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.rearLeft = rearLeft;
		this.rearRight = rearRight;
	}

	public int getFrontLeft() {
		return frontLeft;
	}

	public int getFrontRight() {
		return frontRight;
	}

	public int getRearLeft() {
		return rearLeft;
	}

	public int getRearRight() {
		return rearRight;
	}

	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}

	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}

	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}

	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}
	
	
}
