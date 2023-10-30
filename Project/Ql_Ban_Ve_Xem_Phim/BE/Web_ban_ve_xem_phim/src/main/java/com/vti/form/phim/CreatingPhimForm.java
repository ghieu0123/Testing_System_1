package com.vti.form.phim;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.User;
import com.vti.validation.phim.PhimNameNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingPhimForm {

	@NotBlank(message = "{Phim.createPhim.form.name.NotBlank}")
	@Length(max = 30, message = "{Phim.createPhim.form.name.Length}")
	@PhimNameNotExists(message = "{Phim.createPhim.form.name.NotExists}")
	private String tenPhim;

	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(min=6, max=50, message = "{Phim.createPhim.form.daoDien.Length}")
	private String daoDien;
	
	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(max=200, message = "{Phim.createPhim.form.daoDien.Length}")
	private String dienVien;
	
	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(max=100, message = "{Phim.createPhim.form.daoDien.Length}")
	private String theLoai;
	
	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(max=30, message = "{Phim.createPhim.form.daoDien.Length}")
	private String thoiLuong;
	
	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(max=200, message = "{Phim.createPhim.form.daoDien.Length}")
	private String tomTat;
	
	@NotNull(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	private Date ngayKhoiChieu;
	
	@NotBlank(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	@Length(max=800, message = "{Phim.createPhim.form.daoDien.Length}")
	private String poster;
	
	@NotNull(message = "{Phim.createPhim.form.daoDien.NotBlank}")
	private Integer giaVe;
	
	private int userId;
	
}
