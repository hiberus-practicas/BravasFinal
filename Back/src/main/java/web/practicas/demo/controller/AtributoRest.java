package web.practicas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.practicas.demo.model.dto.AtributoDTO;
import web.practicas.demo.model.dto.FechasDTO;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.service.AtributoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v01/atributos/")
public class AtributoRest {
    @Autowired
    AtributoService service;



    @GetMapping("")
    public ResponseEntity<?> listall() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listall());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listbyid(@PathVariable String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listbyid(id).get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Atributo entidad) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.add(entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Atributo entidad) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id, entidad));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @DeleteMapping("/{nombre}")

    public ResponseEntity<?> borrarAtributo(@PathVariable String nombre){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.borrarAtributo(nombre));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @PostMapping("/busqueda/")
    public ResponseEntity<?> buscarPorAtributoValor( @RequestBody AtributoDTO valordto) throws Exception {
        try {
            String atributo=valordto.getAtributo();
            String valor = valordto.getValor();

            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorAtributoValor(atributo, valor));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'error en la peticion'}");
        }

    }

    @PostMapping("/busqueda/fechas/")
    public ResponseEntity<?> busquedaacotadafechas(@RequestBody FechasDTO limites) throws Exception {
        try {

            String nombreatributo = limites.getNombreatributo();

            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProyectosAcotadoFechas(limites.getLimiteinferior(), limites.getLimitesuperior(), nombreatributo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'error en la peticion'}");
        }

    }


}
