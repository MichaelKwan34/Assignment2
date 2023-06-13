package com.cmpt276.assignment2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmpt276.assignment2.models.Student;
import com.cmpt276.assignment2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/student/list")
    public String getAllStudents(Model model) {
        // System.out.println("Getting all students:");
        List<Student> students = studentRepo.findAll();
        model.addAttribute("stu", students);
        return "/student/showAll";
    }


    @PostMapping("/student/add")
    public String addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response) {
        String newName = newStudent.get("name");
        String newHairColor = newStudent.get("hairColor");
        int newHeight = Integer.parseInt(newStudent.get("height"));
        int newWeight = Integer.parseInt(newStudent.get("weight"));
        double newGpa = Double.parseDouble(newStudent.get("gpa"));
        studentRepo.save(new Student(newName, newHeight, newWeight, newHairColor, newGpa));
        response.setStatus(201);
        return "/student/addedStudent";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(Model model, @PathVariable String id,HttpServletResponse response) {
        System.out.println("Getting student id: " + id);
        Student student = studentRepo.findById(Integer.parseInt(id)).get();
        model.addAttribute("stu", student);
        response.setStatus(201);
        return "/student/updateStudent";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable String id, @RequestParam Map<String,String> after) {
        String newName = after.get("name");
        String newHairColor = after.get("hairColor");
        int newHeight = Integer.parseInt(after.get("height"));
        int newWeight = Integer.parseInt(after.get("weight"));
        double newGpa = Double.parseDouble(after.get("gpa"));
        Student updatedStudent = new Student(newName, newHeight, newWeight,
        newHairColor, newGpa);
        updatedStudent.SetId(Integer.parseInt(id));
        studentRepo.save(updatedStudent);
        return "redirect:/student/list";
    }
    @PostMapping("/student/delete/{id}") 
    public String deleteStudent(@PathVariable String id) {
        studentRepo.deleteById(Integer.parseInt(id));
        return "redirect:/student/list";
    }

    @GetMapping("/displayStudent")
    public String displayStudent(Model model) {
        System.out.println("Getting students' data:");
        List<Student> students = studentRepo.findAll();
        model.addAttribute("stu", students);
        return "/student/displayStudent";
    }


}
