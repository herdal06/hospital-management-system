package com.herdal.hospitalmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.herdal.hospitalmanagementsystem.entities.concretes.Doctor;
import com.herdal.hospitalmanagementsystem.entities.concretes.dto.DoctorWithSpecialityDto;

public interface DoctorDao extends JpaRepository<Doctor, Integer>{
	@Query("Select new com.herdal.hospitalmanagementsystem.entities.concretes.dto.DoctorWithSpecialityDto(d.id, d.doctorName, s.specialityName) From Speciality s Inner Join s.doctors d")
	List<DoctorWithSpecialityDto> getDoctorsWithSpeciality(Pageable pageable);
	List<Doctor> getBySpeciality_SpecialityId( Pageable pageable, int specialityId);
}