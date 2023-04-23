package com.herdal.hospitalmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.herdal.hospitalmanagementsystem.business.abstracts.DoctorService;
import com.herdal.hospitalmanagementsystem.core.utilities.mappers.ModelMapperService;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.SuccessDataResult;
import com.herdal.hospitalmanagementsystem.dataAccess.abstracts.DoctorDao;
import com.herdal.hospitalmanagementsystem.entities.concretes.Doctor;
import com.herdal.hospitalmanagementsystem.entities.concretes.dto.DoctorWithSpecialityDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorManager implements DoctorService {
	private DoctorDao doctorDao;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<Doctor>> getAllBySpeciality(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return new SuccessDataResult<List<Doctor>>
		(doctorDao.findAll(pageable).getContent(),"Doctors listed");
	}

	@Override
	public DataResult<List<DoctorWithSpecialityDto>> getDoctorsWithSpeciality(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return new SuccessDataResult<List<DoctorWithSpecialityDto>>
		(doctorDao.getDoctorsWithSpeciality(pageable),"Doctors listed!");
	}

	@Override
	public DataResult<DoctorWithSpecialityDto> getById(int id) {
		Doctor doctor = doctorDao.findById(id).orElseThrow();
		DoctorWithSpecialityDto response = this.modelMapperService.forResponse()
				.map(doctor, DoctorWithSpecialityDto.class);
		return new SuccessDataResult<DoctorWithSpecialityDto>
		(response, "Doctor listed!");
	}

	@Override
	public DataResult<List<Doctor>> getDoctorsBySpeciality(int page, int size, int specialityId) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return new SuccessDataResult<List<Doctor>>
		(doctorDao.getBySpeciality_SpecialityId(pageable, specialityId),"Doctors listed!");
	}
}
