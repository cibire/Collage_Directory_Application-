//package com.example.CollegeDirectoryManagementSystem.directory.repository;
//
//public interface DepartmentRepository {}
	package com.example.CollegeDirectoryManagementSystem.directory.repository;

	import com.example.CollegeDirectoryManagementSystem.directory.model.Department;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface DepartmentRepository extends JpaRepository<Department, Long> {
	    // You can define custom query methods here if needed.
	}


