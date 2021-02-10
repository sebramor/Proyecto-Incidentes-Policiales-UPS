package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_oficial_investigacion database table.
 * 
 */
@Entity
@Table(name="dim_oficial_investigacion")
@NamedQuery(name="DimOficialInvestigacion.findAll", query="SELECT d FROM DimOficialInvestigacion d")
public class DimOficialInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_investigaciones")
	private Integer skInvestigaciones;

	@Column(name="codigo_reporte")
	private String codigoReporte;

	@Column(name="nombre_oficial")
	private String nombreOficial;

	@Column(name="nombre_unidad")
	private String nombreUnidad;

	@Column(name="numero_insignia")
	private String numeroInsignia;

	@Column(name="numero_revision")
	private String numeroRevision;

	@Column(name="pk_investigacion")
	private Integer pkInvestigacion;

	@Column(name="pk_oficiales")
	private Integer pkOficiales;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_desde")
	private Date validoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_hasta")
	private Date validoHasta;

	private Integer version;

	public DimOficialInvestigacion() {
	}

	public Integer getSkInvestigaciones() {
		return this.skInvestigaciones;
	}

	public void setSkInvestigaciones(Integer skInvestigaciones) {
		this.skInvestigaciones = skInvestigaciones;
	}

	public String getCodigoReporte() {
		return this.codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public String getNombreOficial() {
		return this.nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	public String getNombreUnidad() {
		return this.nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getNumeroInsignia() {
		return this.numeroInsignia;
	}

	public void setNumeroInsignia(String numeroInsignia) {
		this.numeroInsignia = numeroInsignia;
	}

	public String getNumeroRevision() {
		return this.numeroRevision;
	}

	public void setNumeroRevision(String numeroRevision) {
		this.numeroRevision = numeroRevision;
	}

	public Integer getPkInvestigacion() {
		return this.pkInvestigacion;
	}

	public void setPkInvestigacion(Integer pkInvestigacion) {
		this.pkInvestigacion = pkInvestigacion;
	}

	public Integer getPkOficiales() {
		return this.pkOficiales;
	}

	public void setPkOficiales(Integer pkOficiales) {
		this.pkOficiales = pkOficiales;
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