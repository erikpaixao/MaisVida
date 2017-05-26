package desafio.maisvidas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.maisvidas.model.Medic;
import desafio.maisvidas.repository.MedicRepository;

@Service
public class MedicService  {
	@Autowired
    private MedicRepository medicRepository;

    public void save(Medic medic) {
        medicRepository.save(medic);
    }

    public List<Medic> findByName(String name) {
        return medicRepository.findByFirstName(name);
    }
    
    public Medic findById(Long id){
		return medicRepository.findOne(id); 	
    }
    
    public Medic removeMedic(Long id){
    	Medic medicoRemovido = findById(id);
    	medicRepository.delete(id);
		return medicoRemovido;	
    }

	public List<Medic> findAll() {
		return medicRepository.findAll();
	}
	
}
