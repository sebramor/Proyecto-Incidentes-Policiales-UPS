package com.police.datos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

public class modificarDao 
{
	public void modificarDatosRegistrado (String cedula, String nombre , String apellido , String correo ,String celular) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula = "+cedula+"", Registrado.class);
		
		List<Registrado> registrado = q.getResultList();
		
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setCorreo(correo);
			user.setCelular(celular);
			em.persist(user);
		}
		em.getTransaction().commit();
		
		em.close();
	}
	public void actualizarDatosRegistrado (String correo, String clave) {
		System.out.println("Correo: " + correo); 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.correo = '"+correo+"'", Registrado.class);
		List<Registrado> registrado = q.getResultList();
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			TypedQuery<Usuario> u = em.createQuery("SELECT u FROM Usuario u where u.cedula = '"+user.getCedula()+"'", Usuario.class);
			List<Usuario> login = u.getResultList();
			for (Usuario log : login) {
				log.setClave(clave);
				user.setCorreo(correo);
				em.persist(user);
			}
			user.setCorreo(correo);
			user.setClave(clave);
			em.persist(user);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void modificarDatosAdministrador (String nombre, String apellido, String ciudad, Integer edad,String celular, String correo, String clave) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula = '1727418822'", Registrado.class);
		
		List<Registrado> registrado = q.getResultList();
		
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setCiudad(ciudad);
			user.setEdad(edad);
			user.setCelular(celular);
			user.setCorreo(correo);
			user.setClave(clave);
			em.persist(user);
		}
		em.getTransaction().commit();
		
		em.close();
	}

}
