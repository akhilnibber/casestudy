package com.virtusa.banking.appointment.models;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Appointment_Id")
	private long appointmentId;
	@Enumerated(EnumType.STRING)
	@Column(name="Appointment_Type")
	private AppointmentType appointmentType;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	@Column(name="Appointment_Time")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime appointmentTime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="Appointment_Date")
	private Date appointmentDate;
	@Column(name="RM_Id")
	private long rmId;
	@Column(name="Customer_Id")
	private long customerId;
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public Date getAppointmentDate() {
		return (Date) appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public long getRmId() {
		return rmId;
	}
	public void setRmId(long rmId) {
		this.rmId = rmId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	
}
