package web.practicas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.practicas.demo.model.dto.AtributoDTO;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.service.AtributoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v01/atributos/")
public class AtributoRest {
    @Autowired
    AtributoService service;

    public AtributoRest(AtributoService service) {
        this.service = service;
    }

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

    @DeleteMapping("/{id}")

    public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error':'peticion incorrecta'}");
        }
    }

    @GetMapping("/busqueda/{atributo}/")
    public ResponseEntity<?> buscarPorAtributoValor(@PathVariable(value ="atributo" ) String atributo, @RequestBody AtributoDTO valordto) throws  Exception{
        try{
            String valor=valordto.getValor();

            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorAtributoValor(atributo,valor));

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'Error':'error en la peticion'}");
        }

    }

}
