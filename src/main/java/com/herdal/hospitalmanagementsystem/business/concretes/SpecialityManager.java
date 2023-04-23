package com.herdal.hospitalmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.herdal.hospitalmanagementsystem.business.abstracts.SpecialityService;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.SuccessDataResult;
import com.herdal.hospitalmanagementsystem.dataAccess.abstracts.SpecialityDao;
import com.herdal.hospitalmanagementsystem.entities.concretes.Speciality;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpecialityManager implements SpecialityService {
	private SpecialityDao specialityDao;

	@Override
	public DataResult<List<Speciality>> getAll(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return new SuccessDataResult<List<Speciality>>
		(specialityDao.findAll(pageable).getContent(), "Specialities listed");
	}
}
