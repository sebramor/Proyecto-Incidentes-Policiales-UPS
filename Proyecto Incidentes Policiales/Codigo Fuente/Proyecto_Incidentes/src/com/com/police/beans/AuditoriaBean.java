package com.police.beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.police.datos.consultarDao;
import com.police.modelo.Auditoria;
import com.police.modelo.DimCrimVict;

@Named("auditoria")
@RequestScoped
public class AuditoriaBean {
	private Integer idAud;
	private Boolean activarAud;
	private String esquemaAud;
	private Date fechaAud;
	private String operacionAud;
	private String tablaAud;
	private Boolean triggerAud;
	private String usuarioAud;
	private String valoranteriorAud;
	private String valornuevoAud;
	

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
	EntityManager em = entityManagerFactory.createEntityManager();
	Query q = em.createNativeQuery("SELECT * from auditoria.auditoria;", Auditoria.class);
	
	List<Auditoria> lista_auditoria = (List<Auditoria>) q.getResultList();
	
	public Integer getIdAud() {
		return idAud;
	}
	public void setIdAud(Integer idAud) {
		this.idAud = idAud;
	}
	public Boolean getActivarAud() {
		return activarAud;
	}
	public void setActivarAud(Boolean activarAud) {
		this.activarAud = activarAud;
	}
	public String getEsquemaAud() {
		return esquemaAud;
	}
	public void setEsquemaAud(String esquemaAud) {
		this.esquemaAud = esquemaAud;
	}
	public Date getFechaAud() {
		return fechaAud;
	}
	public void setFechaAud(Date fechaAud) {
		this.fechaAud = fechaAud;
	}
	public String getOperacionAud() {
		return operacionAud;
	}
	public void setOperacionAud(String operacionAud) {
		this.operacionAud = operacionAud;
	}
	public String getTablaAud() {
		return tablaAud;
	}
	public void setTablaAud(String tablaAud) {
		this.tablaAud = tablaAud;
	}
	public Boolean getTriggerAud() {
		return triggerAud;
	}
	public void setTriggerAud(Boolean triggerAud) {
		this.triggerAud = triggerAud;
	}
	public String getUsuarioAud() {
		return usuarioAud;
	}
	public void setUsuarioAud(String usuarioAud) {
		this.usuarioAud = usuarioAud;
	}
	public String getValoranteriorAud() {
		return valoranteriorAud;
	}
	public void setValoranteriorAud(String valoranteriorAud) {
		this.valoranteriorAud = valoranteriorAud;
	}
	public String getValornuevoAud() {
		return valornuevoAud;
	}
	public void setValornuevoAud(String valornuevoAud) {
		this.valornuevoAud = valornuevoAud;
	}

	public List<Auditoria> getLista_auditoria() {
		return lista_auditoria;
	}
	public void setLista_auditoria(List<Auditoria> lista_auditoria) {
		this.lista_auditoria = lista_auditoria;
	}
	
	public void consultarDatosAuditoria()
	{
		consultarDao conexion = new consultarDao();
		conexion.consultarAuditoria();
	}
	
	
}
