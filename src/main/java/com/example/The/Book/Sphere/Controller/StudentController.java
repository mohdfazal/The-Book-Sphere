package com.example.The.Book.Sphere.Controller;

import com.example.The.Book.Sphere.Entity.Student;
import com.example.The.Book.Sphere.Service.Implementation.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImp studentServiceImp;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

        return studentServiceImp.addStudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam Integer id){
        studentServiceImp.deleteStudentById(id);
        return "Student with ID " + id + " deleted successfully!";
    }

    @PutMapping("/update")
    public String updateStudentInfoById(@RequestParam Integer id, @RequestBody Student updatedStudent){
        studentServiceImp.updateStudentInfoById(id, updatedStudent);
        return "Student with ID " + id + " updated successfully!";
    }

    @GetMapping("/get")
    public Student getStudentById(@RequestParam Integer id){
        return studentServiceImp.getStudentById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentServiceImp.getAllStudent();
    }
}
