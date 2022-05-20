package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Aventura;

public class ControladorAventura {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pyd");
	private EntityManager em;
	private Query consulta;

	public void borrarAventura(Aventura c) {
		this.em = entityManagerFactory.createEntityManager();
		Aventura aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarAventura(Aventura c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearAventura(Aventura c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Aventura findByCodAventura(int codAventura) {
		this.em = entityManagerFactory.createEntityManager();
		Aventura aux = null;
		this.consulta = em.createNativeQuery("Select * from Aventura where codAventura = ?", Aventura.class);
		this.consulta.setParameter(1, codAventura);
		try {
			aux = (Aventura) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}
	
	public Aventura findByNombre(String nombre) {
		this.em = entityManagerFactory.createEntityManager();
		Aventura aux = null;
		this.consulta = em.createNativeQuery("Select * from Aventura where nombre = ?", Aventura.class);
		this.consulta.setParameter(1, nombre);
		try {
			aux = (Aventura) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}

	public List<Aventura> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Aventura.findAll");
		List<Aventura> lista = (List<Aventura>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
