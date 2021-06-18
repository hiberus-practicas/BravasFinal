package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import java.text.DateFormat;
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
            System.out.println(valor.getNombre());
            System.out.println(repositorioatributo.getById(valor.getNombre()).getTipoDato());
            String tipodato=repositorioatributo.getById(valor.getNombre()).getTipoDato().toLowerCase();
            System.out.println(tipodato);
            switch (tipodato){
                case "string":
                    nuevo.setValueString(valor.getValor());
                    break;
                case "integer":
                    nuevo.setValuenumero(Integer.parseInt(valor.getValor()));
                    break;
                case "boolean":
                    nuevo.setValuenumero(Integer.parseInt(valor.getValor()));
                    break;
                case "date":
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateInString = valor.getValor();
                    System.out.println(dateInString);
                    nuevo.setValueFecha(sdf.parse(dateInString));
                    break;

            }

            Proyecto proyecto=repositorio.getById(valor.getIdProyecto());

            Key clave=new Key();
            clave.setProyecto(proyecto);
            clave.setAtributo(repositorioatributo.getById(valor.getNombre()));





           nuevo.setMykey(clave);





            repositorioRelaciones.save(nuevo);




            ProyectoDTO export =new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getEquipo());



            return export;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
