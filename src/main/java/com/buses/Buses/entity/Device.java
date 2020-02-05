package com.buses.Buses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
    @JoinColumn(name = "devicetypeid", referencedColumnName = "id")
    @ManyToOne
	private DeviceType devidetypeid;
	
    @JoinColumn(name = "busid", referencedColumnName = "id")
    @ManyToOne
	private Buses busId;
	
	@Column(name="status")
	private String status;

	public Device() {}
	
	public Device(int id, String ip, DeviceType devicetypeid , Buses busid, String status) {
		this.id = id;
		this.ip = ip;
		this.devidetypeid = devicetypeid;
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
	
	public DeviceType getDevideTypeId() {
		return devidetypeid;
	}

	public void setDevideTypeId(DeviceType devideTypeId) {
		this.devidetypeid = devideTypeId;
	}

	public Buses getBusId() {
		return busId;
	}

	public void setBusId(Buses busId) {
		this.busId = busId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}