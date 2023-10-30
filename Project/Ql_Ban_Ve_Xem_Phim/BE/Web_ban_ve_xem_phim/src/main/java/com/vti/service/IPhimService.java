package com.vti.service;

import java.util.List;

import com.vti.entity.Phim;
import com.vti.form.phim.CreatingPhimForm;

public interface IPhimService {
	public List<Phim> getListPhims();

	public Phim getPhimByID(int id);

	public void createPhim(int authenUserId, CreatingPhimForm form);

	public boolean isPhimExistsByName(String tenPhim);

	public boolean isPhimExistsByID(Integer id);
}
