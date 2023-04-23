package com.herdal.hospitalmanagementsystem.business.abstracts;

import java.util.List;

import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.entities.concretes.Speciality;

public interface SpecialityService {
	DataResult<List<Speciality>> getAll(int page, int size);
}
