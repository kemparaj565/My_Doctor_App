package com.mydoctorapp.data.bean;

import java.awt.print.Book;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import lombok.NoArgsConstructor;


//@JsonIgnoreProperties(value= {"id","symptomName"})
@NoArgsConstructor
@Entity

//@SqlResultSetMappings({
//@SqlResultSetMapping(
//        name = "TreatmentProtocolAndEntityMapping",
//        entities = {
//            @EntityResult(
//                    entityClass = Disease.class,
//                    fields = {
//                        @FieldResult(name = "id", column = "Disease_ID"),
//                        @FieldResult(name = "diseaseName", column = "diseaseName"),
//                        @FieldResult(name = "symptom", column = "symptom"),
//                        @FieldResult(name = "diseaseDescription", column = "diseaseDescription"),
//                        @FieldResult(name = "durationOfDisease", column = "durationOfDisease")}),
//            @EntityResult(
//                    entityClass = Symptom.class,
//                    fields = {
//                        @FieldResult(name = "id", column = "Symptom_ID"),
//                        @FieldResult(name = "symptomName", column = "symptomName"),
//                        @FieldResult(name = "symptomDescription", column = "symptomDescription"),
//                        @FieldResult(name = "durationOfSymptom", column = "durationOfSymptom")
//                        }),
//            @EntityResult(
//                    entityClass = Medicine.class,
//                    fields = {
//                        @FieldResult(name = "id", column = "Medicine_ID"),
//                        @FieldResult(name = "medicineName", column = "medicineName"),
//                        @FieldResult(name = "diseaseName", column = "diseaseName"),
//                        @FieldResult(name = "symptomName", column = "symptomName"),
//                        @FieldResult(name = "treatmentDescription", column = "treatmentDescription"),
//                        @FieldResult(name = "numberOfTimesPrescribed", column = "numberOfTimesPrescribed"),
//                        @FieldResult(name = "vendorName", column = "vendorName"),
//                        @FieldResult(name = "durationToUse", column = "durationToUse")
//                    })},
//        classes = @ConstructorResult(
//                targetClass = TreatmentProtocol.class,
//                columns = {
//                    @ColumnResult(name = "protocolId", type = Integer.class),
//                    @ColumnResult(name = "disease"),
//                    @ColumnResult(name = "symptom"),
//                    @ColumnResult(name = "medicineName"),
//                    @ColumnResult(name = "treatmentDescription"),
//                    @ColumnResult(name = "durationToUse", type = Long.class),
//                }))
//})
public class Medicine implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Medicine_ID", updatable = false, nullable = false)
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
