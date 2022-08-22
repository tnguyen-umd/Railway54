-- CREATE DATABASE SalaryManagement;
DROP DATABASE IF EXISTS SalaryManagement;
CREATE DATABASE IF NOT EXISTS SalaryManagement;
USE SalaryManagement;

DROP TABLE IF EXISTS roles;
create table roles (
	id INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50),
	created_at DATE,
	updated_at DATE
);
insert into roles ( `name`, created_at, updated_at) values ('Giam doc', '2022-06-19', '2022-07-27');
insert into roles ( `name`, created_at, updated_at) values ( 'Truong phong Worker', '2022-03-12', '2022-01-25');
insert into roles ( `name`, created_at, updated_at) values ( 'Pho phong', '2022-01-25', '2022-01-01');
insert into roles ( `name`, created_at, updated_at) values ( 'Nhan vien', '2022-04-15', '2022-05-29');
insert into roles ( `name`, created_at, updated_at) values ( 'CTV', '2022-07-08', '2021-12-18');

DROP TABLE IF EXISTS departments;
create table departments (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	`name` text,
	`description` VARCHAR(50),
	created_at DATE,
	updated_at DATE
);
insert into departments ( `name`, `description`, created_at, updated_at) values ( 'Engineering', 'Sales', '2021-10-10', '2021-12-20');
insert into departments ( `name`, `description`, created_at, updated_at) values ( 'Marketing', 'Services', '2021-09-04', '2022-04-27');
insert into departments ( `name`, `description`, created_at, updated_at) values ( 'Sales', 'Training', '2022-04-02', '2022-06-12');
insert into departments ( `name`, `description`, created_at, updated_at) values ( 'Legal', 'Training', '2021-11-19', '2022-03-08');

DROP TABLE IF EXISTS salary_detail_type;
create table salary_detail_type (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	`name` nvarchar(50),
	created_at DATE,
	updated_at DATE
);
insert into salary_detail_type ( `name`,  created_at, updated_at) values ( 'Luong cung', '2021-10-10', '2021-12-20');
insert into salary_detail_type ( `name`,  created_at, updated_at) values ( 'Phu cap', '2021-09-04', '2022-04-27');
insert into salary_detail_type ( `name`,  created_at, updated_at) values ( 'Thuong', '2022-04-02', '2022-06-12');
insert into salary_detail_type ( `name`,  created_at, updated_at) values ( 'Thue TNCN', '2021-11-19', '2022-03-08');
insert into salary_detail_type ( `name`,  created_at, updated_at) values ( 'BHXH', '2021-11-19', '2022-03-08');

create table users (
	id INT PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email VARCHAR(100),
	phone VARCHAR(20),
	employee_id VARCHAR(20),
	avatar VARCHAR(50),
	department_id INT(10),
	gender VARCHAR(10),
	age INT(3),
	created_at DATE,
	updated_at DATE,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (1, 'Raeann', 'Duer', 'rduer0@deviantart.com', '377-845-0627', '1', '', 1, 'Female', 89, '2022-01-10', '2021-09-12');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (2, 'Kathryn', 'Pulsford', 'kpulsford1@aol.com', '866-650-4421', '2', '', 2, 'Female', 59, '2022-01-14', '2022-06-17');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (3, 'Eduardo', 'Dodsworth', 'edodsworth2@soup.io', '588-259-8876', '3', '', 3, 'Male', 90, '2021-09-21', '2022-07-20');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (4, 'Ciel', 'Weber', 'cweber3@bloglovin.com', '619-471-7767', '4', '', 4, 'Female', 48, '2022-05-02', '2022-05-11');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (5, 'Stesha', 'Baunton', 'sbaunton4@state.tx.us', '768-391-6295', '5', '', 1, 'Bigender', 98, '2022-08-11', '2022-04-25');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (6, 'Catina', 'Cutts', 'ccutts5@t.co', '412-109-0374', '6', '', 2, 'Female', 90, '2021-12-31', '2022-02-27');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (7, 'Gualterio', 'Leyre', 'gleyre6@ow.ly', '683-520-0330', '7', '', 3, 'Male', 62, '2021-10-01', '2022-02-28');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (8, 'Giorgi', 'Fattorini', 'gfattorini7@dot.gov', '262-460-5863', '8', '', 4, 'Male', 62, '2021-10-11', '2022-04-06');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (9, 'Nelli', 'Blackhurst', 'nblackhurst8@over-blog.com', '375-618-1469', '9', '', 1, 'Female', 54, '2022-05-12', '2021-11-07');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (10, 'Bernice', 'Collie', 'bcollie9@bbb.org', '507-979-0628', '10', '', 2, 'Female', 23, '2022-08-10', '2021-09-30');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (11, 'Mufi', 'Nizard', 'mnizarda@bizjournals.com', '578-828-8460', '11', '', 3, 'Female', 59, '2022-08-14', '2021-12-18');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (12, 'Giacomo', 'Acheson', 'gachesonb@163.com', '370-622-3664', '12', '', 4, 'Male', 84, '2021-08-24', '2021-12-16');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (13, 'Sena', 'Strugnell', 'sstrugnellc@pinterest.com', '663-367-9431', '13', '', 1, 'Female', 77, '2022-02-05', '2021-12-13');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (14, 'Darb', 'Wortman', 'dwortmand@house.gov', '457-991-8585', '14', '', 2, 'Female', 28, '2022-06-05', '2021-11-23');
insert into users (id, first_name, last_name, email, phone, employee_id, avatar, department_id, gender, age, created_at, updated_at) values (15, 'Beatrice', 'Brotherhead', 'bbrotherheade@freewebs.com', '517-838-3140', '15', '', 3, 'Female', 7, '2021-10-30', '2022-06-19');

