package com.virtusa.banking.appointment.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import com.virtusa.banking.appointment.models.Appointment;
//import com.virtusa.banking.appointment.models.AuthenticationRequest;
//import com.virtusa.banking.appointment.models.Customer;
import com.virtusa.banking.appointment.repositories.AppointmentRepository;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;



@Service
public class AppointmentService {
    @Autowired
	private AppointmentRepository appointmentRepo;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${serviceUri}")
	private String serviceUrl;
    
	//@Value("${authUrl}")
	//private String authUrl;
	//@Value("${serviceUri}")
	//private String serviceUrl;
    
  //insert the appointment
	public Appointment saveAppointment(Appointment appointment)
  	{
  		System.out.println(serviceUrl+appointment.getCustomerId());
  		
  		Appointment responseAppointment=null;  		
  		ResponseEntity<String> response =restTemplate.exchange(serviceUrl+appointment.getCustomerId(),HttpMethod.GET,null,String.class);
  		//System.out.println(response.getBody());
  		if(response!=null)
  		{
  		 if(parseString(response.getBody())==appointment.getCustomerId()) 
  		    responseAppointment= this.appointmentRepo.save(appointment);
  		 	 
  		}
  		return responseAppointment;
		
   	}
  	
  	//findall
  	public List<Appointment> getAllAppointments()
  	{
  		return this.appointmentRepo.findAll();
  	}
  	

  	//select where by appointmentId
  	public Appointment getAppointmentById(long appointmentId)
  	{
  		return this.appointmentRepo.findById(appointmentId).orElse(null);
  		
  	}
  	
  	//delete the Appointment
  		public void deleteAppointmentById(long appointmentId)
  		{
  		     this.appointmentRepo.deleteById(appointmentId);
  		}
  	
  		//update the Appointment
  		public Appointment updateAppointment(Appointment appointment)
  		{
  			return this.appointmentRepo.save(appointment);
  		}
  		
  		//Appointments by RMID
  		public List<Appointment> getAppointmentByrmId(long rmid) {
			return this.appointmentRepo.findByrmId(rmid);
		}
  		
  	//Appointments by CustomerID
  		public List<Appointment> getAppointmentByCustomerId(long customerId) {
			return this.appointmentRepo.findBycustomerId(customerId);
		}
  		
  		private long parseString(String response)
  		{
  			JSONParser parser = new JSONParser(); 
  			long customerId=0;
  			
  		  	try {
  				Object obj = parser.parse(response);
  				JSONObject jsonObject = (JSONObject) obj;
  				String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
  				//System.out.println("\n=====Simple Flatten===== \n" + flattenedJson);
  				Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
  			 	customerId=Long.parseLong(flattenedJsonMap.get("customerId").toString());       
  				String nestedJson = JsonUnflattener.unflatten(flattenedJson);
  				//System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
  			} 
  		  	catch (Exception e) {
  				e.printStackTrace();
  			}
  		 return customerId;

  		}
    
}
