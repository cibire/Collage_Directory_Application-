package CollegeDirectory.controller;

import CollegeDirectory.model.Faculty;
import CollegeDirectory.model.Student;
import CollegeDirectory.service.FacultyService;
import CollegeDirectory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    // View Dashboard with lists of students and faculty
    @GetMapping
    public String viewDashboard(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("faculty", facultyService.getAllFaculty());
        return "admin";
    }

    // Add new student
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/admin";
    }

    // Add new faculty
    @PostMapping("/addFaculty")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return "redirect:/admin";
    }

    // Edit student
    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/edit";
    }

    // Edit faculty
    @GetMapping("/editFaculty/{id}")
    public String editFaculty(@PathVariable("id") Long id, Model model) {
        model.addAttribute("faculty", facultyService.getFacultyById(id));
        return "faculty/edit";
    }

    // Delete student
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/admin";
    }

    // Delete faculty
    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable("id") Long id) {
        facultyService.deleteFaculty(id);
        return "redirect:/admin";
    }
}
