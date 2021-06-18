package deprecated;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import web.practicas.demo.model.entidades.Atributo;
import web.practicas.demo.model.base.Base;


 
public class ProyectoAtributo extends Base{

	
	@OneToOne
	Atributo fkatributo;
	@Column(name="valor_entero")
	Integer valorEntero;
	@Column(name="valor_string")
	String valorString;
	@Column(name="valor_fecha")
	Date valorFecha;

	public ProyectoAtributo( Atributo fkatributo, Integer valorEntero, String valorString,
			Date valorFecha) {
		super();
		
		this.fkatributo = fkatributo;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorFecha = valorFecha;
	}

	public Atributo getFkatributo() {
		return fkatributo;
	}
	public void setFkatributo(Atributo fkatributo) {
		this.fkatributo = fkatributo;
	}
	public Integer getValorEntero() {
		return valorEntero;
	}
	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}
	public String getValorString() {
		return valorString;
	}
	public void setValorString(String valorString) {
		this.valorString = valorString;
	}
	public Date getValorFecha() {
		return valorFecha;
	}
	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}

	


}
