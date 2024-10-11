package com.example.CollegeDirectoryManagementSystem.directory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;  // Enum for Student, Faculty, Admin

   
	private String name;

	private String email;

	private String phone;

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Object role2) {
		// TODO Auto-generated method stub
		
	}
}
