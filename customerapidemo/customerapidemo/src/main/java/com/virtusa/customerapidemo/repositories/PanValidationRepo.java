package com.virtusa.customerapidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.virtusa.customerapidemo.models.PanValidation;

@Repository
public interface PanValidationRepo extends JpaRepository<PanValidation, String>{
	
	@Query("select pandetails from PanValidation pandetails where pandetails.customer.customerId=:customerId")
	public PanValidation findByCustomer(@Param("customerId") long customerId);

}
