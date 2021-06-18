package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.repository.IAtributoProyectoRepository;
import web.practicas.demo.repository.IAtributoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AtributoService {
    @Autowired
    protected IAtributoRepository repository;
    @Autowired
    protected IAtributoProyectoRepository repositoryRelaciones;
    @Autowired
    protected RelacionesService servicioRelaciones;

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
           Atributo devolver= repository.findById(id).get();
            repository.deleteById(id);
            return devolver;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Proyecto> buscarPorAtributoValor(String atributo, String valor) throws Exception {
        try {
            System.out.println("va");
            Atributo atributobuscado = repository.getById(atributo);
            List<Atributo_Proyecto> relacionescumplefiltro = servicioRelaciones.consultor(atributobuscado, valor);
            System.out.println("hace consulta");
            List<Proyecto> devolver = new ArrayList<>();
            System.out.println("sigue");

            for(Atributo_Proyecto elemento:relacionescumplefiltro){
                devolver.add(elemento.getMykey().getProyecto());
            }

            return devolver;


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    public List<Proyecto> buscarProyectosAcotadoFechas(String limiteinferior,String limiteosuperior,String nombreatributo) throws Exception{
        try{
            List<Proyecto>devolver=new ArrayList();


            List<Atributo_Proyecto>filtrado=servicioRelaciones.buscarporfecha(limiteinferior,limiteosuperior,nombreatributo);
            System.out.println(filtrado.size());
            System.out.println("hago busqueda");
            for(Atributo_Proyecto elemento:filtrado){
                devolver.add(elemento.getMykey().getProyecto());
            }
            System.out.println("devuelvo solo proyectos");
            return devolver;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
