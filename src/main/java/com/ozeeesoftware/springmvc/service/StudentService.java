package com.ozeeesoftware.springmvc.service;

import com.ozeeesoftware.springmvc.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Student student);

    Student deleteStudentById(Long id);

}
