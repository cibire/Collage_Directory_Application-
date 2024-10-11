package com.example.CollegeDirectoryManagementSystem.directory.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
//
//
//@Controller
//@RequestMapping("/faculty")
//public class FacultyController {
//	 @GetMapping("/dashboard")
//	    public String getFacultyDashboard() {
//	        // Fetch faculty-specific data and add to model
//	        return "faculty/dashboard";
//	    }
//}


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")  // This will map the entire controller to /faculty
public class FacultyController {


    @GetMapping("/dashboard")
    public String getFacultyDashboard() {
        return "faculty/dashboard";
    }


}
