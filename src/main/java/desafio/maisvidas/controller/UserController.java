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

import desafio.maisvidas.model.User;
import desafio.maisvidas.service.UserService;
import desafio.maisvidas.util.PathUtil;

@RestController
@RequestMapping(PathUtil.PATH_USER)
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public List<User> listarTodos() {

		return userService.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, value =  "{id}")
	public User buscarPorId(@PathVariable Long id) {
		return userService.findById(id);
	}

	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public User salvar(@RequestBody User user) {
		userService.save(user);
		return user;

	}

}
