//package com.example.CollegeDirectoryManagementSystem.directory.model;
//
//public class StudentProfile {
//
//}
package com.example.CollegeDirectoryManagementSystem.directory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentProfile {
    @Id
    private Long userId;  // FK to User

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    private String photo;
    private String year;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    private double gpa;
    private int attendancePercentage;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
