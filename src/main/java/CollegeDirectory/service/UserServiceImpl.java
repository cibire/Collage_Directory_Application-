package CollegeDirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import CollegeDirectory.dto.UserDto;
import CollegeDirectory.model.User;
import CollegeDirectory.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRespository;



	@Override
	public User save(UserDto userDto) {
		User user=new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getUsername());
		return userRespository.save(user);
	}
}