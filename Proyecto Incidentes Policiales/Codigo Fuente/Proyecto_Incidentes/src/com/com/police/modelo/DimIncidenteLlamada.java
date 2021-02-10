package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_incidente_llamadas database table.
 * 
 */
@Entity
@Table(name="dim_incidente_llamadas")
@NamedQuery(name="DimIncidenteLlamada.findAll", query="SELECT d FROM DimIncidenteLlamada d")
public class DimIncidenteLlamada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_incidentes")
	private Integer skIncidentes;

	@Column(name="codigo_cfs")
	private String codigoCfs;

	@Column(name="descripcion_llamada")
	private String descripcionLlamada;

	@Column(name="direccion_incidente")
	private String direccionIncidente;

	@Column(name="numero_incidente")
	private String numeroIncidente;

	@Column(name="persona_involucrada")
	private String personaInvolucrada;

	@Column(name="pk_incidentes")
	private Integer pkIncidentes;

	@Column(name="pk_llamadas")
	private Integer pkLlamadas;

	@Column(name="tipo_incidente")
	private String tipoIncidente;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_desde")
	private Date validoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_hasta")
	private Date validoHasta;

	private Integer version;

	public DimIncidenteLlamada() {
	}

	public Integer getSkIncidentes() {
		return this.skIncidentes;
	}

	public void setSkIncidentes(Integer skIncidentes) {
		this.skIncidentes = skIncidentes;
	}

	public String getCodigoCfs() {
		return this.codigoCfs;
	}

	public void setCodigoCfs(String codigoCfs) {
		this.codigoCfs = codigoCfs;
	}

	public String getDescripcionLlamada() {
		return this.descripcionLlamada;
	}

	public void setDescripcionLlamada(String descripcionLlamada) {
		this.descripcionLlamada = descripcionLlamada;
	}

	public String getDireccionIncidente() {
		return this.direccionIncidente;
	}

	public void setDireccionIncidente(String direccionIncidente) {
		this.direccionIncidente = direccionIncidente;
	}

	public String getNumeroIncidente() {
		return this.numeroIncidente;
	}

	public void setNumeroIncidente(String numeroIncidente) {
		this.numeroIncidente = numeroIncidente;
	}

	public String getPersonaInvolucrada() {
		return this.personaInvolucrada;
	}

	public void setPersonaInvolucrada(String personaInvolucrada) {
		this.personaInvolucrada = personaInvolucrada;
	}

	public Integer getPkIncidentes() {
		return this.pkIncidentes;
	}

	public void setPkIncidentes(Integer pkIncidentes) {
		this.pkIncidentes = pkIncidentes;
	}

	public Integer getPkLlamadas() {
		return this.pkLlamadas;
	}

	public void setPkLlamadas(Integer pkLlamadas) {
		this.pkLlamadas = pkLlamadas;
	}

	public String getTipoIncidente() {
		return this.tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public Date getValidoDesde() {
		return this.validoDesde;
	}

	public void setValidoDesde(Date validoDesde) {
		this.validoDesde = validoDesde;
	}

	public Date getValidoHasta() {
		return this.validoHasta;
	}

	public void setValidoHasta(Date validoHasta) {
		this.validoHasta = validoHasta;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}