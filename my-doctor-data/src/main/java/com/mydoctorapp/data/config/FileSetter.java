package com.mydoctorapp.data.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("source-csv-file")
public class FileSetter {
	
	private String fileName;

	public FileSetter(String fileName) {
		super();
		this.fileName = fileName;
	}

	public FileSetter() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
