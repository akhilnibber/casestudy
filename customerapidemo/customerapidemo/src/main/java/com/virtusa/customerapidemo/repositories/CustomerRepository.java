package com.virtusa.customerapidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.customerapidemo.models.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Long> {

	
}
