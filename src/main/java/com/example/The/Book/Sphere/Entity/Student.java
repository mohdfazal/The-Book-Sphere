package com.example.The.Book.Sphere.Entity;

import com.example.The.Book.Sphere.Enum.Department;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobileNo;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL )
    @JsonManagedReference   // 👈 prevents infinite loop
    private Card card;

    public Student( String name, int age, String mobileNo, Card card) {
        this.name = name;
        this.age = age;
        this.mobileNo = mobileNo;
        this.card = card;
    }

    public Student() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
