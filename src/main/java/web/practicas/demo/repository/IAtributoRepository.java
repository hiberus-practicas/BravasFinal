package web.practicas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.entidades.Usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IAtributoRepository extends JpaRepository<Atributo, String >{


}
