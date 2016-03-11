package com.mcvn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcvn.project.model.Version;



public interface VesionRepository extends JpaRepository<Version, Integer>{
	
	Version findByVersion(String version);
}
