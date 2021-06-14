package web.practicas.demo.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<E,ID extends Serializable> {
List<E>listall() throws Exception ;
Optional<E>listbyid(ID id)throws Exception;
E add(E entidad)throws Exception;
E update(ID id,E entidad)throws Exception;
E delete(ID id)throws Exception;


}
