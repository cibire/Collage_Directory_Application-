package CollegeDirectory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CollegeDirectory.model.User;
import java.util.List;

 

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
 