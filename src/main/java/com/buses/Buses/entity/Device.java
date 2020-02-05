package com.buses.Buses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="device")
public class Device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="ip")
	private String ip;

	@Column(name="devicetypeid")
	private int devideTypeId;
	
	@Column(name="busid")
	private int busId;
	
	@Column(name="status")
	private String status;

	public Device() {}
	
	public Device(int id, String ip, int devicetypeid , int busid, String status) {
		this.id = id;
		this.ip = ip;
		this.devideTypeId = devicetypeid;
		this.busId = busid;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getDevideTypeId() {
		return devideTypeId;
	}

	public void setDevideTypeId(int devideTypeId) {
		this.devideTypeId = devideTypeId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}