package web.practicas.demo.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import web.practicas.demo.model.base.Base;
import web.practicas.demo.repository.base.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImplementation<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    @Autowired
    BaseRepository<E, ID> repository;

	public BaseServiceImplementation(BaseRepository<E, ID> repository) {
		this.repository = repository;
	}

	public List<E> listall() throws Exception {

        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Optional<E> listbyid(ID id) throws Exception {

        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    public E add(E entidad) throws Exception {

        try {
            return repository.save(entidad);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    public E update(ID id, E entidad) throws Exception {

        try {
            if (id == entidad.getId())
                return repository.save(entidad);
            else {
                return entidad;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    public E delete(ID id) throws Exception {

        try {
            E entity = repository.findById(id).get();
            repository.deleteById(id);
            return entity;


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
