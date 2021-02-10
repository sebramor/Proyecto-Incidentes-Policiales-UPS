package com.police.datos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.police.beans.usuarioBean;
import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

public class modificarDao 
{
	// ACTUALIZAR DESDE EL ADMINISTRADOR LOS DATOS DEL USUARIO REGISTRADO
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
	//ACTUALIZACION DE DATOS EN CUENTA REGISTRADO
		public static void actualizarDatosRegistrado (String correo, String clave) {
			usuarioBean user1=new usuarioBean();
			System.out.println("cedula: "+user1.getCedula());
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
			EntityManager em = entityManagerFactory.createEntityManager();
			TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula ='"+user1.getCedula()+"'", Registrado.class);
			List<Registrado> registrado = q.getResultList();
			em.getTransaction().begin();
			// Usamos 2 for para modificar la clave , correo del usuario registrado tanto de sus datos como del inicio de sesión (Registrado / Login)
			for (Registrado user : registrado) {
				TypedQuery<Usuario> u = em.createQuery("SELECT u FROM Usuario u where u.cedula = '"+user.getCedula()+"'", Usuario.class);
				List<Usuario> login = u.getResultList();
				TypedQuery<Registrado> q1 = em.createQuery("SELECT r FROM Registrado r where r.correo = '"+user.getCedula()+"'", Registrado.class);
				List<Registrado> registrados = q1.getResultList();
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
	
		//ACTUALIZACIÓN DE DATOS EN CUENTA ADMINISTRADOR
	public void modificarDatosAdministrador (String nombre, String apellido, String ciudad, Integer edad,String celular, String correo, String clave) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		// Selecciona la tabla registrado donde la cédula sea igual al administrador que por defecto estaría quemado al sistema
		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula = '1727418822'", Registrado.class);
		
		//Lista de el resultado del Query o consulta
		List<Registrado> registrado = q.getResultList();
		
		em.getTransaction().begin();
		//Recorre la List de clase registrado con sus datos existentes en la base POLICIA_DIMENSIONAL
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
