package com.police.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.consultarDao;

@Named("consult")
@RequestScoped
public class consultarBean
{
	private static String cedula;
	private static String apellido;
	private static String celular;
	private static String correo;
	private static String nombre;

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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String consultarDatosRegistrado() {
		String confirm = "";
		try {
			consultarDao conexion = new consultarDao();
			conexion.consultarDatosRegistrado(cedula);
			confirm = "consultarRegistrado";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"El Usuario ingresado no existe");
			PrimeFaces.current().dialog().showMessageDynamic(message);
			confirm = "error";
		}

		return confirm;
	}
	
	public String consultarDatosAdministrador() {
			consultarDao conexion = new consultarDao();
			conexion.consultarDatosAdministrador();
		return "consultarAdministrador";
	}

	public String limpiarDatos() {
		cedula ="";
		apellido ="";
		celular="";
		correo="";
		nombre="";
		return "consultarRegistrado";
	}
}
