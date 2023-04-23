package com.herdal.hospitalmanagementsystem.business.abstracts;

import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.Result;
import com.herdal.hospitalmanagementsystem.entities.concretes.Patient;

public interface PatientService {
	DataResult<Patient> getById(int id);
	Result add(Patient patient);
	Result update(Patient patient);
}
