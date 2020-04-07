package com.mydoctorapp.data.config;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mydoctorapp.data.bean.CSVFile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Component
public class CSVParser {
	
	private String fileName;
	
	@Autowired
	FileSetter csvFileLocation;
	
	@Bean
	public void parseCSV() throws CsvValidationException {
		fileName=csvFileLocation.getFileName();
		CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Symptoms [Symptoms_Name = " + line[0] + ", Disease_Name = " + line[1] + " , Symptoms Description =" + line[2] +" , Treatment = "+ line[5] +"]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	

}
