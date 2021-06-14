package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Usuarios;
import web.practicas.demo.model.dto.Logueo;
import web.practicas.demo.model.dto.UsuarioDto;
import web.practicas.demo.repository.base.BaseRepository;
import web.practicas.demo.repository.IUsuarioRepository;
import web.practicas.demo.service.base.BaseServiceImplementation;

import java.util.List;

@Service

public class UsuarioService extends BaseServiceImplementation<Usuarios, Long> {
    @Autowired
    IUsuarioRepository repositorio;

    public UsuarioService(BaseRepository<Usuarios, Long> repository, IUsuarioRepository repositorio) {
        super(repository);
        this.repositorio = repositorio;
    }


    public List<Usuarios> SearchUsuariobyemail(String email) throws Exception {
        try {

            return repositorio.findByemail(email);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public Logueo isLogged(UsuarioDto usuariolog) throws Exception {

        try {

            String username = usuariolog.getUsername();
            String pass = usuariolog.getPass();
            List<Usuarios> users = repositorio.findByusername(username);

            for (Usuarios usuario : users) {
                if (usuario.getUsername().equals(username) && usuario.getPass().equals(pass)) {
                    return new Logueo(usuario.getId());
                }

            }

            return new Logueo(0L);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }


}
