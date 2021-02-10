package com.police.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.consultarDao;
import com.police.datos.modificarDao;

@Named("modif")
@RequestScoped
public class modificarBean {
	private static String cedula;
	private static String apellido;
	private static String celular;
	private static String correo;
	private static String nombre;
	private static String clave;
	
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
	

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		modificarBean.clave = clave;
	}

	public String consultarDatosRegistrado() {
		String confirm = "";
		try {
			consultarDao conexion = new consultarDao();
			conexion.consultarRegistrado(cedula);
			confirm = "consultar";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"El Usuario ingresado no existe");
			PrimeFaces.current().dialog().showMessageDynamic(message);
			confirm = "error";
		}

		return confirm;
	}

	public void modificarDatosRegistrado() {

		try {
			modificarDao conexion = new modificarDao();
			conexion.modificarDatosRegistrado(cedula, nombre, apellido, correo, celular);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
					"Usuario Modificado con éxito");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
					"Ha ocurrido un error en la actualización de datos, vuelva a intentarlo");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		}

	}
	
	
	
	
	public String limpiarDatos() {
		cedula ="";
		apellido ="";
		celular="";
		correo="";
		nombre="";
		return "consultar";
	}

}
