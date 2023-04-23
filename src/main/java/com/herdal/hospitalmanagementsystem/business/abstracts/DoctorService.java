package com.herdal.hospitalmanagementsystem.business.abstracts;

import java.util.List;

import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.entities.concretes.Doctor;
import com.herdal.hospitalmanagementsystem.entities.concretes.dto.DoctorWithSpecialityDto;

public interface DoctorService {
	DataResult<List<Doctor>> getAllBySpeciality(int page, int size);
	DataResult<List<DoctorWithSpecialityDto>> getDoctorsWithSpeciality(int page, int size);
	DataResult<DoctorWithSpecialityDto> getById(int id);
	DataResult<List<Doctor>> getDoctorsBySpeciality(int page, int size, int specialityId);
}
