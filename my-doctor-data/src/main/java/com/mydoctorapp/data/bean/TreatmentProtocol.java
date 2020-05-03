package com.mydoctorapp.data.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;




//@NamedNativeQuery(name="getTreatmentProtocol",query="SELECT distinct dis.disease_name,sym.symptom_name,med.medicine_name,med.Treatment_description," + 
//		"med.duration_to_use FROM SYMPTOM  sym JOIN  DISEASE dis on  sym.symptom_name=dis.symptom" + 
//		"join medicine med on med.symptom_name=sym.symptom_name where sym.symptom_name=?1",resultClass=TreatmentProtocol.class)

@NoArgsConstructor
public class TreatmentProtocol{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="Protocol_ID")
	//@JsonIgnore
	private Integer protocolId;
	
	private String diseaseName;
	
	
	private String symptomName;
	
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="med_symptomName", referencedColumnName="symptomName",nullable = false, updatable = false)
//	@JoinColumns({
//        @JoinColumn(name="ADDR_ID", referencedColumnName="ID"),
//    
//        @JoinColumn(name="treatmentDescription"),
//        @JoinColumn(name="durationToUse")
//    })
	private String medicineName;
	
	private String medicineDescription;
	
	private Long medicineDuration;

	public TreatmentProtocol(String diseaseName, String symptomName, String medicineName, String medicineDescription,
			Long medicineDuration) {
		super();
		this.diseaseName = diseaseName;
		this.symptomName = symptomName;
		this.medicineName = medicineName;
		this.medicineDescription = medicineDescription;
		this.medicineDuration = medicineDuration;
	}

	public Integer getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
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

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public Long getMedicineDuration() {
		return medicineDuration;
	}

	public void setMedicineDuration(Long medicineDuration) {
		this.medicineDuration = medicineDuration;
	}

	
	



}
