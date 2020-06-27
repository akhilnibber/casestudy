package com.virtusa.customerapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.customerapidemo.models.Customer;
import com.virtusa.customerapidemo.models.PanValidation;
import com.virtusa.customerapidemo.repositories.PanValidationRepo;


@Service
public class PanValidationService {
	
	@Autowired
	private PanValidationRepo panValidationrepo;
	
	@Autowired
	private CustomerService customerService;
	
	public PanValidation savePanDetails(PanValidation panValidation,long id)
	{
		Customer customer=customerService.getCustomerById(id);
		if(customer!=null)
		{
			panValidation.setCustomer(customer);
			panValidationrepo.save(panValidation);
			return panValidation;
		}
		else
			return null;
	}
	
	public PanValidation getPanDetails(String panNumber)
	{
		return this.panValidationrepo.findById(panNumber).orElse(null);
	}
	
	public PanValidation getPanDetailsbyCustomerId(long customerId)
	{
		return this.panValidationrepo.findByCustomer(customerId);
	}
	

}
