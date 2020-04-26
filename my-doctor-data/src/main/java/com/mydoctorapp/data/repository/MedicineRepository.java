package com.mydoctorapp.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mydoctorapp.data.bean.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

	Medicine findByMedicineName(String medicineName);

	List<Medicine> findByMedicineNameStartingWith(String medicineName);

	List<Medicine> findByMedicineNameContaining(String medicineName);

	Medicine findBySymptomName(String symptomName);

	List<Medicine> findBySymptomNameContaining(String symptomName);

	List<Medicine> findDistinctByDiseaseNameContaining(String diseaseName);

}
