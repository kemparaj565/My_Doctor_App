package com.mydoctorapp.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydoctorapp.data.config.CSVParser;
import com.mydoctorapp.data.repository.MedicineRepository;
import com.opencsv.exceptions.CsvValidationException;


@RestController
public class MedicineRepositoryImpl{

	@Autowired
	MedicineRepository medicineRepo;
	
	@Autowired
	CSVParser parser;
	
	@GetMapping("/home")
	public String parseCSV() throws CsvValidationException {
		
		parser.parseCSV();
		
		return "CSV Parsing Completed";
	}
	
	
}
