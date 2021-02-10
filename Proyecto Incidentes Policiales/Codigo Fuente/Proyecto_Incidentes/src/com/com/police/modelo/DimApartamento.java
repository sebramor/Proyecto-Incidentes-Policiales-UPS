package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_apartamento database table.
 * 
 */
@Entity
@Table(name="dim_apartamento")
@NamedQuery(name="DimApartamento.findAll", query="SELECT d FROM DimApartamento d")
public class DimApartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_apartamento")
	private Integer skApartamento;

	@Column(name="distrito_consejo")
	private String distritoConsejo;

	@Column(name="numero_apartamento")
	private String numeroApartamento;

	@Column(name="pk_apartamento")
	private Integer pkApartamento;

	private Integer sector;

	@Column(name="tipo_localidad")
	private String tipoLocalidad;

	@Column(name="tipo_propiedad")
	private String tipoPropiedad;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_desde")
	private Date validoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_hasta")
	private Date validoHasta;

	private Integer version;

	public DimApartamento() {
	}

	public Integer getSkApartamento() {
		return this.skApartamento;
	}

	public void setSkApartamento(Integer skApartamento) {
		this.skApartamento = skApartamento;
	}

	public String getDistritoConsejo() {
		return this.distritoConsejo;
	}

	public void setDistritoConsejo(String distritoConsejo) {
		this.distritoConsejo = distritoConsejo;
	}

	public String getNumeroApartamento() {
		return this.numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public Integer getPkApartamento() {
		return this.pkApartamento;
	}

	public void setPkApartamento(Integer pkApartamento) {
		this.pkApartamento = pkApartamento;
	}

	public Integer getSector() {
		return this.sector;
	}

	public void setSector(Integer sector) {
		this.sector = sector;
	}

	public String getTipoLocalidad() {
		return this.tipoLocalidad;
	}

	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	public String getTipoPropiedad() {
		return this.tipoPropiedad;
	}

	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
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