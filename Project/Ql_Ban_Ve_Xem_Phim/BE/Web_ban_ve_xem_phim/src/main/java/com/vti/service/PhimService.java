package com.vti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Phim;
import com.vti.form.phim.CreatingPhimForm;
import com.vti.repository.IPhimRepository;
import com.vti.repository.IUserRepository;

@Service
public class PhimService implements IPhimService {

	@Autowired
	private ModelMapper modelMapper;
	
	private IUserRepository userRepository;
	
	@Autowired
	private IPhimRepository repository;
	
	public List<Phim> getListPhims() {
		return repository.getListPhim();
	}

	public Phim getPhimByID(int id) {
		return repository.findById(id).get();
	}

	@Transactional
	public void createPhim(int authenUserId, CreatingPhimForm form) {
		
		// convert form to entity
		Phim phimEntity = form.toEntity();
		
		phimEntity.getUser().setUserId(authenUserId);
		
		// create department
		repository.save(phimEntity);
	}

	public boolean isPhimExistsByName(String tenPhim) {
		return repository.existsByTenPhim(tenPhim);
	}

	public boolean isPhimExistsByID(Integer phimId) {
		return repository.existsById(phimId);
	}
}
