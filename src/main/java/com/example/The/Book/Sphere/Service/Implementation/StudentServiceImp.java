package com.example.The.Book.Sphere.Service.Implementation;

import com.example.The.Book.Sphere.Entity.Card;
import com.example.The.Book.Sphere.Entity.Student;
import com.example.The.Book.Sphere.Enum.CardStatus;
import com.example.The.Book.Sphere.Repository.StudentRepository;
import com.example.The.Book.Sphere.Service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
//    @Override
//    public String addStudent(Student student) {
//
//        //generate a new card for the studnet
//        Card card = new Card();
//        card.setCardStatus(CardStatus.ACTIVE);
//        card.setValidTill(new Date("2030-01-01"));
//        card.setStudent(student);
//        student.setCard(card);
//
//        studentRepository.save(student);
//        return " student added successfully ";
//    }


    @Override
    public String addStudent(Student student) {

        // Generate a new card for the student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
// this code was fine too but here we manually
// need to set validTill date and that's not a good practice
//        Date validTill = Date.from(
//                LocalDate.of(2030, 1, 1)
//                        .atStartOfDay(ZoneId.systemDefault())
//                        .toInstant()
//        );

        // Suppose this is the issue date (when card is created)
        LocalDate issueDate = LocalDate.now();
        /*
            LocalDate.now() → gives today's date without time (only yyyy-MM-dd).
            Example: If today is 16 Aug 2025, issueDate = 2025-08-16.
        */

        // Expire after 5 years from issue date
        Date validTill = Date.from(
                issueDate.plusYears(5)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );
        card.setValidTill(validTill);

        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);
        return "Student added successfully";
    }

    @Override
    public void deleteStudentById(Integer id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
    }
    @Override
    public void updateStudentInfoById(Integer id, Student updatedStudent){
        if(studentRepository.existsById(id)){
            Student existingStudent = studentRepository.findById(id).get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setMobileNo(updatedStudent.getMobileNo());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            studentRepository.save(existingStudent);
        }
        else {
            throw new RuntimeException("Student with ID " + id + " not found!");
        }
    }

    @Override
    public Student getStudentById(Integer id){
        if (studentRepository.existsById(id)){
            return studentRepository.findById(id).get();
        }
        throw new RuntimeException("Student with ID " + id + " not found!");
    }
    @Override
    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }
}
