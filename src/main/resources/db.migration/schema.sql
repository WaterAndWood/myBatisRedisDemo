-- CREATE DATABASE city_student;

DROP TABLE IF EXISTS db_student;
CREATE TABLE db_student (
id varchar (32) NOT NULL,
student_name varchar (32) DEFAULT NULL,
age int (11) DEFAULT NULL,
sex varchar (8) DEFAULT NULL,
city_name varchar (32) DEFAULT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS db_city;
create table db_city (
id varchar (32) NOT NULL,
city_name varchar (32) NOT NULL,
province_name VARCHAR (32) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;