package com.virtusa.banking.appointment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.virtusa.banking.appointment.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
	
	public List<Appointment> findByrmId(@Param("rmId") long rmId);
	
	public List<Appointment> findBycustomerId(@Param("customerId") long customerId);

}
