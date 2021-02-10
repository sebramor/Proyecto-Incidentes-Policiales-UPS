package com.police.datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

public class creacionDao
{

	//Creacion de Usuario + em.persist  + parámetros de usuario clave y tipo
	// em.persist = hace que se inserte un registro en la tabla Usuario y a la vez pasa el objeto a estar bajo el control del EntityManager.
	// para realizar la conexión a la base de datos
	public void creacionUsuario(String cedula, String usuario, String clave, String tipo)
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();

		Usuario user = new Usuario();
		user.setCedula(cedula);
		user.setUsuario(usuario);
		user.setClave(clave);
		user.setTipo(tipo);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

		List<Usuario> usuarios = q.getResultList();

		for (Usuario lista_usuarios : usuarios) {
			System.out.println("Funcionando: " + lista_usuarios.getClave());
		}
		em.close();
	}
	//Creacion de Registrado
	public void creacionRegistrado(String cedula, String nombre, String apellido , String ciudad , Integer edad , String celular, String correo , String clave)
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();

		Registrado user = new Registrado();
		user.setCedula(cedula);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setCiudad(ciudad);
		user.setEdad(edad);
		user.setCelular(celular);
		user.setCorreo(correo);
		user.setClave(clave);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r", Registrado.class);

		List<Registrado> usuarios = q.getResultList();

		for (Registrado lista_usuarios : usuarios) {
			System.out.println("Funcionando: " + lista_usuarios.getClave());
		}
		em.close();
	}

}
