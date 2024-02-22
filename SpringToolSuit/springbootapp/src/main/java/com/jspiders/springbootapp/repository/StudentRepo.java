package com.jspiders.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.springbootapp.pojo.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	Student findByMobile(long mobile);

	Student findByEmailAndName(String  email, String  name);

}
