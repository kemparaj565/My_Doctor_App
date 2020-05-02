package com.mydoctorapp.data.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import com.mydoctorapp.data.bean.TreatmentProtocol;
import com.mydoctorapp.data.dao.TreatmentProtocolImpl;
import com.mydoctorapp.data.repository.SymptomRepository;

@CrossOrigin
@RestController
public class SymptomRestController {
	
	
	@Autowired
	SymptomRepository symptomRepo;
	
	@Autowired
	TreatmentProtocolImpl treatmentImpl;
	
	
	@GetMapping("/list-symptoms")
	public List<Symptom> getAllsymptoms(){
		return symptomRepo.findAll();
	}
	
	@GetMapping("/query-symptom")
	public Symptom getSymptom(@RequestParam(required=true,defaultValue="Common Cold") String symptomName) {
		return symptomRepo.findBySymptomName(symptomName);
	}
	
	@GetMapping("/query-symptom-by-name")
	public List<Symptom> getSymptomByName(@RequestParam(required=true,defaultValue="Common Cold") String symptomName) {
			return symptomRepo.findBySymptomNameStartingWith(symptomName);
	}
	
	@GetMapping("/query-symptom-contains-name")
	public List<Symptom> getSymptomContainsName(@RequestParam(required=true,defaultValue="Common Cold") String symptomName) {
			return symptomRepo.findBySymptomNameContaining(symptomName);
	}
	
	@GetMapping("/list-symptom/{id}")
	public Optional<Symptom> getsymptomById(@PathVariable("id") Integer id) {
		return symptomRepo.findById(id);
	}

	@PostMapping("/new-symptom")
	public Symptom createNewsymptom(@RequestParam Symptom symptom) {
		return symptomRepo.save(symptom);
	}
	
	@PutMapping("/update-symptom")
	public Symptom updateExistingsymptom(@RequestParam Symptom symptom) {
		return symptomRepo.save(symptom);
	}
	
	@DeleteMapping("/remove-symptom/{id}")
	public Optional<Symptom> deleteExistingsymptom(@PathVariable("id") Integer id) {
		Optional<Symptom> symptom=symptomRepo.findById(id);
		symptomRepo.deleteById(id);
		return symptom;
	}
	
	@GetMapping("/get-treatment-protocol")
	public List<TreatmentProtocol> getTreatmentProtocol(@RequestParam("symptomName") String symptomName) throws ClassNotFoundException, SQLException, NamingException{
		return treatmentImpl.locateProtocol(symptomName);
		
	}
	
}
