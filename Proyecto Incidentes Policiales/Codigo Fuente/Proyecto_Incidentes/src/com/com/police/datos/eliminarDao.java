package com.police.datos;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

public class eliminarDao {

	public void eliminarUsuario (String cedula) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u where u.cedula ="+cedula+"", Usuario.class);
		
		List<Usuario> usuarios = q.getResultList();
		
		em.getTransaction().begin();
		for (Usuario usu : usuarios) {
			em.remove(usu);
		}
		em.getTransaction().commit();
		em.close();
	}
	public  void EliminarRegistrado (String cedula) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula = "+cedula+"", Registrado.class);
		
		List<Registrado> usuarios = q.getResultList();
		
		em.getTransaction().begin();
		for (Registrado usu : usuarios) {
			em.remove(usu);
		}
		em.getTransaction().commit();
		
		
		em.close();
	}
}
