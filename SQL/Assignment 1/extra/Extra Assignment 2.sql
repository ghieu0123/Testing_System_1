DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE IF NOT EXISTS Fresher;

USE Fresher;

CREATE TABLE Trainee (
	TraineeID			TINYINT AUTO_INCREMENT PRIMARY KEY,
    Full_Name 			VARCHAR(255) NOT NULL,
    Birth_Date			DATE NOT NULL,
    Gender				ENUM ('male', 'female', 'unknown') NOT NULL,
    ET_IQ				INT CHECK(0 <= ET_IQ <= 20) NOT NULL,
    ET_Gmath			INT CHECK(0 <= ET_Gmath <= 20) NOT NULL,
    ET_English			INT CHECK(0 <= ET_English <= 50)  NOT NULL,
    Training_Class		INT NOT NULL,
    Evaluation_Notes	VARCHAR(255)
);

ALTER TABLE Trainee
ADD COLUMN VTI_Acount INT NOT NULL UNIQUE KEY;

DROP DATABASE IF EXISTS Department;
CREATE DATABASE IF NOT EXISTS Department;

CREATE TABLE Sale (
	ID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(50),
    `Code`			CHAR(5),
    ModifiedDate	DATETIME NOT NULL
);

DROP DATABASE IF EXISTS cty;
CREATE DATABASE IF NOT EXISTS cty;

CREATE TABLE Marketing (
	ID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(50) NOT NULL,
    BirthDate		DATETIME NOT NULL,
    Gender			ENUM('0', '1', 'NULL'), -- 0 là Male, 1 là Female, Unknown là NULL0
    IsDeletedFlag	BIT NOT NULL -- 0 là đang hoặt động, 1 là xóa
);
