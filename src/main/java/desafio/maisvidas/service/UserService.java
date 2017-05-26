package desafio.maisvidas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import desafio.maisvidas.model.User;
import desafio.maisvidas.repository.UserRepository;

@Service
public class UserService  {
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> findAll(){
		return userRepository.findAll(); 	
    }

	public User findById(Long id) {
		return userRepository.findById(id);
	}
}
