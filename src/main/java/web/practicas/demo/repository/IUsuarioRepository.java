package web.practicas.demo.repository;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.practicas.demo.model.entidades.Usuarios;
import web.practicas.demo.repository.base.BaseRepository;

@Repository
public interface IUsuarioRepository extends BaseRepository<Usuarios, Long> {
	List<Usuarios>findByemail(String email)throws Exception;
	List<Usuarios>findByusername(String username)throws Exception;



}
