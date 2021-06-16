package web.practicas.demo.repository;


import org.springframework.data.jpa.repository.Query;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Key;
import web.practicas.demo.repository.base.BaseRepository;

import java.util.Date;
import java.util.List;

public interface IAtributoProyectoRepository extends BaseRepository<Atributo_Proyecto, Key> {
    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_string LIKE %:filtro%",nativeQuery = true)
    List<Atributo_Proyecto> busquedaSemantica(String filtro);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_string LIKE %:valor% AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> busquedaStringAtributoValor(String nombreAtributo, String valor);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_numero = :valor AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> busquedaNumeroAtributoValor(String nombreAtributo, Integer valor);

    @Query(value = "SELECT * FROM atributo_proyectos p   where p.value_fecha = :valor AND p.nombre_atributo =:nombreAtributo",nativeQuery = true)
    List<Atributo_Proyecto> busquedaDateAtributoValor(String nombreAtributo, Date valor);
    @Query(value = "SELECT * FROM atributo_proyectos p where p.value_fecha BETWEEN :valorinferior AND :valorsuperior AND p.nombre_atributo =:nombreatributo" ,nativeQuery = true)
    List<Atributo_Proyecto> busquedaAcotadaporDate(String valorinferior,String valorsuperior,String nombreatributo);
}
