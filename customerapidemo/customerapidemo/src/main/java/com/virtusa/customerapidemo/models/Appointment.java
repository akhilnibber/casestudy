package com.virtusa.customerapidemo.models;

import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
	
	private long appointmentId;
	
	private AppointmentType appointmentType;

	private LocalTime appointmentTime;
	
	private LocalDate appointmentDate;

	private long rmId;
	
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
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
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
