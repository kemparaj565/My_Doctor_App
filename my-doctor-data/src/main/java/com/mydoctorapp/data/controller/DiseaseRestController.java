package com.mydoctorapp.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydoctorapp.data.bean.Disease;
import com.mydoctorapp.data.bean.Symptom;
import com.mydoctorapp.data.repository.DiseaseRepository;

@CrossOrigin
@RestController
public class DiseaseRestController {
	
	
	@Autowired
	DiseaseRepository diseaseRepo;
	
	
	@GetMapping("/list-diseases")
	public List<Disease> getAllDiseases(){
		return diseaseRepo.findAll();
	}
	
	@GetMapping("/query-disease")
	public Disease getDisease(@RequestParam(required=true,defaultValue="Typhoid Fever") String diseaseName) {
		return diseaseRepo.findByDiseaseName(diseaseName);
	}
	
	@GetMapping("/query-disease-by-name")
	public List<Disease> getDiseaseByName(@RequestParam(required=true,defaultValue="Typhoid Fever") String diseaseName) {
		return diseaseRepo.findByDiseaseNameStartingWith(diseaseName);
	}
	
	@GetMapping("/query-disease-contains-name")
	public List<Disease> getDiseaseContainsName(@RequestParam(required=true,defaultValue="Common Cold") String diseaseName) {
			return diseaseRepo.findByDiseaseNameContaining(diseaseName);
	}

	
	@GetMapping("/list-disease/{id}")
	public Optional<Disease> getDiseaseById(@PathVariable("id") Integer id) {
		return diseaseRepo.findById(id);
	}

	@PostMapping("/new-disease")
	public Disease createNewDisease(@RequestParam Disease disease) {
		return diseaseRepo.save(disease);
	}
	
	@PutMapping("/update-disease")
	public Disease updateExistingDisease(@RequestParam Disease disease) {
		return diseaseRepo.save(disease);
	}
	
	@DeleteMapping("/remove-disease/{id}")
	public Optional<Disease> deleteExistingDisease(@PathVariable("id") Integer id) {
		Optional<Disease> disease=diseaseRepo.findById(id);
		diseaseRepo.deleteById(id);
		return disease;
	}
	
}
