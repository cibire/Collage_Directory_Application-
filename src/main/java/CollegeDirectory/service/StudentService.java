//package admin_user.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import admin_user.model.Faculty;
//import admin_user.model.Student;
//import admin_user.model.User;
//import admin_user.repositories.FacultyRepository;
//import admin_user.repositories.StudentRepository;
//import admin_user.repositories.UserRepository;
//
//import java.util.List;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Fetch a student by user email
//    public Student getStudentByEmail(String email) {
//        // Fetch the user by email
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new RuntimeException("User not found for email: " + email );
//        }
//
//        // Fetch the student by user ID
//        return studentRepository.findByUser(user)
//                .orElseThrow(() -> new RuntimeException("Student not found for user: " + user.getId()));
//    }
//
//    public List<Student> searchStudents(String name, String department) {
//        return studentRepository.findByNameContainingOrDepartmentContaining(name, department);
//    }
//}
package CollegeDirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CollegeDirectory.model.Student;
import CollegeDirectory.model.User;
import CollegeDirectory.repositories.StudentRepository;
import CollegeDirectory.repositories.UserRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;
    

    // Fetch a student by user email
    public Student getStudentByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found for email: " + email);
        }

        return studentRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Student not found for user: " + user.getId()));
    }

    // Search students by name or department
    public List<Student> searchStudents(String name, String department) {
        return studentRepository.findByNameContainingOrDepartmentContaining(name, department);
    }

    // Fetch all students (for admin dashboard)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
 // Save a new student (for admin dashboard)
    public void saveStudent(Student student) {
        // Check if a user with the given email already exists
        User user = userRepository.findByEmail(student.getEmail());
        if (user == null) {
            // Create a new user if it doesn't exist
            user = new User();
            user.setUsername(student.getName());
            user.setEmail(student.getEmail());
            user.setRole("STUDENT"); // Assuming roles are set this way

            userRepository.save(user); // Save the new user
        }
        
        // Set the user for the student
        student.setUser(user);

        // Save the student
        studentRepository.save(student);
    }

    // Fetch a specific student by ID (for editing)
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for id: " + id));
    }

    // Delete a student (for admin dashboard)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
