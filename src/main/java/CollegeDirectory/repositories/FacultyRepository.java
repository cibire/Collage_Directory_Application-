package CollegeDirectory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CollegeDirectory.model.Faculty;
import CollegeDirectory.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	 Optional<Faculty> findByUser(User user);  // Add this method to retrieve a student by user
	    List<Faculty> findByNameContainingOrDepartmentContaining(String name, String department);
}
