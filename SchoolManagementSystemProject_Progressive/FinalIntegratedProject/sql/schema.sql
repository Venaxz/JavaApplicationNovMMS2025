CREATE TABLE departments (
  department_id VARCHAR(20) PRIMARY KEY,
  department_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE students (
  student_id VARCHAR(30) PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,
  gender VARCHAR(20) NOT NULL,
  date_of_birth DATE NOT NULL,
  email VARCHAR(150),
  phone VARCHAR(40),
  department_id VARCHAR(20),
  level VARCHAR(20) NOT NULL,
  status VARCHAR(20) NOT NULL,
  FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE teachers (
  teacher_id VARCHAR(30) PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,
  email VARCHAR(150),
  department_id VARCHAR(20),
  FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE courses (
  course_id VARCHAR(30) PRIMARY KEY,
  course_name VARCHAR(100) NOT NULL,
  department_id VARCHAR(20),
  FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE results (
  result_id INTEGER PRIMARY KEY,
  student_id VARCHAR(30) NOT NULL,
  course_id VARCHAR(30) NOT NULL,
  score DECIMAL(5,2) NOT NULL CHECK (score BETWEEN 0 AND 100),
  grade VARCHAR(2) NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE payments (
  payment_id INTEGER PRIMARY KEY,
  student_id VARCHAR(30) NOT NULL,
  amount DECIMAL(12,2) NOT NULL CHECK (amount > 0),
  payment_method VARCHAR(20) NOT NULL,
  payment_date DATE NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE attendance (
  attendance_id INTEGER PRIMARY KEY,
  student_id VARCHAR(30) NOT NULL,
  attendance_date DATE NOT NULL,
  present BOOLEAN NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE users (
  username VARCHAR(80) PRIMARY KEY,
  password_hash VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE student_courses (
  student_id VARCHAR(30) NOT NULL,
  course_id VARCHAR(30) NOT NULL,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
