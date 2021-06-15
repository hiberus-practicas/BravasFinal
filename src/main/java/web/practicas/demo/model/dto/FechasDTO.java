package web.practicas.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FechasDTO {
    String limiteinferior;
    String limitesuperior;
    String nombreatributo;
}
