package com.virtusa.customerapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.customerapidemo.models.Customer;
import com.virtusa.customerapidemo.models.PanValidation;
import com.virtusa.customerapidemo.services.PanValidationService;

@RestController
public class PanValidationController {
	
	@Autowired
	private PanValidationService panValidationService;
	
	@CrossOrigin("*")
	@PostMapping("/customers/{id}/addPanDetails")
	public @ResponseBody ResponseEntity<String> addPanDetails(@RequestBody PanValidation panValidation,
			@PathVariable long id)
	{
		if(this.panValidationService.savePanDetails(panValidation, id)!=null)
			return ResponseEntity.ok("Pan Details are been added");
		else
			return ResponseEntity.ok("Customer Not found, Pan Details cannot be Added");
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/customers/panDetails/{panNumber}", 
	  produces = { "application/json", "application/xml" }, 
	  method = RequestMethod.GET)
	public PanValidation getPanDetails(@PathVariable String panNumber)
	{
		return this.panValidationService.getPanDetails(panNumber);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/customers/{customerId}/panDetails", 
	  produces = { "application/json", "application/xml" }, 
	  method = RequestMethod.GET)
	public PanValidation getPanDetails(@PathVariable long customerId)
	{
		return this.panValidationService.getPanDetailsbyCustomerId(customerId);
	}
	
	

}
