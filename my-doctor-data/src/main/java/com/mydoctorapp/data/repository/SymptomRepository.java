package com.mydoctorapp.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydoctorapp.data.bean.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom,Integer>{

	Symptom findBySymptomName(String symptomName);

	List<Symptom> findBySymptomNameStartingWith(String symptomName);

	List<Symptom> findBySymptomNameContaining(String symptomName);

	List<Symptom> findBySymptomNameLike(String symptomName);

}
