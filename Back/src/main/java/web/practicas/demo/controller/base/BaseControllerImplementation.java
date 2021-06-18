package web.practicas.demo.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import web.practicas.demo.model.base.Base;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.service.base.BaseServiceImplementation;

public class BaseControllerImplementation<E extends Base, S extends BaseServiceImplementation<E, Long>>
        implements BaseController<E, Long> {

    S service;

    public BaseControllerImplementation(S service) {
        this.service = service;
    }



    @GetMapping("")
    public ResponseEntity<?> listall() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listall());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'peticion incorrecta'}");
        }
    }

   @GetMapping("/{id}")
    public ResponseEntity<?> listbyid(Long id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listbyid(id).get());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'peticion incorrecta'}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> add(E entidad) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.add(entidad));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'peticion incorrecta'}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(Long id, E entidad) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entidad));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'peticion incorrecta'}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id) throws Exception {
        try {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'peticion incorrecta'}");
        }
    }
}
