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
import com.mydoctorapp.data.bean.Medicine;
import com.mydoctorapp.data.bean.Symptom;
import com.mydoctorapp.data.repository.MedicineRepository;

@CrossOrigin
@RestController
public class MedicineRestController {
	
	
	@Autowired
	MedicineRepository medicineRepo;
	
	
	@GetMapping("/list-medicines")
	public List<Medicine> getAllmedicines(){
		return medicineRepo.findAll();
	}
	
	@GetMapping("/query-medicine")
	public Medicine getMedicine(@RequestParam(required=true,defaultValue="Dolo-650") String medicineName) {
		return medicineRepo.findByMedicineName(medicineName);
	}
	
	@GetMapping("/query-medicine-by-name")
	public List<Medicine> getMedicineByName(@RequestParam(required=true,defaultValue="Dolo-650") String medicineName) {
		return medicineRepo.findByMedicineNameStartingWith(medicineName);
	}
	
	@GetMapping("/query-medicine-contains-name")
	public List<Medicine> getMedicineContainsName(@RequestParam(required=true,defaultValue="Dolo-650") String medicineName) {
			return medicineRepo.findByMedicineNameContaining(medicineName);

	}		
			
	@GetMapping("/list-medicine/{id}")
	public Optional<Medicine> getmedicineById(@PathVariable("id") Integer id) {
		return medicineRepo.findById(id);
	}

	@PostMapping("/new-medicine")
	public Medicine createNewmedicine(@RequestParam Medicine medicine) {
		return medicineRepo.save(medicine);
	}
	
	@PutMapping("/update-medicine")
	public Medicine updateExistingmedicine(@RequestParam Medicine medicine) {
		return medicineRepo.save(medicine);
	}
	
	@DeleteMapping("/remove-medicine/{id}")
	public Optional<Medicine> deleteExistingmedicine(@PathVariable("id") Integer id) {
		Optional<Medicine> medicine=medicineRepo.findById(id);
		medicineRepo.deleteById(id);
		return medicine;
	}
	
	@GetMapping("/list-medicine-by-symptom")
	public List<Medicine> getMedicineForSymptom(@RequestParam String symptomName){
		return medicineRepo.findBySymptomNameContaining(symptomName);
	}
	
	
	@GetMapping("/list-medicine-by-disease")
	public List<Medicine> getMedicineForDisease(@RequestParam String diseaseName){
		return medicineRepo.findDistinctByDiseaseNameContaining(diseaseName);
	}
}
