package desafio.maisvidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.maisvidas.model.Medic;

public interface MedicRepository extends JpaRepository<Medic, Long> {

	List<Medic> findByFirstName(String name);

}

