package com.herdal.hospitalmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.herdal.hospitalmanagementsystem.business.abstracts.SpecialityService;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.entities.concretes.Speciality;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/specialities")
public class SpecialitiesController {
	private SpecialityService specialityService;
	
	@GetMapping("/getall")
    public DataResult<List<Speciality>> getAll(
    		@RequestParam int page) {
        return specialityService.getAll(page, 5);
    }
}
