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

import desafio.maisvidas.model.Medic;
import desafio.maisvidas.service.MedicService;
import desafio.maisvidas.util.PathUtil;

@RestController
@RequestMapping(PathUtil.PATH_MEDIC)
public class MedicController {

	@Autowired
	private MedicService medicService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Medic> listarTodos() {
		return medicService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value =  "{id}")
	public Medic buscarPorId(@PathVariable Long id) {
		return medicService.findById(id);
	}

	@CrossOrigin
	@RequestMapping(method={RequestMethod.POST, RequestMethod.PUT} )
	@ResponseBody
	public Medic salvar(@RequestBody Medic medic) {
		medicService.save(medic);
		return medic;

	}

}
