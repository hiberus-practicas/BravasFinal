package web.practicas.demo.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.practicas.demo.model.base.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
@NoArgsConstructor

public class Proyecto extends Base implements Serializable {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "equipo")
    private String equipo;



    public Proyecto(String nombre, String equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;

    }


}
