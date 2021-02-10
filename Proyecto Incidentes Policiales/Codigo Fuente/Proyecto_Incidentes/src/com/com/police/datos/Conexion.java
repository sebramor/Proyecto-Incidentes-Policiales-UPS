package com.police.datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.PrimeFaces;

import javax.persistence.Query;

import com.police.beans.AuditoriaBean;
import com.police.modelo.Auditoria;
import com.police.modelo.DimCrimVict;
import com.police.modelo.DimIncidenteLlamada;
import com.police.modelo.Registrado;
import com.police.modelo.Usuario;

@Named("conexion")
@RequestScoped
public class Conexion implements Serializable {
	public Conexion() {
	}

	private static final long serialVersionUID = 1L;
	private String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	private static String apellido;
	private String celular;
	private String ciudad;
	private String clave;
	private String correo;
	private Integer edad;
	private String nombre = "Michael";
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public static String consultarDatosVictima()
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		DimCrimVict user = (DimCrimVict) em.find(DimCrimVict.class, 14);
		System.out.println("Tipo de usuario: " + user.getNombreVictima());
		em.close();
		return user.getNombreVictima();
	}
	public static String consultarUsuario()
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Usuario user = (Usuario) em.find(Usuario.class, "1727418820");
			System.out.println("Tipo de usuario: " + user.getUsuario());
		} catch (Exception e) {
			System.out.println("El usuario no existe");
		}
			
		em.close();
		return "";
	}

	public static void creacionUsuario()
	{
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();

		Usuario user = new Usuario();
		user.setCedula("1704521697");
		user.setUsuario("Paul Morales");
		user.setClave("17849a");
		user.setTipo("Registrado");
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

		List<Usuario> usuarios = q.getResultList();

		for (Usuario lista_usuarios : usuarios) {
			System.out.println("Clave: " + lista_usuarios.getClave() + " Usuarios: " + lista_usuarios.getUsuario()
					+ " Tipo: " + lista_usuarios.getTipo());
		}
		em.close();
	}
	public void listadoUsuarios() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Usuario user = new Usuario();
		Query q = em.createNativeQuery("SELECT * FROM usuarios;", Usuario.class);
		
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("Cédula: " + usuario.getCedula() + " tipo: " + usuario.getTipo());
		}
		
		em.close();
	}
	
	public static void listadoCuant() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		DimIncidenteLlamada user = new DimIncidenteLlamada();
		
			Query q = em.createNativeQuery("SELECT * from dim_incidente_llamadas limit 7 where sk_fecha ='20180102';", DimIncidenteLlamada.class);
			
			List<DimIncidenteLlamada> usuarios = (List<DimIncidenteLlamada>) q.getResultList();
			
			for (DimIncidenteLlamada usuario : usuarios) {
				System.out.println("Num_Incidente: " + usuario.getSkIncidentes());
				System.out.println("Tipo_Incidente:" + usuario.getTipoIncidente() );
			}
		em.close();
	}
	
	private static void ListadoVictimas() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		DimCrimVict user = new DimCrimVict();
		Query q = em.createNativeQuery("SELECT * FROM dim_crim_vict;", DimCrimVict.class);
		
		List<DimCrimVict> usuarios = (List<DimCrimVict>) q.getResultList();
		
		for (DimCrimVict usuario : usuarios) {
			try {
				if(usuario.getGeneroVictima().equals("MALE")) {
					System.out.println("Nombre: " + usuario.getNombreVictima() + "Genero : " + usuario.getGeneroVictima());
				}
			} catch (Exception e) {
				System.out.println("nulo");
			}
			
			
		}
		
		em.close();
	}
	
	public static void modificarDatosAdministrador () {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.cedula = 1727418822", Registrado.class);
		
		List<Registrado> registrado = q.getResultList();
		
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			user.setNombre("Mike");
			user.setApellido("Robles");
			user.setCiudad("Quito");
			user.setEdad(23);
			user.setCelular("0981254");
			user.setCorreo("mro@asd.com");
			user.setClave("1520");
			em.persist(user);
		}
		em.getTransaction().commit();
		
		em.close();
	}
	public static void consultarAuditoria() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Auditoria au = new Auditoria();
		Query q = em.createNativeQuery("SELECT * from auditoria.auditoria;", Auditoria.class);
		
		List<Auditoria> aud = (List<Auditoria>) q.getResultList();
		
		for (Auditoria auditoria : aud) {
			System.out.println("Auditar: " + auditoria.getEsquemaAud()  );
		}
		
		em.close();
	}
	/*
	 * public static String obtencionRegistrado() { EntityManagerFactory
	 * entityManagerFactory =
	 * Persistence.createEntityManagerFactory("Prueba_Policia"); EntityManager em =
	 * entityManagerFactory.createEntityManager(); Registrado reg = (Registrado)
	 * em.find(Registrado.class, "1727418822");
	 * System.out.println("Usuario localizado -> " + reg.getNombre()); em.close();
	 * return reg.getNombre(); }
	 * 
	 * public String registrar() { Registrado nuevaPersona = new Registrado();
	 * 
	 * nuevaPersona.setNombre(nombre); ; nuevaPersona.setEdad(edad);
	 * nuevaPersona.setCiudad(ciudad); nuevaPersona.setCorreo(correo);
	 * nuevaPersona.setClave(clave); return "registrado"; }
	 * 
	 * public void prueba() { System.out.println("FUNCIONA"); }
	 */

	public static void consultarDatosAuditoria() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Auditoria au = new Auditoria();
		Query q = em.createNativeQuery("SELECT a.id_aud,\r\n"
				+ "    (SELECT COUNT(*) FROM auditoria.auditoria WHERE operacion_aud = 'UPDATE') as Actualizados,\r\n"
				+ "    (SELECT COUNT(*) FROM auditoria.auditoria WHERE operacion_aud = 'DELETE') as Eliminados,\r\n"
				+ "    (SELECT COUNT(*) FROM auditoria.auditoria WHERE operacion_aud = 'INSERT') as Agregados\r\n"
				+ "FROM (SELECT DISTINCT id_aud FROM auditoria.auditoria) a;;", Auditoria.class);
		
		List<Auditoria> aud = (List<Auditoria>) q.getResultList();
		
		for (Auditoria auditoria : aud) {
			System.out.println("Auditar: " + auditoria.getOperacionAud()  );
		}
		
		em.close();
	}
	public static void consultarCuantitativosAuditoria() 
	{
		int actualizados=0, eliminados=0, agregados=0;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
	
		Query q = em.createNativeQuery("SELECT * from auditoria.auditoria;", Auditoria.class);
		List<Auditoria> aud = (List<Auditoria>) q.getResultList();
		
		for (Auditoria auditoria : aud) {
			try {
				if(auditoria.getOperacionAud().equals("UPDATE")) {
					actualizados++;	
				}	
				if(auditoria.getOperacionAud().equals("DELETE")) {
					eliminados++;	
				}	
				if(auditoria.getOperacionAud().equals("INSERT")) {
					agregados++;	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
				
		}
		System.out.println(actualizados);
		System.out.println(eliminados);
		System.out.println(agregados);
	}
	public static void probando() {
		if(apellido!=null) {
			System.out.println("nulo");
		}else {
			System.out.println("no nulo");
		}
	}
	
	public static void modificarDatosRegistrado () {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.correo = 'none@none.com'", Registrado.class);
		List<Registrado> registrado = q.getResultList();
		
		
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			TypedQuery<Usuario> u = em.createQuery("SELECT u FROM Usuario u where u.cedula = '"+user.getCedula()+"'", Usuario.class);
			List<Usuario> login = u.getResultList();
			for (Usuario log : login) {
				log.setClave("hugo");
				em.persist(user);
			}
			user.setCorreo("hugo@dallas.com");
			user.setClave("hugo");
			em.persist(user);
		}
		
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void actualizarDatosRegistrado (String correo, String clave) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		System.out.println(correo);
		TypedQuery<Registrado> q = em.createQuery("SELECT r FROM Registrado r where r.correo = '"+correo+"'", Registrado.class);
		List<Registrado> registrado = q.getResultList();
		em.getTransaction().begin();
		for (Registrado user : registrado) {
			TypedQuery<Usuario> u = em.createQuery("SELECT u FROM Usuario u where u.cedula = '"+user.getCedula()+"'", Usuario.class);
			List<Usuario> login = u.getResultList();
			for (Usuario log : login) {
				log.setClave(clave);
				em.persist(user);
			}
			user.setCorreo(correo);
			user.setClave(clave);
			em.persist(user);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static void main(String[] args) {
		//creacionUsuario();
		//consultarDatosVictima();
		//consultarUsuario();
		//listadoUsuarios();
		//ListadoVictimas();
		// obtencionRegistrado();
		// obtencionUnaSolaEntidadTercerMetodo();
		// listadoEntidades();
		// listadoEntidadesSegundoMetodo();
		// obtencionEntidadesRelacionadas();
		// creacionEntidad();
		// modificacionEntidad();
		// eliminacionEntidad();
		//modificarDatosAdministrador();
		//consultarDatosAuditoria();
		//probando();
		//modificarDatosRegistrado();
		//consultarCuantitativosAuditoria();
		//actualizarDatosRegistrado("bchacon@dallas.com","bchacon");
		listadoCuant();
	}

}
