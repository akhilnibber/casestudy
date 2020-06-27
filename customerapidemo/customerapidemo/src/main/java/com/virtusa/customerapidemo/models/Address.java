package com.virtusa.customerapidemo.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name="Global_Address")
@XmlRootElement
public class Address implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="Addess_Ref")
	private long addressId;
	
	@Column(name="Door_No")
	private String doorNo;

	@Column(name="Street_Name")
	private String streetName;
	
	@Column(name="City")
	private String city;
	
	@Column(name="ZipCode")
	private long zipCode;	
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_Id")
	private Customer customer;
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
