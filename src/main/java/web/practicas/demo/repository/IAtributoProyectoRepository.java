package web.practicas.demo.repository;


import org.springframework.data.jpa.repository.Query;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Key;
import web.practicas.demo.repository.base.BaseRepository;

import java.util.List;

public interface IAtributoProyectoRepository extends BaseRepository<Atributo_Proyecto, Key> {
    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_string LIKE %:filtro%",nativeQuery = true)
    List<Atributo_Proyecto> BusquedaSemantica(String filtro);
}
