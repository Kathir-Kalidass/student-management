package com.devops.studentmgmt.service;

import com.devops.studentmgmt.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService();
    }

    @Test
    void testAddAndCount() {
        assertEquals(0, service.count());
        service.addStudent("Alice", "alice@test.com", 20, "CS");
        assertEquals(1, service.count());
    }

    @Test
    void testGetStudent() {
        Student s = service.addStudent("Bob", "bob@test.com", 22, "Math");
        Optional<Student> found = service.getStudent(s.getId());
        assertTrue(found.isPresent());
        assertEquals("Bob", found.get().getName());
    }

    @Test
    void testGetStudentNotFound() {
        assertTrue(service.getStudent(999).isEmpty());
    }

    @Test
    void testUpdateStudent() {
        Student s = service.addStudent("Carol", "carol@test.com", 21, "CS");
        Optional<Student> updated = service.updateStudent(s.getId(), "Carol V2", "carol2@test.com", 22, "Physics");
        assertTrue(updated.isPresent());
        assertEquals("Carol V2", updated.get().getName());
        assertEquals("Physics", updated.get().getDepartment());
    }

    @Test
    void testUpdateNotFound() {
        assertTrue(service.updateStudent(999, "X", "x@t.com", 0, "Y").isEmpty());
    }

    @Test
    void testDeleteStudent() {
        Student s = service.addStudent("Dave", "dave@test.com", 23, "Bio");
        assertTrue(service.deleteStudent(s.getId()));
        assertEquals(0, service.count());
        assertTrue(service.getStudent(s.getId()).isEmpty());
    }

    @Test
    void testDeleteNotFound() {
        assertFalse(service.deleteStudent(999));
    }

    @Test
    void testSearchByName() {
        service.addStudent("Alice Wonder", "a@t.com", 20, "CS");
        service.addStudent("Alice Wonderland", "aw@t.com", 21, "CS");
        service.addStudent("Bob Builder", "b@t.com", 22, "Eng");
        List<Student> results = service.searchByName("alice");
        assertEquals(2, results.size());
    }

    @Test
    void testGetByDepartment() {
        service.addStudent("Alice", "a@t.com", 20, "CS");
        service.addStudent("Bob", "b@t.com", 22, "Math");
        service.addStudent("Carol", "c@t.com", 21, "CS");
        List<Student> csStudents = service.getByDepartment("CS");
        assertEquals(2, csStudents.size());
    }
}
