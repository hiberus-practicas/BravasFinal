package web.practicas.demo.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atributos")
public class Atributo implements Serializable {
    @Id
    @Column(name = "nombre_Atributo")
    private String NombreAtributo;
    @Column(name = "tipo_Dato")
    private String tipoDato;
    @Column(name = "descripcion")
    private String descripcion;



}
