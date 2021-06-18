package web.practicas.demo.service.auxiliar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.repository.IAtributoRepository;

@Service
public class AuxService {

    @Autowired
    IAtributoRepository repository;

    public AuxService(IAtributoRepository repository) {
        this.repository = repository;
    }

    public String dimeTipoDato(String nombreAtributo) {

        String tipoDato;

        Atributo encontrar=repository.findById(nombreAtributo).get();

        tipoDato = encontrar.getTipoDato();
        return tipoDato;
    }
}
