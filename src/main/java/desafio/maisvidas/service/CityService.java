package desafio.maisvidas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.maisvidas.model.City;
import desafio.maisvidas.repository.CityRepository;

@Service
public class CityService  {
	@Autowired
    private CityRepository cityRepository;

    public void save(City city) {
        cityRepository.save(city);
    }

    public List<City> findByName(String name) {
        return cityRepository.findByName(name);
    }
    
    public City findById(Long id){
		return cityRepository.findOne(id); 	
    }
    
    public City removeCity(Long id){
    	City cityRemovido = findById(id);
    	cityRepository.delete(id);
		return cityRemovido;	
    }

	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
}
