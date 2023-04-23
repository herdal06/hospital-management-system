package com.herdal.hospitalmanagementsystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "specialities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","doctors"})
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "speciality_id")
	private int specialityId;
	
	@Column(name = "speciality_name")
	private String specialityName;
	
	@OneToMany(mappedBy = "speciality")
	private List<Doctor> doctors;
}