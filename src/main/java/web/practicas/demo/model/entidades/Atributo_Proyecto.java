package web.practicas.demo.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "atributo_proyectos")
@Getter
@Setter
@NoArgsConstructor
@Embeddable

public class Atributo_Proyecto implements Serializable {
    @Column(name = "value_numero")
    Integer valuenumero;
    @Column(name = "value_string")
    String valueString;
    @Column(name = "value_fecha")
    Date valueFecha;

    @EmbeddedId
    private Key mykey;


    public Atributo_Proyecto(Key key,Integer valuenumero, String valueString, Date valueFecha) {
        this.valuenumero = valuenumero;
        this.valueString = valueString;
        this.valueFecha = valueFecha;
        this.mykey=key;

    }



}

