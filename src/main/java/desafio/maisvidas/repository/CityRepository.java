package desafio.maisvidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.maisvidas.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByName(String name);
	

}
