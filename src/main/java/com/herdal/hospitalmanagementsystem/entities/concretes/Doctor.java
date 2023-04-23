package com.herdal.hospitalmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "doctors")
public class Doctor {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int id;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@ManyToOne()
	@JoinColumn(name = "speciality_id")
	private Speciality speciality;
	
	/*@OneToOne(mappedBy = "doctor")
    private Appointment appointment;*/
}
