package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import controladores.ControladorAventura;
import entidades.Aventura;


public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pyd");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Aventura av = new Aventura();
		av.setCodAventura(15);
		av.setNombre("la nueva");
		av.setDescripcion("sin descripcion");
		av.setDificultad("por definir");
		
		ControladorAventura CA = new ControladorAventura();
		CA.crearAventura(av);
		
		Query q = em.createNamedQuery("Aventura.findAll");
		
		List<Aventura> listaAventuras = (List<Aventura>) q.getResultList();
		
		for (Aventura aventura : listaAventuras) {
			System.out.println(aventura.toString());
		}
		
		em.close();

	}

}
