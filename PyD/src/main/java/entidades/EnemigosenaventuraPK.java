package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the enemigosenaventuras database table.
 * 
 */
@Embeddable
public class EnemigosenaventuraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int codEnemigo;

	@Column(insertable=false, updatable=false)
	private int codAventura;

	public EnemigosenaventuraPK() {
	}
	public int getCodEnemigo() {
		return this.codEnemigo;
	}
	public void setCodEnemigo(int codEnemigo) {
		this.codEnemigo = codEnemigo;
	}
	public int getCodAventura() {
		return this.codAventura;
	}
	public void setCodAventura(int codAventura) {
		this.codAventura = codAventura;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnemigosenaventuraPK)) {
			return false;
		}
		EnemigosenaventuraPK castOther = (EnemigosenaventuraPK)other;
		return 
			(this.codEnemigo == castOther.codEnemigo)
			&& (this.codAventura == castOther.codAventura);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codEnemigo;
		hash = hash * prime + this.codAventura;
		
		return hash;
	}
}