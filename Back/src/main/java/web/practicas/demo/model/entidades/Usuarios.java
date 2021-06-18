package web.practicas.demo.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.practicas.demo.model.base.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios extends Base {

    @Column(name = "email", unique = true)
    String email;
    @Column(name = "username", unique = true)
    String username;
    @Column(name = "password")
    String pass;


}
