package web.practicas.demo.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Key implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nombre_atributo")
    private Atributo atributo;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
}