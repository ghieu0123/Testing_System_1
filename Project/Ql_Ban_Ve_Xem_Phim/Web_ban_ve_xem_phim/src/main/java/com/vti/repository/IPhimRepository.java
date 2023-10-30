package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.vti.entity.Phim;

public interface IPhimRepository extends JpaRepository<Phim, Integer>, JpaSpecificationExecutor<Phim> {

	boolean existsByTenPhim(String tenPhim);
	
	Phim findByTenPhim(String tenPhim);
	
	@Query("FROM Phim ORDER BY tenPhim")
	List<Phim> getListPhim();
}