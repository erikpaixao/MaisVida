package desafio.maisvidas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import desafio.maisvidas.model.City;
import desafio.maisvidas.service.CityService;
import desafio.maisvidas.util.PathUtil;

@RestController
@RequestMapping(PathUtil.PATH_CITY)
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(method=RequestMethod.GET)
	public List<City> listarTodos() {
		return cityService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value =  "{id}")
	public City buscarPorId(@PathVariable Long id) {
		return cityService.findById(id);
	}

	@CrossOrigin
	@RequestMapping(method={RequestMethod.POST, RequestMethod.PUT} )
	@ResponseBody
	public City salvar(@RequestBody City city) {
		cityService.save(city);
		return city;

	}

}
