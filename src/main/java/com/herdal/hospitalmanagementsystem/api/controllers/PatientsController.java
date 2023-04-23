package com.herdal.hospitalmanagementsystem.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.herdal.hospitalmanagementsystem.business.abstracts.PatientService;
import com.herdal.hospitalmanagementsystem.core.utilities.results.DataResult;
import com.herdal.hospitalmanagementsystem.core.utilities.results.ErrorDataResult;
import com.herdal.hospitalmanagementsystem.entities.concretes.Patient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientsController {
	private PatientService patientService;

	/*
	 * Get patient details by id
	 */
	@GetMapping("/{id}")
    public DataResult<Patient> getById(@PathVariable int id) {
        return patientService.getById(id);
    }
	
	/*
	 * update patient
	 */

    @PutMapping
    public void update(@RequestBody() Patient patient) {
    	this.patientService.update(patient);
    }
	
	/*
	 * add patient
	 */
    @ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody Patient patient) {
		return ResponseEntity.ok(this.patientService.add(patient)) ;
	}
	
	/*
	 * for catching validation exceptions
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
