package com.police.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.PrimeFaces;

import com.police.modelo.Auditoria;
import com.police.modelo.VistaReporte;

@Named("reporte")
@RequestScoped
public class reporteBean {
	private Integer anio;
	private String descripcionLlamada;
	private Integer dia;
	private String distritoConsejo;
	private String estadoCrimen;
	private Integer informes;
	private Integer llamadasRealizadas;
	private Integer mes;
	private String modusOperandi;
	private String nombreCiudad;
	private String nombreDivision;
	private String nombreOficial;
	private String nombreVictima;
	private String numeroIncidente;
	private Integer numeroZona;
	private String tipoIncidente;
	private String ubicacion;
	private Integer victimas;
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcionLlamada() {
		return descripcionLlamada;
	}

	public void setDescripcionLlamada(String descripcionLlamada) {
		this.descripcionLlamada = descripcionLlamada;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDistritoConsejo() {
		return distritoConsejo;
	}

	public void setDistritoConsejo(String distritoConsejo) {
		this.distritoConsejo = distritoConsejo;
	}

	public String getEstadoCrimen() {
		return estadoCrimen;
	}

	public void setEstadoCrimen(String estadoCrimen) {
		this.estadoCrimen = estadoCrimen;
	}

	public Integer getInformes() {
		return informes;
	}

	public void setInformes(Integer informes) {
		this.informes = informes;
	}

	public Integer getLlamadasRealizadas() {
		return llamadasRealizadas;
	}

	public void setLlamadasRealizadas(Integer llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getModusOperandi() {
		return modusOperandi;
	}

	public void setModusOperandi(String modusOperandi) {
		this.modusOperandi = modusOperandi;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getNombreDivision() {
		return nombreDivision;
	}

	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	public String getNombreOficial() {
		return nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	public String getNombreVictima() {
		return nombreVictima;
	}

	public void setNombreVictima(String nombreVictima) {
		this.nombreVictima = nombreVictima;
	}

	public String getNumeroIncidente() {
		return numeroIncidente;
	}

	public void setNumeroIncidente(String numeroIncidente) {
		this.numeroIncidente = numeroIncidente;
	}

	public Integer getNumeroZona() {
		return numeroZona;
	}

	public void setNumeroZona(Integer numeroZona) {
		this.numeroZona = numeroZona;
	}

	public String getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getVictimas() {
		return victimas;
	}

	public void setVictimas(Integer victimas) {
		this.victimas = victimas;
	}
	//Metodo para buscar por filtro
	   public List<VistaReporte> reportesFiltro() {
		   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			List<VistaReporte> reportes = null;
			Query q = null;
		   try {
			
				
			q = em.createNativeQuery("select * from vista_reporte;",VistaReporte.class);
			   
			reportes = (List<VistaReporte>) q.getResultList();
			
//			for (VistaReporte reporte : reportes) {
//				System.out.println("reporte: " + reporte.getDescripcionLlamada() );
//			}
			    
			
		   } catch (Exception e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido algún tipo de error, porfavor vuelva a intentarlo"); 
		        PrimeFaces.current().dialog().showMessageDynamic(message);
			}
		   return reportes;
		}



	   // RETORNA LA LISTA DEPENDIENDO DE LA SELECCION EN EL FORMULARIO DE REPORTES POR CATEGORIA 
	public List<VistaReporte> reportes() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<VistaReporte> reportes = null;
		Query q = null;
		try {
			if(fecha!=null) {
				// EL ATRIBUTO DATE ESTÁ EN DESUSO POR LO QUE SU SISTEMA ESTÁ RETRASADO EN MESES X 1 Y EN AÑO DESDE 1900 POR MARGENES DE ERROR 
				 q = em.createNativeQuery("select * from vista_reporte where dia = "+fecha.getDate()+" and mes = "+(fecha.getMonth()+1)+" and anio = "+(fecha.getYear()+1900)+";",VistaReporte.class);
				 reportes = (List<VistaReporte>) q.getResultList();
			} else {
				if (distritoConsejo!=null) {
					 q = em.createNativeQuery("select * from vista_reporte where distrito_consejo = '"+distritoConsejo+"';",VistaReporte.class);
					 reportes = (List<VistaReporte>) q.getResultList();
				} else {
					if (nombreDivision!=null) {
						q = em.createNativeQuery("select * from vista_reporte where nombre_division = '"+nombreDivision+"';",VistaReporte.class);
						 reportes = (List<VistaReporte>) q.getResultList();
					} else {
						if (nombreOficial!=null) {
							q = em.createNativeQuery("select * from vista_reporte where nombre_oficial = '"+nombreOficial+"';",VistaReporte.class);
							 reportes = (List<VistaReporte>) q.getResultList();
						} else {
							if(tipoIncidente!=null) 
							{
								q = em.createNativeQuery("select * from vista_reporte where tipo_incidente like '%"+tipoIncidente+"%';",VistaReporte.class);
								 reportes = (List<VistaReporte>) q.getResultList();	
							}
						}
					}
				}
			}
			
			
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido algún tipo de error, porfavor vuelva a intentarlo"); 
	        PrimeFaces.current().dialog().showMessageDynamic(message);
		}
		return reportes;

	}

	public String refrescar() {
		return "reporte";
	}

	public String refrescarCategoria() {
		return "categoria";
	}
}
