package com.mcvn.project.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcvn.project.model.Version;
import com.mcvn.project.repository.VesionRepository;
@Service
public class VerSionServiceImpl implements VerSionService{
	@Resource
	private VesionRepository vesionRepository;
	@Override
	public Version findByVersion(String version) {
		// TODO Auto-generated method stub
		return vesionRepository.findByVersion(version);
	}

}
