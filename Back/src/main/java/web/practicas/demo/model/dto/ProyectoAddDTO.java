package web.practicas.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.practicas.demo.model.entidades.Atributo;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProyectoAddDTO {

    private String nombre;
    private String Equipo;
    List<ProyectoAtributoDTO>atributos;
}
