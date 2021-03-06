package com.police.datos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.primefaces.PrimeFaces;

import com.police.beans.AuditoriaBean;
import com.police.beans.actualizarAdminBean;
import com.police.beans.actualizarRegistradoBean;
import com.police.beans.consultarBean;
import com.police.beans.modificarBean;
import com.police.beans.registradoBean;
import com.police.beans.usuarioBean;
import com.police.modelo.Auditoria;
import com.police.modelo.DimCrimVict;
import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

@ManagedBean
@RequestScoped
public class consultarDao 
{

	private ArrayList<DimCrimVict> listavictima = new ArrayList<>();
	public void consultarDatosVictima() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Usuario user = new Usuario();
		Query q = em.createNativeQuery("SELECT * FROM usuarios;", Usuario.class);
		
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("C�dula: " + usuario.getCedula() + " tipo: " + usuario.getTipo());
		}
		
		em.close();
	}
	
//Comprobar datos de Inicio de Sesi�n
	public String consultarUsuario(String cedula, String clave)
	{
		String confirm = "";
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Usuario user = (Usuario) em.find(Usuario.class, cedula);
			if (clave.equals(user.getClave())) {
				if(user.getTipo().equals("administrador"))
				{
					confirm = "admin";
				}else {
					if(user.getTipo().equals("registrado"))
					{
						confirm = "registrado";
					} else
					{
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario se encuentra bloqueado"); 
				        PrimeFaces.current().dialog().showMessageDynamic(message);
					}
				}
			}else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validaci�n", "Clave Incorrecta"); 
		        PrimeFaces.current().dialog().showMessageDynamic(message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validaci�n", "El usuario ingresado no existe"); 
	        PrimeFaces.current().dialog().showMessageDynamic(message);
		}
			
		em.close();
		return confirm;		
	}
	
	public String nombreUsuario(String cedula) 
	{
		String nombre= "";
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		Registrado user = (Registrado) em.find(Registrado.class, cedula);
		return  user.getNombre() + " " + user.getApellido();
		
	}
	
	public static void ListadoVictimas() 
	{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		DimCrimVict user = new DimCrimVict();
		Query q = em.createNativeQuery("SELECT * FROM dim_crim_vict;", DimCrimVict.class);
		
		List<DimCrimVict> usuarios = (List<DimCrimVict>) q.getResultList();
		em.close();
		
	}
	public String consultarRegistrado(String cedula)
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
			Registrado user = (Registrado) em.find(Registrado.class, cedula);
			System.out.println("Tipo de usuario: " + user.getApellido());
			modificarBean mod = new modificarBean();
			mod.setNombre(user.getNombre());
			mod.setApellido(user.getApellido());
			mod.setCelular(user.getCelular());
			mod.setCorreo(user.getCorreo());
		em.close();
		return "consultar";
	}
	public String consultarDatosCuentaRegistrado()
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		usuarioBean log = new usuarioBean();
		EntityManager em = entityManagerFactory.createEntityManager();
			Registrado user = (Registrado) em.find(Registrado.class, log.getCedula());
			actualizarRegistradoBean mod = new actualizarRegistradoBean();
			mod.setCorreo(user.getCorreo());
			mod.setClave(user.getClave());
		em.close();
		return "consultar";
	}
	public String consultarDatosRegistrado(String cedula)
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
			Registrado user = (Registrado) em.find(Registrado.class, cedula);
			System.out.println("Tipo de usuario: " + user.getApellido());
			consultarBean mod = new consultarBean();
			mod.setNombre(user.getNombre());
			mod.setApellido(user.getApellido());
			mod.setCelular(user.getCelular());
			mod.setCorreo(user.getCorreo());
		em.close();
		return "consultarRegistrado";
	}
	public String consultarDatosAdministrador()
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
			Registrado user = (Registrado) em.find(Registrado.class, "1727418822");
			System.out.println("Tipo de usuario: " + user.getApellido());
			actualizarAdminBean mod = new actualizarAdminBean();
			mod.setNombre(user.getNombre());
			mod.setApellido(user.getApellido());
			mod.setCiudad(user.getCiudad());
			mod.setEdad(user.getEdad());
			mod.setCelular(user.getCelular());
			mod.setCorreo(user.getCorreo());
			mod.setClave(user.getClave());
		em.close();
		return "consultarAdministrador";
	}

	public void consultarAuditoria() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
	
		Query q = em.createNativeQuery("SELECT * from auditoria.auditoria;", Auditoria.class);
		
		List<Auditoria> aud = (List<Auditoria>) q.getResultList();
		em.close();
	}
	
	
	  
	 
	
	
}
