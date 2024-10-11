//package com.example.CollegeDirectoryManagementSystem.directory.controller;
//
//public class LoginController {
//
//}
package com.example.CollegeDirectoryManagementSystem.directory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login") // Map the login page
    public String showLoginPage() {
        return "login"; // This refers to login.html in src/main/resources/templates
    }
}
