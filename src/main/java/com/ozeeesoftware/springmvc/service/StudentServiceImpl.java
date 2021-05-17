package com.ozeeesoftware.springmvc.service;

import com.ozeeesoftware.springmvc.model.Student;
import com.ozeeesoftware.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {

        Student existingStudent=studentRepository.findById(student.getId()).orElseThrow(null);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setStudentId(student.getStudentId());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student existingStudent=studentRepository.findById(id).orElseThrow(null);
        studentRepository.delete(existingStudent);

        return existingStudent;
    }
}
