package com.vti.dto;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.vti.entity.Phim;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhimDTO extends RepresentationModel<PhimDTO> {
	private int phimId;
	
	private String tenPhim;

	private String daoDien;
	
	private String dienVien;
	
	private String theLoai;
	
	private String thoiLuong;
	
	private String tomTat;
	
	private Integer giaVe;

	private Date ngayKhoiChieu;
	
	private String poster;

	private int userId;
	
}

