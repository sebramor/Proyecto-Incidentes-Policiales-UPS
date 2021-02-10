package com.police.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.modificarDao;

@Named("act")
@RequestScoped
public class actualizarAdminBean 
{
	private static String cedula;
	private static String apellido;
	private static String celular;
	private static String correo;
	private static String nombre;
	private static String ciudad;
	private static Integer edad;
	private static String clave;

	
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


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public void modificarDatosAdministrador() 
	  { 
	  modificarDao conexion = new modificarDao(); 
	  conexion.modificarDatosAdministrador(nombre, apellido, ciudad, edad, celular, correo, clave);
	  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Datos actualizados correctamente");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	  }
	
}
