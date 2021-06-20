package web.practicas.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Key;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.repository.IAtributoProyectoRepository;
import web.practicas.demo.repository.IAtributoRepository;
import web.practicas.demo.repository.IProyectoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RelacionesService {
    @Autowired
    IAtributoProyectoRepository repositoryRelaciones;
    @Autowired
    IProyectoRepository repositoryProyecto;
    @Autowired
    IAtributoRepository repositoryAtributo;


    public List<Atributo_Proyecto> listall() throws Exception {
        try {
            return repositoryRelaciones.findAll();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Atributo_Proyecto> listbyProyecto(Long proyecto) throws Exception {
        try {
            Proyecto filtro = repositoryProyecto.getById(proyecto);
            List<Atributo_Proyecto> universo = repositoryRelaciones.findAll();
            List<Atributo_Proyecto> devolver = new ArrayList<>();
            for (Atributo_Proyecto elemento : universo) {
                if (elemento.getMykey().getProyecto().equals(filtro)) {
                    devolver.add(elemento);
                }
            }
            return devolver;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Atributo_Proyecto> listbyAtributo(String atributo) throws Exception {
        try {
            Atributo filtro = repositoryAtributo.getById(atributo);
            List<Atributo_Proyecto> universo = repositoryRelaciones.findAll();
            List<Atributo_Proyecto> devolver = new ArrayList<>();
            for (Atributo_Proyecto elemento : universo) {
                if (elemento.getMykey().getAtributo().equals(filtro)) {
                    devolver.add(elemento);
                }
            }
            return devolver;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Atributo_Proyecto delete(Long proyecto, String atributo) throws Exception {
        Key clave = new Key(repositoryAtributo.getById(atributo), repositoryProyecto.getById(proyecto));
        Atributo_Proyecto check = repositoryRelaciones.getById(clave);
        repositoryRelaciones.deleteById(clave);
        return check;
    }

    public List<Proyecto> busquedaSemantica(String filtro) throws Exception {
        try {

            List<Atributo_Proyecto> universo = repositoryRelaciones.busquedaSemantica(filtro);

            List<Proyecto> universoProcesado = new ArrayList();

            for (Atributo_Proyecto elemento : universo) {
                if(!universoProcesado.contains(elemento.getMykey().getProyecto()))
                    universoProcesado.add(elemento.getMykey().getProyecto());
            }


            return universoProcesado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public List<Atributo_Proyecto> consultor(Atributo atributo, String valor) throws Exception {
        try {
            String nombreAtributo = atributo.getNombreAtributo();
            String tipoDato = atributo.getTipoDato().toLowerCase();
            switch (tipoDato) {
                case "string":
                    String valorFinalString = valor;
                    return repositoryRelaciones.busquedaStringAtributoValor(nombreAtributo, valorFinalString);

                case "integer":
                    Integer valorFinalInteger = Integer.parseInt(valor);
                    return repositoryRelaciones.busquedaNumeroAtributoValor(nombreAtributo, valorFinalInteger);

                case "boolean":
                    Integer valorFinalBoolean = Integer.parseInt(valor);
                    return repositoryRelaciones.busquedaNumeroAtributoValor(nombreAtributo, valorFinalBoolean);

                case "date":
                    Date valorFinalDate = new Date(valor);
                    return repositoryRelaciones.busquedaDateAtributoValor(nombreAtributo, valorFinalDate);


            }
            return null;

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }


    }

    public List<Atributo_Proyecto> buscarporfecha(String limiteinferior, String limitesuperior,String nombreatributo) throws Exception {
        try{
           return repositoryRelaciones.busquedaAcotadaporDate(limiteinferior,limitesuperior,nombreatributo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
