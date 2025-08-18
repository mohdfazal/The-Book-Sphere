//package com.example.The.Book.Sphere.Entity;
//
//import com.example.The.Book.Sphere.Enum.CardStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.util.Date;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "card")
//public class Card {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @CreationTimestamp
//    private Date issueDate;
//
//    @Enumerated(EnumType.STRING)
//    private CardStatus cardStatus;
//
//    private Date validTill;
//
//    @OneToOne
//    @JoinColumn
//    private Student student;
//
//    public Card(Date issueDate, Date validTill, Student student) {
//
//        this.issueDate = issueDate;
//
//        this.validTill = validTill;
//        this.student = student;
//    }
//
////    public Card() {
////    }
////
////    public int getId() {
////        return id;
////    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getIssueDate() {
//        return issueDate;
//    }
//
//    public void setIssueDate(Date issueDate) {
//        this.issueDate = issueDate;
//    }
//
//    public CardStatus getCardStatus() {
//        return cardStatus;
//    }
//
//    public void setCardStatus(CardStatus cardStatus) {
//        this.cardStatus = cardStatus;
//    }
//
//    public Date getValidTill() {
//        return validTill;
//    }
//
//    public void setValidTill(Date validTill) {
//        this.validTill = validTill;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//}
package com.example.The.Book.Sphere.Entity;

import com.example.The.Book.Sphere.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp // Automatically set when persisted
    private Date issueDate;

    @Enumerated(EnumType.STRING) // Store enum name instead of ordinal number
    private CardStatus cardStatus;

    private Date validTill;

    @OneToOne
    @JoinColumn // Foreign key to Student
    @JsonBackReference   // 👈 prevents infinite loop
    private Student student;

    // ✅ Required no-args constructor for JPA
    public Card() {
    }

    // Optional parameterized constructor for convenience
    public Card(Date issueDate, Date validTill, Student student) {
        this.issueDate = issueDate;
        this.validTill = validTill;
        this.student = student;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }
    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getValidTill() {
        return validTill;
    }
    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
