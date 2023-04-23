package com.herdal.hospitalmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.herdal.hospitalmanagementsystem.business.abstracts.DoctorService;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.entities.concretes.Doctor;
import com.herdal.hospitalmanagementsystem.entities.concretes.dto.DoctorWithSpecialityDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
private DoctorService doctorService;

	/*
	 * Get all doctors with pagination and speciality
	 */
	@GetMapping("/getall")
	public DataResult<List<Doctor>> getAll(
			@RequestParam int page, 
			@RequestParam int size) {
		return doctorService.getAllBySpeciality(page, size);
	}
	
	/*
	 * List doctors with speciality
	 */
	@GetMapping("/getDoctorsWithSpeciality")
	DataResult<List<DoctorWithSpecialityDto>> getDoctorsWithSpeciality(
			@RequestParam int page, 
			@RequestParam int size) {
		return doctorService.getDoctorsWithSpeciality(page, size);
	}
	
	/*
	 * Get doctor details with speciality
	 */
	@GetMapping("/{id}")
    public DataResult<DoctorWithSpecialityDto> getById(@PathVariable int id) {
        return doctorService.getById(id);
    }
	
	/*
	 * List doctors by speciality id
	 */
	@GetMapping("/speciality/{id}")
    public DataResult<List<Doctor>> getBySpeciality(
    		@PathVariable int id,
    		@RequestParam int page, 
			@RequestParam int size
    		) {
        return doctorService.getDoctorsBySpeciality(page, size, id);
    }
}
