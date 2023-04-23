package com.herdal.hospitalmanagementsystem.entities.concretes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorWithSpecialityDto {
	private int id;
	private String doctorName;
	private String specialityName;
}
