package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_fecha database table.
 * 
 */
@Entity
@Table(name="dim_fecha")
@NamedQuery(name="DimFecha.findAll", query="SELECT d FROM DimFecha d")
public class DimFecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_fecha")
	private Integer skFecha;

	private Integer anio;

	private Integer dia;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer mes;

	@Column(name="nombre_mes")
	private String nombreMes;

	@Column(name="nombre_semestre")
	private String nombreSemestre;

	@Column(name="nombre_trimestre")
	private String nombreTrimestre;

	private Integer semestre;

	private Integer trimestre;

	public DimFecha() {
	}

	public Integer getSkFecha() {
		return this.skFecha;
	}

	public void setSkFecha(Integer skFecha) {
		this.skFecha = skFecha;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getNombreMes() {
		return this.nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

	public String getNombreSemestre() {
		return this.nombreSemestre;
	}

	public void setNombreSemestre(String nombreSemestre) {
		this.nombreSemestre = nombreSemestre;
	}

	public String getNombreTrimestre() {
		return this.nombreTrimestre;
	}

	public void setNombreTrimestre(String nombreTrimestre) {
		this.nombreTrimestre = nombreTrimestre;
	}

	public Integer getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getTrimestre() {
		return this.trimestre;
	}

	public void setTrimestre(Integer trimestre) {
		this.trimestre = trimestre;
	}

}