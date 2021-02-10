package com.police.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.consultarDao;
import com.police.datos.modificarDao;

@Named("reg")
@RequestScoped
public class actualizarRegistradoBean 
{
	private static String correo;
	private static String clave;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void actualizarDatosCuentaRegistrado() {

		try {
			modificarDao conexion = new modificarDao();
			conexion.actualizarDatosRegistrado(correo, clave);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
					"Datos actualizados con éxito");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
					"Ha ocurrido un error en la actualización de datos, vuelva a intentarlo");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		}

	}
	public String consultarDatosCuentaRegistrado() { 
		String confirm = ""; 
		try {
		  consultarDao conexion = new consultarDao();
		  conexion.consultarDatosCuentaRegistrado();
		  confirm = "consultarCuentaRegistrado"; 
		  } catch  (Exception e) 
		{ 
		  FacesMessage message = new
		  FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
		  "El Usuario ingresado no existe");
		  PrimeFaces.current().dialog().showMessageDynamic(message); 
		  confirm = "error";
		  }
		  
		  return confirm; 
		  }

	
}
