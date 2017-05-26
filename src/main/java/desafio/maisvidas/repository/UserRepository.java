package desafio.maisvidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.maisvidas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	User findById(Long id);
	

}
