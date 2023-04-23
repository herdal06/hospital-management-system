package com.herdal.hospitalmanagementsystem.business.rules;

import org.springframework.stereotype.Service;

import com.herdal.hospitalmanagementsystem.core.utilities.exceptions.BusinessException;
import com.herdal.hospitalmanagementsystem.dataAccess.abstracts.PatientDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientBusinessRules {
private PatientDao patientDao;
	
	public void checkIfNationalityIdExists(String nationalityId) {
		if(this.patientDao.existsByNationalityId(nationalityId)) {
			throw new BusinessException("Patient already exists!"); // Java exception types
		}
	}
}
