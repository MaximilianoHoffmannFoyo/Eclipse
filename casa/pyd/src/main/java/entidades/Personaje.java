package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personajes database table.
 * 
 */
@Entity
@Table(name="personajes")
@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p")
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codJugador;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Aventura
	@ManyToOne
	@JoinColumn(name="codAventura")
	private Aventura aventura;

	public Personaje() {
	}

	public int getCodJugador() {
		return this.codJugador;
	}

	public void setCodJugador(int codJugador) {
		this.codJugador = codJugador;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Aventura getAventura() {
		return this.aventura;
	}

	public void setAventura(Aventura aventura) {
		this.aventura = aventura;
	}

	@Override
	public String toString() {
		return "Personaje [codJugador=" + codJugador + ", nivel=" + nivel + ", nombre=" + nombre + ", aventura="
				+ aventura + "]";
	}

}