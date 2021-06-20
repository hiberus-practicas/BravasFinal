package web.practicas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.practicas.demo.model.entidades.Usuarios;
import web.practicas.demo.model.dto.Logueo;
import web.practicas.demo.model.dto.UsuarioDto;
import web.practicas.demo.repository.base.BaseRepository;
import web.practicas.demo.repository.IUsuarioRepository;
import web.practicas.demo.service.base.BaseServiceImplementation;

import java.util.HashMap;
import java.util.List;

@Service

public class UsuarioService extends BaseServiceImplementation<Usuarios, Long> {
    @Autowired
    IUsuarioRepository repositorio;

    private HashMap <Long,Boolean>session=new HashMap<>();

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

    public Long isLogged(UsuarioDto usuariolog) throws Exception {

        try {

            String username = usuariolog.getUsername();
            String pass = usuariolog.getPass();
            List<Usuarios> users = repositorio.findByemail(username);
            System.out.println("entra y busca usuarios");

            for (Usuarios usuario : users) {
                System.out.println("compara");

                if (usuario.getEmail().equals(username) && usuario.getPass().equals(pass)) {
                    System.out.println("eencuentra");

                    session.put(usuario.getId(),true);
                    System.out.println("sesion");


                    return usuario.getId();
                }

            }

            return 0l;

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }
    public boolean session(long id) throws Exception{
        try{
            if(this.session.containsKey(id)){return this.session.get(id);}
            return false;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
