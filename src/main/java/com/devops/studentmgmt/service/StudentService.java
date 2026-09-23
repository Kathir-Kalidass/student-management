package com.devops.studentmgmt.service;

import com.devops.studentmgmt.model.Student;
import com.devops.studentmgmt.util.IdGenerator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Service layer for managing students.
 */
public class StudentService {

    private final Map<Integer, Student> store = new ConcurrentHashMap<>();
    private final IdGenerator idGen = new IdGenerator();

    /**
     * Add a new student.
     */
    public Student addStudent(String name, String email, int age, String department) {
        int id = idGen.nextId();
        Student s = new Student(id, name, email, age, department);
        store.put(id, s);
        return s;
    }

    /**
     * Get a student by id.
     */
    public Optional<Student> getStudent(int id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * Get all students.
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    /**
     * Update an existing student.
     */
    public Optional<Student> updateStudent(int id, String name, String email, int age, String department) {
        Student existing = store.get(id);
        if (existing == null) {
            return Optional.empty();
        }
        existing.setName(name);
        existing.setEmail(email);
        existing.setAge(age);
        existing.setDepartment(department);
        return Optional.of(existing);
    }

    /**
     * Delete a student by id.
     */
    public boolean deleteStudent(int id) {
        return store.remove(id) != null;
    }

    /**
     * Search students by name (case-insensitive partial match).
     */
    public List<Student> searchByName(String query) {
        String q = query.toLowerCase();
        return store.values().stream()
                .filter(s -> s.getName().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    /**
     * Get students by department.
     */
    public List<Student> getByDepartment(String department) {
        return store.values().stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    /**
     * Return total student count.
     */
    public int count() {
        return store.size();
    }

    /**
     * Get department-wise student statistics (department name -> count).
     * Feature added on feature/search-enhancement branch.
     */
    public Map<String, Long> getDepartmentStats() {
        return store.values().stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.counting()));
    }
}
