package web.practicas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.service.RelacionesService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v01/relaciones/")
public class RelacionesController {
    @Autowired
    RelacionesService service;


    @GetMapping("")
    public ResponseEntity<?> listall() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listall());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{'error':'peticion incorrecta'}");
        }
    }

    @GetMapping("proyecto/{proyecto}")
    public ResponseEntity<?> listbyProyecto(@PathVariable Long proyecto) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listbyProyecto(proyecto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @GetMapping("atributo/{atributo}")
    public ResponseEntity<?> listbyAtributo(@PathVariable String atributo) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listbyAtributo(atributo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @DeleteMapping("{proyecto}/{atributo}")
    public ResponseEntity<?> delete(@PathVariable Long proyecto, @PathVariable String atributo) throws Exception {
        try {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(proyecto, atributo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }


    }
    @GetMapping("/busqueda/{filtro}")
    public ResponseEntity<?> busquedaSemantica(@PathVariable String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.busquedaSemantica(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");

        }
    }
}