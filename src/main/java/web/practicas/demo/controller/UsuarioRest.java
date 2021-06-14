package web.practicas.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import web.practicas.demo.controller.base.BaseControllerImplementation;
import web.practicas.demo.model.dto.Logueo;
import web.practicas.demo.model.dto.UsuarioDto;
import web.practicas.demo.model.entidades.Usuarios;
import web.practicas.demo.service.UsuarioService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v01/usuarios")
public class UsuarioRest  extends BaseControllerImplementation<Usuarios,UsuarioService> {
	@Autowired
	UsuarioService service;

	public UsuarioRest(UsuarioService service) {
		super(service);
		
	}


	@PostMapping("/login")
	public ResponseEntity<Logueo> islogged(@RequestBody UsuarioDto usuariolog) {
		
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.isLogged(usuariolog));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Logueo(0l));
			
		}
		
		
	}

	
	
	
	

}
