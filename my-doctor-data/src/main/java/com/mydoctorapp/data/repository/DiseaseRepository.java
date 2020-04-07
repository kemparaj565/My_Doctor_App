package com.mydoctorapp.data.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mydoctorapp.data.bean.Disease;
import com.mydoctorapp.data.bean.Symptom;

@Configuration
public interface DiseaseRepository extends JpaRepository<Disease,Integer>{
	
	Disease findByDiseaseName(String diseaseName);
	List<Disease> findByDiseaseNameStartingWith(String diseaseName);
	List<Disease> findByDiseaseNameContaining(String diseaseName);

}
