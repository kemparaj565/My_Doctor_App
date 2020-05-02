package com.mydoctorapp.data.repository;

import java.util.List;

import com.mydoctorapp.data.bean.TreatmentProtocol;

public interface TreatmentProtocolRepository  {
	
//	@Query("SELECT distinct dis.disease_name,sym.symptom_name,med.medicine_name,med.Treatment_description," + 
//		"med.duration_to_use FROM SYMPTOM  sym JOIN  DISEASE dis on  sym.symptom_name=dis.symptom " + 
//		"join medicine med on med.symptom_name=sym.symptom_name where sym.symptom_name=:symptomName")
	//List<TreatmentProtocol> find(@Param("symptomName") String symptomName);

	//List<TreatmentProtocol> findByMedicineNameContaining(String medicineName);

	//List<TreatmentProtocol> findBySymptomNameStartingWith(String symptomName);

	//TreatmentProtocol findByDiseaseName(String diseaseName);
	
	
	List<TreatmentProtocol> locateProtocol(String symptomName);

}
