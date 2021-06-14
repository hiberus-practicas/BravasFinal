package web.practicas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.practicas.demo.controller.base.BaseControllerImplementation;
import web.practicas.demo.model.dto.ProyectoAtributoDTO;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.service.ProyectoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v01/proyectos/")
public class ProyectoRest extends BaseControllerImplementation<Proyecto, ProyectoService> {
    @Autowired
    ProyectoService service;

    public ProyectoRest(ProyectoService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("/atributes")
    public ResponseEntity<?> addAtributoProyecto(@RequestBody ProyectoAtributoDTO valor) throws Exception {

        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.addAtributoProyecto(valor));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion erronea'}");
        }

    }


}

