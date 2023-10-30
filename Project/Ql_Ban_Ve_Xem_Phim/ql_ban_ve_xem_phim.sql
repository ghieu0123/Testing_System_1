DROP DATABASE IF EXISTS QL_Ban_Ve_Xem_phim;

CREATE DATABASE IF NOT EXISTS QL_Ban_Ve_Xem_phim;

USE QL_Ban_Ve_Xem_phim;

DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
	`user_id`		INT AUTO_INCREMENT PRIMARY KEY,
    `username`	 	VARCHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
    `email`			VARCHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
    `password` 		VARCHAR(800) NOT NULL,
    `firstName` 	NVARCHAR(50) NOT NULL,
	`lastName` 		NVARCHAR(50) NOT NULL,
    `role` 			ENUM('Admin','Manager','User') DEFAULT 'User',
    `status`		TINYINT DEFAULT 0 -- 0: Not Active, 1: Active
);

DROP TABLE IF EXISTS `Phim`;
CREATE TABLE IF NOT EXISTS `Phim`(
	phim_id			INT AUTO_INCREMENT PRIMARY KEY,
    ten_phim		VARCHAR(100) NOT NULL UNIQUE KEY,
    dao_dien		VARCHAR(50) NOT NULL CHECK (LENGTH(dao_dien) >= 6 AND LENGTH(dao_dien) <= 50),
    dien_vien		VARCHAR(200) NOT NULL,
    the_loai		VARCHAR(100) NOT NULL,
    thoi_luong		VARCHAR(30) NOT NULL,
    tom_tat			TEXT NOT NULL,
    ngay_khoi_chieu DATETIME NOT NULL,
    gia_ve			INT NOT NULL,
    poster			TEXT NOT NULL,
    creator_id 		INT,
    FOREIGN KEY (creator_id) REFERENCES `User`(`user_id`)
);

DROP TABLE IF EXISTS `Lich_Chieu_Phim`;
CREATE TABLE IF NOT EXISTS `Lich_Chieu_Phim`(
	lich_chieu_id		INT AUTO_INCREMENT PRIMARY KEY,
    phim_id				INT,
    so_luong_ghe		INT CHECK (so_luong_ghe >= 50 AND so_luong_ghe <= 100),
    ngay_chieu			DATETIME NOT NULL,
    FOREIGN KEY (phim_id) REFERENCES `Phim`(phim_id)
);

DROP TABLE IF EXISTS `Ve_Dat`;
CREATE TABLE IF NOT EXISTS `Ve_Dat`(
	creator_id				INT,
    lich_chieu_id			INT,
    so_luong				INT NOT NULL,
    tong_tien				INT NOT NULL, -- not update
    trang_thai_thanh_toan	TINYINT DEFAULT 0,
    PRIMARY KEY (creator_id, lich_chieu_id),
    FOREIGN KEY (creator_id) REFERENCES `User`(user_id),
    FOREIGN KEY (lich_chieu_id) REFERENCES `Lich_Chieu_Phim`(lich_chieu_id)
);

INSERT INTO `User` (`username`, `email`, `password`, `firstname`, `lastname`, `role`, `status`)
VALUES				('duchao',    'duchao0202@gmail.com', '123456', 'Nguyen', 'Hao', 'Manager',  1),
					('quanghieu', 'quanghieu@gmail.com',  '123456', 'Quang',  'Hieu', 'Manager', 1),
                    ('dinhdai',   'dinhdai@gmail.com',    '123456', 'Dinh',   'Dai', 'Manager',  1),
                    ('hoanggiang', 'hoanggiang@gmail.com', '123456', 'Hoang', 'Giang', 'Manager', 1),
                    ('truongduong', 'truongduong@gmail.com', '123456', 'Truong', 'Duong', 'Manager', 1),
                    ('hongphong', 'hongphong@gmail.com', '123456', 'Hong', 'Phong', 'Manager', 1),
                    ('ngoloi', 'ngoloi@gmail.com', '123456', 'Ngo', 'Loi', 'Manager', 1),
                    ('nguyenvana', 'nguyena@gmail.com', '123456', 'Nguyen', 'A', 'User', 1),
                    ('nguyenvanb', 'nguyenb@gmail.com', '123456', 'Nguyen', 'B', 'User', 1);
                     
INSERT INTO `Phim` (`ten_phim`, `dao_dien`, `dien_vien`, `the_loai`, `thoi_luong`, `tom_tat`, `ngay_khoi_chieu`, `gia_ve`, `poster`, `creator_id`)
VALUES				('Năm đêm kinh hoàng', 'Emma Tammi','Matthew Lillard, Josh Hutcherson, Mary Stuart Masterson', 'Kinh Dị', '110 phút', 'Nhân viên bảo vệ Mike bắt đầu làm việc tại Freddy Fazbear pizza...', '2023/10/27', 70000,'https://files.betacorp.vn/files/media%2fimages%2f2023%2f10%2f03%2f700x1000-5demkinhhoang-115804-031023-17.png' , 1),
					('Kị sĩ bóng đêm', 'Christopher Nolan', 'Christian Bale, Michael Caine, Heath Ledger, Aaron Eckhart', 'Hành động', '152 phút', 'Kị sĩ bóng đêm mở đầu bằng cuộc oanh tạc...', '2023/10/18', 70000,'...', 1),
                    ('Wolfoo và hòn đảo kỳ bí', 'Phan Thị Thơ', 'Sony Minh Hiếu, Đạt Phi, Như Ý', 'Hài, Hoạt Hình', '100 phút', 'Câu chuyện xoay quanh nhân vật chính là chú sói nhỏ ...', '2023/10/13', 70000,'...', 2),
                    ('Vầng trăng máu', 'Martin Scorsese', 'Leonardo DiCaprio, Robert De Niro, Lily Gladstone', 'Bí ẩn, Hồi hộp', '206 phút', 'Vào những năm 1920, các thành viên của khu tự trị Osage...', '2023/10/20', 70000,'...', 3);
                
INSERT INTO `Lich_Chieu_Phim` (`phim_id`, `so_luong_ghe`, `ngay_chieu`)
VALUES							(1, 100, '2023/10/25'),
								(2, 50, '2023/10/26'),
                                (3, 70, '2023/10/27'),
                                (3, 100, '2023/10/28'),
                                (4, 100, '2023/10/29');
                                
INSERT INTO `Ve_Dat` (`creator_id`, `lich_chieu_id`, `so_luong`, `tong_tien`, `trang_thai_thanh_toan`)
VALUES				(8, 1, 2, 140000, 1),
					(8, 2, 1, 70000, 1),
                    (8, 3, 2, 140000, 1),
                    (9, 4, 2, 140000, 1),
                    (9, 5, 1, 70000, 1);