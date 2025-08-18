package com.example.The.Book.Sphere.Service;

import com.example.The.Book.Sphere.Entity.Student;

import java.util.List;

public interface StudentService {
    public String addStudent(Student student);
    public void deleteStudentById(Integer id);

    public void updateStudentInfoById(Integer id, Student updatedStudent);

    public Student getStudentById(Integer id);

    public List<Student> getAllStudent();
}
