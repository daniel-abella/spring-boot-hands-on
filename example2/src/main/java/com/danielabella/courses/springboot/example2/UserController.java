package com.danielabella.courses.springboot.example2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usuario")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String listarTodosUsuarios() {
		return "todos";
	}

	@RequestMapping(value="/{identificador}", method = RequestMethod.GET)
	public String obterInformacaoUsuario(@PathVariable String identificador) {
		return "Ola, Meu Amigo Desenrolado que possui o ID = " + identificador;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createParticipant(@RequestBody User user) {

		try {
			System.out.println(user);
			return "foi persistido o usuario " + user;

		} catch (Exception e) {
			return "problema";
		}
	}
}
