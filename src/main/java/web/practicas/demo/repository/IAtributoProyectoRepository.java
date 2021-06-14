package web.practicas.demo.repository;


import org.springframework.data.jpa.repository.Query;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Key;
import web.practicas.demo.repository.base.BaseRepository;

import java.util.Date;
import java.util.List;

public interface IAtributoProyectoRepository extends BaseRepository<Atributo_Proyecto, Key> {
    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_string LIKE %:filtro%",nativeQuery = true)
    List<Atributo_Proyecto> BusquedaSemantica(String filtro);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_string LIKE %:valor% AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> BusquedaStringAtributoValor(String nombreAtributo, String valor);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_numero = :valor AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> BusquedaNumeroAtributoValor(String nombreAtributo, Integer valor);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_fecha = :valor AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> BusquedaDateAtributoValor(String nombreAtributo, Date valor);

}
