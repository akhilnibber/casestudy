package com.virtusa.customerapidemo.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name="Pan_Details")
public class PanValidation {
	
	@Id
	@Column(name="Pan_Number")
	private String panNumber;
	
	@Embedded
	@Column(name="Name",nullable = false)
	private FullName name;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="dob")
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_Id",unique = true)
	private Customer customer;
	
	
	public PanValidation() {
		super();
	}

	public PanValidation(String panNumber, FullName name, LocalDate dob) {
		super();
		this.panNumber = panNumber;
		this.name = name;
		this.dob = dob;
	}
	
	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public FullName getName() {
		return name;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
