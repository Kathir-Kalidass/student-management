# Student Management System — DevOps Demo

A Java-based Student Management System demonstrating a complete DevOps workflow:
Git version control, branching/merging, GitHub integration, Maven build & testing, and Ansible-based deployment.

## Project Structure

```
student-management/
├── pom.xml
├── .gitignore
├── README.md
├── src/
│   ├── main/java/com/devops/studentmgmt/
│   │   ├── StudentManagementApp.java    # Main entry point
│   │   ├── model/Student.java           # Student entity
│   │   ├── service/StudentService.java  # CRUD operations
│   │   └── util/IdGenerator.java        # ID utility
│   └── test/java/com/devops/studentmgmt/
│       └── service/StudentServiceTest.java
└── ansible/
    ├── inventory.ini                    # Ansible inventory
    └── deploy.yml                       # Deployment playbook
```

## How to Build

```bash
mvn clean package
```

This produces `target/student-management.jar` (uber/fat JAR via Maven Shade plugin).

## How to Run

```bash
java -jar target/student-management.jar
```

## How to Run Tests

```bash
mvn test
```

## DevOps Steps Covered

1. **Q1** — Java application developed
2. **Q2** — Maven project configured (see `pom.xml`)
3. **Q3** — Git initialized, files committed
4. **Q4** — Feature branch created, modified, merged
5. **Q5** — Pushed to GitHub
6. **Q6** — Maven build, test, and JAR packaging
7. **Q7** — Ansible configured with inventory
8. **Q8** — Ansible playbook created (`ansible/deploy.yml`)
9. **Q9** — Application deployed to remote server via Ansible
