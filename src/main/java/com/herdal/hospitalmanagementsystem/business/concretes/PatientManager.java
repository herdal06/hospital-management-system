package com.herdal.hospitalmanagementsystem.business.concretes;

import org.springframework.stereotype.Service;

import com.herdal.hospitalmanagementsystem.business.abstracts.PatientService;
import com.herdal.hospitalmanagementsystem.business.rules.PatientBusinessRules;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.Result;
import com.herdal.hospitalmanagementsystem.core.utilities.results.SuccessDataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.SuccessResult;
import com.herdal.hospitalmanagementsystem.dataAccess.abstracts.PatientDao;
import com.herdal.hospitalmanagementsystem.entities.concretes.Patient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientManager implements PatientService {
	private PatientDao patientDao;
	private PatientBusinessRules patientBusinessRules;
	
	@Override
	public DataResult<Patient> getById(int id) {
		return new SuccessDataResult<Patient>
		(patientDao.findById(id).orElseThrow(), "Patient listed!");
	}

	@Override
	public Result add(Patient patient) {
		this.patientBusinessRules.checkIfNationalityIdExists(patient.getNationalityId()); // business logic
		patientDao.save(patient);
		return new SuccessResult("Patient added!");	
	}

	@Override
	public Result update(Patient patient) {
		patientDao.save(patient);
		return new SuccessResult("Patient updated!");	
	}
}
