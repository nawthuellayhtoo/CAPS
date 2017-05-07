CREATE SCHEMA `caps` ;

CREATE TABLE `caps`.`login` (
  `loginid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`loginid`));
  
  CREATE TABLE `caps`.`student` (
  `studentid` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `gpa` DECIMAL(10,2) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`studentid`));

CREATE TABLE `caps`.`lecturer` (
  `lecturerid` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  PRIMARY KEY (`lecturerid`));

CREATE TABLE `caps`.`course` (
  `courseid` VARCHAR(45) NOT NULL,
  `coursename` VARCHAR(45) NULL,
  `size` INT NULL,
  `lecturerid` VARCHAR(45) NULL,
  `credit` DECIMAL NULL,
  `startdate` DATE NULL,
  PRIMARY KEY (`courseid`),
  INDEX `lecturerid_idx` (`lecturerid` ASC),
  CONSTRAINT `lecturerid`
    FOREIGN KEY (`lecturerid`)
    REFERENCES `caps`.`lecturer` (`lecturerid`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);

CREATE TABLE `caps`.`enrolment` (
  `enrolmentid` INT NOT NULL AUTO_INCREMENT,
  `studentid` VARCHAR(45) NULL,
  `courseid` VARCHAR(45) NULL,
  `enrolmentdate` DATE NULL,
  `grade` DECIMAL NULL,
  PRIMARY KEY (`enrolmentid`),
  INDEX `courseid_idx` (`courseid` ASC),
  INDEX `studentid_idx` (`studentid` ASC),
  CONSTRAINT `courseid`
    FOREIGN KEY (`courseid`)
    REFERENCES `caps`.`course` (`courseid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `studentid`
    FOREIGN KEY (`studentid`)
    REFERENCES `caps`.`student` (`studentid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

use caps;

INSERT INTO login (loginid, password, role)
VALUES ('A001','P@ssw0rd','administrator');

INSERT INTO login (loginid, password, role)
VALUES ('L001','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L002','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L003','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L004','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L005','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L006','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L007','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L008','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L009','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('L010','password','lecturer');

INSERT INTO login (loginid, password, role)
VALUES ('S001','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S002','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S003','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S004','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S005','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S006','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S007','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S008','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S009','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S010','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S011','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S012','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S013','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S014','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S015','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S016','password','student');

INSERT INTO login (loginid, password, role)
VALUES ('S017','password','student');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S001','John','Doe','2','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S002','Peter','Tan','3','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S003','Sally','Ong','4','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S004','Michael','Lee','5','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S005','Joe','Biden','1','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S006','Barack','Obama','2','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S007','Indiana','Jones','3','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S008','Luke','Skywalker','4','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S009','Donald','Trump','5','sa43team2@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S010','Aditi','Roy','1','aditiroy.sg@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S011','Thu Hein','Aung','2','agthuhein1991@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S012','Wei','Cao','3','caowei0127@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S013','Kar Jun','Chan','4','karjun.chan@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S014','Zhi Yang','Lim','5','limzhiyang@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S015','Thuey Llay Htoo','Naw','1','nawthuellayhtoo@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S016','Manisha','Patil','2','manisha25286@gmail.com');

INSERT INTO student (studentid, firstname, lastname, gpa, email)
VALUES ('S017','Su Heng','Ren','3','rensuheng@gmail.com');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L001','Yuen Kwan','Chia');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L002','Zhi Min','Choo');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L003','Derek','Kiong');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L004','Esther','Tan');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L005','Felicitas','Seah');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L006','Boon Kui','Heng');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L007','Boon Kee','Lee');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L008','Suriya','Asaithambi');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L009','Venkat','Ramanathan');

INSERT INTO lecturer (lecturerid, firstname, lastname)
VALUES ('L010','Yunghans','Irawan');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C001','Accounting','40','L001','2','2016-12-29');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C002','Economics','50','L002','1','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C003','Social Studies','40','L003','2','2017-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C004','History','50','L004','1','2016-12-15');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C005','Mathematics','40','L005','2','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C006','Literature','50','L001','1','2016-10-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C007','Geography','60','L002','2','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C008','Japanese','30','L003','1','2017-01-10');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C009','Korean','40','L004','2','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C010','Spanish','40','L006','1','2016-12-27');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C011','French','40','L007','2','2016-06-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C012','Bahasa Melayu','40','L008','1','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C013','Italian','40','L009','2','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C014','English','40','L010','1','2016-01-01');

INSERT INTO course (courseid, coursename, size, lecturerid, credit, startdate)
VALUES ('C015','Programming','40','L010','2','2017-01-15');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S001','C001','2016-01-01','1');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S002','C001','2016-01-01','2');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S003','C001','2016-01-01','3');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S004','C002','2016-01-01','4');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S005','C002','2016-01-01','5');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S006','C002','2016-01-01','1');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S007','C003','2016-01-01','2');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S008','C003','2016-01-01','3');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S009','C003','2016-01-01','4');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S010','C004','2016-01-01','5');

INSERT INTO enrolment (enrolmentid, studentid, courseid, enrolmentdate, grade)
VALUES (NULL,'S011','C004','2016-01-01','1');