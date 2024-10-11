package com.example.CollegeDirectoryManagementSystem.directory.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_STUDENT":
                return "redirect:/student/dashboard";
            case "ROLE_FACULTY_MEMBER":
                return "redirect:/faculty/dashboard";
            case "ROLE_ADMINISTRATOR":
                return "redirect:/admin/dashboard";
            default:
                return "error";  // handle unexpected roles
        }
    }
}
