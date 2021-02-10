package com.police.beans;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.police.datos.eliminarDao;
@Named("userdel")
@RequestScoped
public class UserDelBean 
{
	private  String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	//LLAMA A LOS METODOS DAO DE ELIMINAR USUARIOS
	public void eliminarUsuario()
	{
		try {
			eliminarDao conexion = new eliminarDao();
			conexion.eliminarUsuario(cedula);
			conexion.EliminarRegistrado(cedula);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario eliminado con éxito");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario ingresado no existe");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		}
		
	}
}
