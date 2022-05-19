package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aventura database table.
 * 
 */
@Entity
@NamedQuery(name="Aventura.findAll", query="SELECT a FROM Aventura a")
public class Aventura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codAventura;

	private String descripcion;

	private String dificultad;

	private String nombre;

	//bi-directional many-to-one association to Enemigosenaventura
	@OneToMany(mappedBy="aventura")
	private List<Enemigosenaventura> enemigosenaventuras;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="aventura")
	private List<Personaje> personajes;

	public Aventura() {
	}

	public int getCodAventura() {
		return this.codAventura;
	}

	public void setCodAventura(int codAventura) {
		this.codAventura = codAventura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Enemigosenaventura> getEnemigosenaventuras() {
		return this.enemigosenaventuras;
	}

	public void setEnemigosenaventuras(List<Enemigosenaventura> enemigosenaventuras) {
		this.enemigosenaventuras = enemigosenaventuras;
	}

	public Enemigosenaventura addEnemigosenaventura(Enemigosenaventura enemigosenaventura) {
		getEnemigosenaventuras().add(enemigosenaventura);
		enemigosenaventura.setAventura(this);

		return enemigosenaventura;
	}

	public Enemigosenaventura removeEnemigosenaventura(Enemigosenaventura enemigosenaventura) {
		getEnemigosenaventuras().remove(enemigosenaventura);
		enemigosenaventura.setAventura(null);

		return enemigosenaventura;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje addPersonaje(Personaje personaje) {
		getPersonajes().add(personaje);
		personaje.setAventura(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setAventura(null);

		return personaje;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aventura [codAventura=");
		builder.append(codAventura);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", dificultad=");
		builder.append(dificultad);
		builder.append("]");
		return builder.toString();
	}

}