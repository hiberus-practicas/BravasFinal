package web.practicas.demo.repository;

import org.springframework.stereotype.Repository;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.repository.base.BaseRepository;

@Repository
public interface IProyectoRepository extends BaseRepository<Proyecto,Long> {
}
