package com.example.CollegeDirectoryManagementSystem.directory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/student")
public class StudentController {
	 @GetMapping("/dashboard")
	    public String getStudentDashboard(Model model) {
	        // Fetch student-specific data and add to model
	        return "student/dashboard";
	    }
}
