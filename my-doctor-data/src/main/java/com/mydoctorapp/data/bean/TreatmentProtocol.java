package com.mydoctorapp.data.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TreatmentProtocol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Protocol_ID")
	private Integer id;
	
	private String diseaseName;
	
	private String symptomName;
	
	private String medicineName;
	
	private long durationOfMedication;

	public TreatmentProtocol(String diseaseName, String symptomName, String medicineName, long durationOfMedication) {
		super();
		this.diseaseName = diseaseName;
		this.symptomName = symptomName;
		this.medicineName = medicineName;
		this.durationOfMedication = durationOfMedication;
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

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public long getDurationOfMedication() {
		return durationOfMedication;
	}

	public void setDurationOfMedication(long durationOfMedication) {
		this.durationOfMedication = durationOfMedication;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
	
	
	
	

}
