package com.mydoctorapp.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mydoctorapp.data.bean.Symptom;
import com.mydoctorapp.data.bean.TreatmentProtocol;

public interface SymptomRepository extends JpaRepository<Symptom,Integer>{

	Symptom findBySymptomName(String symptomName);

	List<Symptom> findBySymptomNameStartingWith(String symptomName);

	List<Symptom> findBySymptomNameContaining(String symptomName);

	List<Symptom> findBySymptomNameLike(String symptomName);
	
//	@Query("SELECT distinct dis.disease_name as diseaseName,sym.symptom_name as symptomName,med.medicine_name as medicineName,med.Treatment_description as medicineDescription,"
//			+ "med.duration_to_use as medicineDuration FROM SYMPTOM  sym JOIN  DISEASE dis on  sym.symptom_name=dis.symptom "
//			+ "join medicine med on med.symptom_name=sym.symptom_name where sym.symptom_name=:symptomName")
//	List<TreatmentProtocol> getVal(@Param("symptomName") String symptomName);
//	
	

}
