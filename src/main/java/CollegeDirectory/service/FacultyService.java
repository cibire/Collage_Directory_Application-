//package admin_user.service;
//
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
//public class FacultyService {
//
//    @Autowired
//    private FacultyRepository facultyRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Fetch a student by user email
//    public Faculty getFacultyByEmail(String email) {
//        // Fetch the user by email
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new RuntimeException("User not found for email: " + email );
//        }
//
//        // Fetch the student by user ID
//        return facultyRepository.findByUser(user)
//                .orElseThrow(() -> new RuntimeException("Faculty not found for user: " + user.getId()));
//    }
//
//    public List<Faculty> searchFaculty(String name, String department) {
//        return facultyRepository.findByNameContainingOrDepartmentContaining(name, department);
//    }
//}
package CollegeDirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CollegeDirectory.model.Faculty;
import CollegeDirectory.model.User;
import CollegeDirectory.repositories.FacultyRepository;
import CollegeDirectory.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UserRepository userRepository;

    // Fetch a faculty by user email
    public Faculty getFacultyByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found for email: " + email);
        }
        return facultyRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Faculty not found for user: " + user.getId()));
    }

    // Search faculty by name or department
    public List<Faculty> searchFaculty(String name, String department) {
        return facultyRepository.findByNameContainingOrDepartmentContaining(name, department);
    }

    // Fetch all faculty (for admin dashboard)
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }


 // Save a new faculty member (for admin dashboard)
    public void saveFaculty(Faculty faculty) {
        // Check if a user with the given email already exists
        User user = userRepository.findByEmail(faculty.getEmail());
        if (user == null) {
            // Create a new user if it doesn't exist
            user = new User();
            user.setUsername(faculty.getName()); // Use "Username" as per your User model
            user.setEmail(faculty.getEmail());
            user.setRole("FACULTY"); // Set the role as faculty
            userRepository.save(user); // Save the new user
        }

        // Set the user for the faculty
        faculty.setUser(user);

        // Save the faculty member
        facultyRepository.save(faculty);
    }

    // Fetch a specific faculty by ID (for editing)
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found for id: " + id));
    }

    // Delete a faculty member (for admin dashboard)
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
