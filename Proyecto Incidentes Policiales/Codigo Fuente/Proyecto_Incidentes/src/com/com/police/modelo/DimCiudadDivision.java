package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_ciudad_division database table.
 * 
 */
@Entity
@Table(name="dim_ciudad_division")
@NamedQuery(name="DimCiudadDivision.findAll", query="SELECT d FROM DimCiudadDivision d")
public class DimCiudadDivision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_division")
	private Integer skDivision;

	@Column(name="codigo_postal")
	private Integer codigoPostal;

	private String estado;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	@Column(name="nombre_division")
	private String nombreDivision;

	@Column(name="numero_zona")
	private Integer numeroZona;

	@Column(name="pk_ciudad")
	private Integer pkCiudad;

	@Column(name="pk_division")
	private Integer pkDivision;

	private String ubicacion;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_desde")
	private Date validoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_hasta")
	private Date validoHasta;

	private Integer version;

	public DimCiudadDivision() {
	}

	public Integer getSkDivision() {
		return this.skDivision;
	}

	public void setSkDivision(Integer skDivision) {
		this.skDivision = skDivision;
	}

	public Integer getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getNombreDivision() {
		return this.nombreDivision;
	}

	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	public Integer getNumeroZona() {
		return this.numeroZona;
	}

	public void setNumeroZona(Integer numeroZona) {
		this.numeroZona = numeroZona;
	}

	public Integer getPkCiudad() {
		return this.pkCiudad;
	}

	public void setPkCiudad(Integer pkCiudad) {
		this.pkCiudad = pkCiudad;
	}

	public Integer getPkDivision() {
		return this.pkDivision;
	}

	public void setPkDivision(Integer pkDivision) {
		this.pkDivision = pkDivision;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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