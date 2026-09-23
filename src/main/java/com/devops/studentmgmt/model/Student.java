package com.devops.studentmgmt.model;

/**
 * Student model class representing a student entity.
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    private String department;

    public Student() {}

    public Student(int id, String name, String email, int age, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', email='%s', age=%d, department='%s'}",
                id, name, email, age, department);
    }
}
