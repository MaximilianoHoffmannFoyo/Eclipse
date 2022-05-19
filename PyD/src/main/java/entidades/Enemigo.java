package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enemigos database table.
 * 
 */
@Entity
@Table(name="enemigos")
@NamedQuery(name="Enemigo.findAll", query="SELECT e FROM Enemigo e")
public class Enemigo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEnemigo;

	private int experiencia;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Enemigosenaventura
	@OneToMany(mappedBy="enemigo")
	private List<Enemigosenaventura> enemigosenaventuras;

	public Enemigo() {
	}

	public int getCodEnemigo() {
		return this.codEnemigo;
	}

	public void setCodEnemigo(int codEnemigo) {
		this.codEnemigo = codEnemigo;
	}

	public int getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
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

	public List<Enemigosenaventura> getEnemigosenaventuras() {
		return this.enemigosenaventuras;
	}

	public void setEnemigosenaventuras(List<Enemigosenaventura> enemigosenaventuras) {
		this.enemigosenaventuras = enemigosenaventuras;
	}

	public Enemigosenaventura addEnemigosenaventura(Enemigosenaventura enemigosenaventura) {
		getEnemigosenaventuras().add(enemigosenaventura);
		enemigosenaventura.setEnemigo(this);

		return enemigosenaventura;
	}

	public Enemigosenaventura removeEnemigosenaventura(Enemigosenaventura enemigosenaventura) {
		getEnemigosenaventuras().remove(enemigosenaventura);
		enemigosenaventura.setEnemigo(null);

		return enemigosenaventura;
	}

}