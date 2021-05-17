package com.ozeeesoftware.springmvc.controller;

import com.ozeeesoftware.springmvc.model.Student;
import com.ozeeesoftware.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model){

        model.addAttribute("students",studentService.getAllStudents());

        return "students";

    }

    @GetMapping("/add")
    public String createStudentForm(Model model){

        Student student=new Student();
        model.addAttribute("student",student);
        return "createStudent";

    }

    @PostMapping()
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/api/v1/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.deleteStudentById(id));
        return "updateStudent";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model){

        studentService.updateStudent(student);

        return "redirect:/api/v1/students";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);

        return "redirect:/api/v1/students";
    }

}
