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

import com.mydoctorapp.data.bean.TreatmentProtocol;
import com.mydoctorapp.data.repository.TreatmentProtocolRepository;

@CrossOrigin
@RestController
public class TreatmentProtocolRestController {
	
	
//	@Autowired
//	TreatmentProtocolRepository treatmentRepo;
	
	
//	@GetMapping("/list-treatments")
//	public List<TreatmentProtocol> getAllTreatments(){
//		return treatmentRepo.findAll();
//	}
//	
//	@GetMapping("/query-treatment-protocol")
//	public TreatmentProtocol getTreatment(@RequestParam(required=true,defaultValue="Common Cold") String diseaseName) {
//		return treatmentRepo.findByDiseaseName(diseaseName);
//	}
//	
//	@GetMapping("/query-treatment-protocol-by-name")
//	public List<TreatmentProtocol> getTreatmentByName(@RequestParam(required=true,defaultValue="Common Cold") String symptomName) {
//			return treatmentRepo.findBySymptomNameStartingWith(symptomName);
//	}
//	
//	@GetMapping("/query-treatment-protocol-contains-name")
//	public List<TreatmentProtocol> getTreatmentContainsName(@RequestParam(required=true,defaultValue="Common Cold") String medicineName) {
//			return treatmentRepo.findByMedicineNameContaining(medicineName);
//	}
//	
//	@GetMapping("/list-treatment-protocol/{id}")
//	public Optional<TreatmentProtocol> gettreatmentById(@PathVariable("id") Integer id) {
//		return treatmentRepo.findById(id);
//	}
//
//	@PostMapping("/new-treatment-protocol")
//	public TreatmentProtocol createNewtreatment(@RequestParam TreatmentProtocol TreatmentProtocol) {
//		return treatmentRepo.save(TreatmentProtocol);
//	}
//	
//	@PutMapping("/update-treatment-protocol")
//	public TreatmentProtocol updateExistingtreatment(@RequestParam TreatmentProtocol TreatmentProtocol) {
//		return treatmentRepo.save(TreatmentProtocol);
//	}
//	
//	@DeleteMapping("/remove-treatment-protocol/{id}")
//	public Optional<TreatmentProtocol> deleteExistingtreatment(@PathVariable("id") Integer id) {
//		Optional<TreatmentProtocol> TreatmentProtocol=treatmentRepo.findById(id);
//		treatmentRepo.deleteById(id);
//		return TreatmentProtocol;
//	}
//	
//	@GetMapping("/get-treatment-protocol")
//	public List<TreatmentProtocol> getTreatmentProtocol(@RequestParam("symptomName") String symptomName){
//		return treatmentRepo.find(symptomName);
//		
//	}
	
}
