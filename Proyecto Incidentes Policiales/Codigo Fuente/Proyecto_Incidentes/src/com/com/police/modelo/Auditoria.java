package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_aud")
	private Integer idAud;

	@Column(name="activar_aud")
	private Boolean activarAud;

	@Column(name="esquema_aud")
	private String esquemaAud;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_aud")
	private Date fechaAud;

	@Column(name="operacion_aud")
	private String operacionAud;

	@Column(name="tabla_aud")
	private String tablaAud;

	@Column(name="trigger_aud")
	private Boolean triggerAud;

	@Column(name="usuario_aud")
	private String usuarioAud;

	@Column(name="valoranterior_aud")
	private String valoranteriorAud;

	@Column(name="valornuevo_aud")
	private String valornuevoAud;

	public Auditoria() {
	}

	public Integer getIdAud() {
		return this.idAud;
	}

	public void setIdAud(Integer idAud) {
		this.idAud = idAud;
	}

	public Boolean getActivarAud() {
		return this.activarAud;
	}

	public void setActivarAud(Boolean activarAud) {
		this.activarAud = activarAud;
	}

	public String getEsquemaAud() {
		return this.esquemaAud;
	}

	public void setEsquemaAud(String esquemaAud) {
		this.esquemaAud = esquemaAud;
	}

	public Date getFechaAud() {
		return this.fechaAud;
	}

	public void setFechaAud(Date fechaAud) {
		this.fechaAud = fechaAud;
	}

	public String getOperacionAud() {
		return this.operacionAud;
	}

	public void setOperacionAud(String operacionAud) {
		this.operacionAud = operacionAud;
	}

	public String getTablaAud() {
		return this.tablaAud;
	}

	public void setTablaAud(String tablaAud) {
		this.tablaAud = tablaAud;
	}

	public Boolean getTriggerAud() {
		return this.triggerAud;
	}

	public void setTriggerAud(Boolean triggerAud) {
		this.triggerAud = triggerAud;
	}

	public String getUsuarioAud() {
		return this.usuarioAud;
	}

	public void setUsuarioAud(String usuarioAud) {
		this.usuarioAud = usuarioAud;
	}

	public String getValoranteriorAud() {
		return this.valoranteriorAud;
	}

	public void setValoranteriorAud(String valoranteriorAud) {
		this.valoranteriorAud = valoranteriorAud;
	}

	public String getValornuevoAud() {
		return this.valornuevoAud;
	}

	public void setValornuevoAud(String valornuevoAud) {
		this.valornuevoAud = valornuevoAud;
	}

}