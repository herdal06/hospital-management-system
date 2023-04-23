package com.herdal.hospitalmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herdal.hospitalmanagementsystem.entities.concretes.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer> {
	boolean existsByNationalityId(String nationalityId);
}