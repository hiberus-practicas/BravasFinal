package web.practicas.demo.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import web.practicas.demo.model.base.Base;

import java.io.Serializable;

public interface BaseController<E extends Base, ID extends Serializable> {

    ResponseEntity<?> listall() throws Exception;

    ResponseEntity<?> listbyid(@PathVariable ID id) throws Exception;

    ResponseEntity<?> add(@RequestBody E entidad) throws Exception;

    ResponseEntity<?> update(@PathVariable ID id,@RequestBody E entidad) throws Exception;

    ResponseEntity<?> delete(@PathVariable ID id) throws Exception;

}
