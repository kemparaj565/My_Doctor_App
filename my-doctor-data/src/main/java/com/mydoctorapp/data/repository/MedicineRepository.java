package com.mydoctorapp.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydoctorapp.data.bean.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

	Medicine findByMedicineName(String medicineName);

	List<Medicine> findByMedicineNameStartingWith(String medicineName);

	List<Medicine> findByMedicineNameContaining(String medicineName);

}
