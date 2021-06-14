package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.repository.IAtributoProyectoRepository;
import web.practicas.demo.repository.IAtributoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtributoService {
    @Autowired
    protected IAtributoRepository repository;
    @Autowired
    protected IAtributoProyectoRepository repositoryRelaciones;

    public AtributoService(IAtributoRepository repository) {
        this.repository = repository;
    }

    public List<Atributo> listall() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Atributo> listbyid(String id) throws Exception {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Atributo add(Atributo entidad) throws Exception {
        try {
            return repository.save(entidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Atributo update(String id, Atributo entidad) throws Exception {
        try {

            repository.deleteById(id);
            return repository.save(entidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Atributo delete(String id) throws Exception {
        try {
            repository.deleteById(id);
            return repository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Proyecto> buscarPorAtributoValor(String atributo, String valor) throws Exception {
        try{
            List<Proyecto>resultado;
            Atributo atributobuscado=repository.getById(atributo);







            return resultado;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
