package com.herdal.hospitalmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","appointments"})
@Entity(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int id;
	
	@Column(name = "nationality_id")
	@NotBlank
	@NotNull
	private String nationalityId;
	
	@Column(name = "email")
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@Column(name = "patient_name")
	@NotBlank
	@NotNull
	private String name;
	
	//   , , doğum tarihi(gün ay yıl)
	
	/*@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;*/
}
