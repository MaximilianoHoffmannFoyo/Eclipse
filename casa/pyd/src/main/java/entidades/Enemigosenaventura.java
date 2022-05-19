package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enemigosenaventuras database table.
 * 
 */
@Entity
@Table(name="enemigosenaventuras")
@NamedQuery(name="Enemigosenaventura.findAll", query="SELECT e FROM Enemigosenaventura e")
public class Enemigosenaventura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnemigosenaventuraPK id;

	private int numeroEnemigos;

	//bi-directional many-to-one association to Aventura
	@ManyToOne
	@JoinColumn(name="codAventura")
	private Aventura aventura;

	//bi-directional many-to-one association to Enemigo
	@ManyToOne
	@JoinColumn(name="codEnemigo")
	private Enemigo enemigo;

	public Enemigosenaventura() {
	}

	public EnemigosenaventuraPK getId() {
		return this.id;
	}

	public void setId(EnemigosenaventuraPK id) {
		this.id = id;
	}

	public int getNumeroEnemigos() {
		return this.numeroEnemigos;
	}

	public void setNumeroEnemigos(int numeroEnemigos) {
		this.numeroEnemigos = numeroEnemigos;
	}

	public Aventura getAventura() {
		return this.aventura;
	}

	public void setAventura(Aventura aventura) {
		this.aventura = aventura;
	}

	public Enemigo getEnemigo() {
		return this.enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

}