package com.mydoctorapp.data.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;


//@JsonIgnoreProperties(value= {"id","symptomName"})
@NoArgsConstructor
@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Medicine_ID")
	private Integer id;
	
	private String medicineName;
	private String diseaseName;
	private String symptomName;
	private String treatmentDescription;
	private Long numberOfTimesPrescribed;
	private String vendorName;
	private String durationToUse;
	
	
	
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}
	public String getTreatmentDescription() {
		return treatmentDescription;
	}
	public void setTreatmentDescription(String treatmentDescription) {
		this.treatmentDescription = treatmentDescription;
	}
	public Long getNumberOfTimesPrescribed() {
		return numberOfTimesPrescribed;
	}
	public void setNumberOfTimesPrescribed(Long numberOfTimesPrescribed) {
		this.numberOfTimesPrescribed = numberOfTimesPrescribed;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getDurationToUse() {
		return durationToUse;
	}
	public void setDurationToUse(String durationToUse) {
		this.durationToUse = durationToUse;
	}
	public long getId() {
		return id;
	}
	
	public Medicine(String medicineName, String diseaseName, String symptomName, String treatmentDescription,
			Long numberOfTimesPrescribed, String vendorName, String durationToUse) {
		super();
		this.medicineName = medicineName;
		this.diseaseName = diseaseName;
		this.symptomName = symptomName;
		this.treatmentDescription = treatmentDescription;
		this.numberOfTimesPrescribed = numberOfTimesPrescribed;
		this.vendorName = vendorName;
		this.durationToUse = durationToUse;
	}
	
	

}
