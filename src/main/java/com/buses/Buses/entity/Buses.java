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
@Table(name="bus")
public class Buses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="motor")
	private String motor;
	
	@Column(name="brakes")
	private String brakes;
	
    @JoinColumn(name = "concessionaireid", referencedColumnName = "id")
    @ManyToOne
	private Concessionaire concessionaireId;

	public Buses() {}
	
	public Buses(int id, String type, String motor ,  String brakes , Concessionaire concessionaireId) {
		this.id = id;
		this.type = type;
		this.motor = motor;
		this.brakes = brakes;
		this.concessionaireId = concessionaireId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setTyper(String type) {
		this.type = type;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getBrakes() {
		return this.brakes;
	}

	public void setBrakes(String brakes) {
		this.brakes = brakes;
	}

	public Concessionaire getConcessionaireId() {
		return concessionaireId;
	}

	public void setConcessionaireId(Concessionaire concessionaireId) {
		this.concessionaireId = concessionaireId;
	}

	
	
}