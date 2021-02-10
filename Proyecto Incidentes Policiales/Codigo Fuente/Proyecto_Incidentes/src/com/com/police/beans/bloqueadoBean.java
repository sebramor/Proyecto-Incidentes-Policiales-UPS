package com.police.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.bloquearDao;

@Named("bloqueado")
@RequestScoped
public class bloqueadoBean {
	private static String cedula;
	private static String nombre;

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
	
	//Bloque de Usuario 
		public void bloquearUsuario()
		{
			try {
				bloquearDao conexion = new bloquearDao();
				conexion.consultarRegitrado(cedula,nombre);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario "+nombre+" Bloqueado con exito");
				PrimeFaces.current().dialog().showMessageDynamic(message);

			} catch (Exception e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario ya se encuentra bloqueado");
				PrimeFaces.current().dialog().showMessageDynamic(message);

			}
		
		}
	
}
