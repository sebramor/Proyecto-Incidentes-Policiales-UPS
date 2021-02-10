package com.police.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.PrimeFaces;

import com.police.datos.consultarDao;
import com.police.datos.creacionDao;
import com.police.modelo.Registrado;
import com.police.modelo.Usuario;
@Named("registrado")
@RequestScoped
public class registradoBean {
	private String cedula;

	private String apellido;

	private String celular;

	private String ciudad;

	private String clave;

	private String correo;

	private Integer edad;

	private String nombre;
	
	
	// RETORNA LA LISTA DE TODOS LOS USUARIOS REGISTRADO EN EL DATATABLE DE ADMINISTRADOR NO TOMANDO EN CUENTA AL ADMIN
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
	EntityManager em = entityManagerFactory.createEntityManager();
	Query q = em.createNativeQuery("select * from registrado where cedula !='1727418822' order by cedula;", Registrado.class);
	
	List<Registrado> lista_registrados = (List<Registrado>) q.getResultList();
	
	
	public List<Registrado> getLista_registrados() {
		return lista_registrados;
	}
	public void setLista_registrados(List<Registrado> lista_registrados) {
		this.lista_registrados = lista_registrados;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//CREACION DE NUEVO USUARIO
	public void registrarUsuario()
	{
		try {
			creacionDao conexion = new creacionDao();
			conexion.creacionUsuario(cedula,nombre + " " + apellido,clave,"registrado");
			conexion.creacionRegistrado(cedula,nombre,apellido,ciudad,edad,celular,correo,clave);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Registrado con éxito");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario ya se encuentra registrado");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		}
	}


}
