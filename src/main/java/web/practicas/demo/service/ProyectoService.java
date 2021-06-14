package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.dto.ProyectoAtributoDTO;
import web.practicas.demo.model.dto.ProyectoDTO;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.entidades.Atributo_Proyecto;
import web.practicas.demo.model.entidades.Key;
import web.practicas.demo.model.entidades.Proyecto;
import web.practicas.demo.repository.IAtributoProyectoRepository;
import web.practicas.demo.repository.IAtributoRepository;
import web.practicas.demo.repository.IProyectoRepository;
import web.practicas.demo.repository.base.BaseRepository;
import web.practicas.demo.service.auxiliar.AuxService;
import web.practicas.demo.service.base.BaseServiceImplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ProyectoService extends BaseServiceImplementation<Proyecto, Long> {
    @Autowired
    IProyectoRepository repositorio;
    @Autowired
    IAtributoRepository repositorioatributo;
    @Autowired
    IAtributoProyectoRepository repositorioRelaciones;

    public ProyectoService(BaseRepository<Proyecto, Long> repository, IProyectoRepository repositorio) {
        super(repository);
    }


    public ProyectoDTO addAtributoProyecto(ProyectoAtributoDTO valor) throws Exception {
        try{

            Atributo_Proyecto nuevo=new Atributo_Proyecto();

            String tipodato=repositorioatributo.getById(valor.getNombre()).getTipoDato().toLowerCase();

            switch (tipodato){
                case "string":
                    nuevo.setValueString(valor.getValor());
                    System.out.println("setea datos str");
                    break;
                case "integer":
                    nuevo.setValuenumero(Integer.parseInt(valor.getValor()));
                    System.out.println("setea datos int");
                    break;
                case "boolean":
                    nuevo.setValuenumero(Integer.parseInt(valor.getValor()));
                    System.out.println("setea datos boo");
                    break;
                case "date":
                    nuevo.setValueFecha(new Date(valor.getValor()));
                    System.out.println("setea datos date");
                    break;

            }

            Proyecto proyecto=repositorio.getById(valor.getIdProyecto());
            System.out.println("obtenemos proyecto");
            Key clave=new Key();
            clave.setProyecto(proyecto);
            clave.setAtributo(repositorioatributo.getById(valor.getNombre()));

            System.out.println("clave creada");



           nuevo.setMykey(clave);



            System.out.println("relacion añadida");


            repositorioRelaciones.save(nuevo);


            System.out.println("proyecto persistido");

            ProyectoDTO export =new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getEquipo());



            return export;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
