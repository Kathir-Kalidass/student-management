package com.devops.studentmgmt;

import com.devops.studentmgmt.model.Student;
import com.devops.studentmgmt.service.StudentService;

/**
 * Main application — a simple Student Management System.
 * Demonstrates adding, searching, updating, and deleting students.
 */
public class StudentManagementApp {

    private static void printSeparator() {
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {
        StudentService service = new StudentService();

        printSeparator();
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        printSeparator();

        // Add students
        System.out.println("\n[ADD] Adding students...");
        service.addStudent("Alice Johnson",  "alice@university.edu", 20, "Computer Science");
        service.addStudent("Bob Smith",       "bob@university.edu",   22, "Mathematics");
        service.addStudent("Carol Davis",     "carol@university.edu", 21, "Computer Science");
        service.addStudent("David Lee",       "david@university.edu", 23, "Physics");
        service.addStudent("Eve Martinez",    "eve@university.edu",   20, "Mathematics");
        System.out.println("Added 5 students. Total: " + service.count());

        // List all students
        System.out.println("\n[LIST] All students:");
        for (Student s : service.getAllStudents()) {
            System.out.println("  " + s);
        }

        // Search by name
        System.out.println("\n[SEARCH] Searching for 'Carol':");
        for (Student s : service.searchByName("Carol")) {
            System.out.println("  " + s);
        }

        // Get by department
        System.out.println("\n[DEPARTMENT] Computer Science students:");
        for (Student s : service.getByDepartment("Computer Science")) {
            System.out.println("  " + s);
        }

        // Update a student
        System.out.println("\n[UPDATE] Updating student id=2 (Bob Smith)...");
        service.updateStudent(2, "Bob Smith Jr.", "bob.smith@university.edu", 23, "Statistics");
        System.out.println("  " + service.getStudent(2).orElse(null));

        // Delete a student
        System.out.println("\n[DELETE] Deleting student id=4 (David Lee)...");
        service.deleteStudent(4);
        System.out.println("Remaining students: " + service.count());

        // Final listing
        System.out.println("\n[FINAL] All students:");
        for (Student s : service.getAllStudents()) {
            System.out.println("  " + s);
        }

        // [NEW] Department statistics
        System.out.println("\n[STATS] Department-wise student count:");
        for (java.util.Map.Entry<String, Long> entry : service.getDepartmentStats().entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " student(s)");
        }

        printSeparator();
        System.out.println("  Application completed successfully!");
        printSeparator();
    }
}
