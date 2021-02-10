package com.police.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.PrimeFaces;

import com.police.datos.consultarDao;
import com.police.datos.eliminarDao;
import com.police.modelo.Auditoria;
import com.police.modelo.DimCrimVict;
import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

@Named("login")
@RequestScoped
public class usuarioBean {
	private static String cedula;

	private static String clave;

	private String tipo;

	private String usuario;
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
	EntityManager em = entityManagerFactory.createEntityManager();
	Query q = em.createNativeQuery("select * from usuarios where tipo !='administrador' order by cedula;", Usuario.class);
	
	List<Usuario> lista_usuarios = (List<Usuario>) q.getResultList();
	
	
	

	public List<Usuario> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(List<Usuario> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public static String consultarUsuario()
	{
		String confirm="";
		consultarDao conexion = new consultarDao();
		confirm= conexion.consultarUsuario(cedula,clave);  
		return confirm;
	}
	public static String nombreUsuario()
	{
		String confirm="";
		consultarDao conexion = new consultarDao();
		confirm= conexion.nombreUsuario(cedula); 
		return confirm;
	}
	
}
