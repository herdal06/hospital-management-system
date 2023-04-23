package com.herdal.hospitalmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herdal.hospitalmanagementsystem.entities.concretes.Speciality;

public interface SpecialityDao extends JpaRepository<Speciality, Integer> {

}
