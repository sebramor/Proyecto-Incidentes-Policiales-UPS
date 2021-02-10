package com.police.datos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.police.beans.bloqueadoBean;
import com.police.modelo.Usuario;

@ManagedBean
@RequestScoped
public class bloquearDao {

	//Busca si es usuario regitrado
	public  void consultarRegitrado(String cedula, String nombre)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Usuario  user= new Usuario();
		Query q = em.createNativeQuery("select * from usuarios where cedula= '"+cedula+"' and tipo = 'registrado';", Usuario.class);
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
				
		TypedQuery<Usuario> q1 = em.createQuery("SELECT u FROM Usuario u where u.cedula = '"+cedula+"' and u.tipo = 'registrado'", Usuario.class);
		
		List<Usuario> usuario = q1.getResultList();
		
		em.getTransaction().begin();
		for (Usuario usuario1 : usuarios) {
			usuario1.setTipo("registrado-bloqueado");
			em.persist(usuario1);
		}
		em.getTransaction().commit();
		
		for (Usuario usuario1 : usuarios) {
			System.out.println("Bloqueaste el usuario: "+usuario1.getUsuario());
			System.out.println("Estos son los registrados");
			System.out.println("Cédula: " + usuario1.getCedula() + " tipo: " + usuario1.getTipo());
			bloqueadoBean nom= new bloqueadoBean();
			nom.setNombre(usuario1.getUsuario());
		}
		
		em.close();
		
	}
	/*
	 * public String Resetear(String clean) { clean = " "; return this.clean=clean;
	 * }
	 */
	
}

