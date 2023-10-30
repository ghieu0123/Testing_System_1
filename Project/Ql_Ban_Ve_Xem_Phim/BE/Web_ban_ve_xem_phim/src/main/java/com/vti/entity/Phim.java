package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`Phim`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phim implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "phim_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phimId;

	@Column(name = "ten_phim", length = 100, nullable = false, unique = true)
	private String tenPhim;

	@Column(name = "dao_dien", length = 50, nullable = false)
    private String daoDien;
	
	@Column(name = "dien_vien", length = 200, nullable = false)
	private String dienVien;

	@Column(name = "the_loai", length = 100, nullable = false)
	private String theLoai;

	@Column(name = "thoi_luong", length = 30, nullable = false)
	private String thoiLuong;

	@Column(name = "tom_tat", length = 200, nullable = false)
	private String tomTat;
	
	@Column(name = "gia_ve", nullable = false)
	private Integer giaVe;
	
	@Column(name = "ngay_khoi_chieu", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date ngayKhoiChieu;
	
	@Column(name = "poster")
	private String poster;
	
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User user;
}
