package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vista_reporte database table.
 * 
 */
@Entity
@Table(name="vista_reporte")
@NamedQuery(name="VistaReporte.findAll", query="SELECT v FROM VistaReporte v")
public class VistaReporte implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer anio;

	@Column(name="descripcion_llamada")
	private String descripcionLlamada;

	private Integer dia;

	@Column(name="distrito_consejo")
	private String distritoConsejo;

	@Column(name="estado_crimen")
	private String estadoCrimen;

	private Integer informes;

	@Column(name="llamadas_realizadas")
	private Integer llamadasRealizadas;

	private Integer mes;

	@Column(name="modus_operandi")
	private String modusOperandi;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	@Column(name="nombre_division")
	private String nombreDivision;

	@Column(name="nombre_oficial")
	private String nombreOficial;

	@Column(name="nombre_victima")
	private String nombreVictima;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="numero_incidente")
	private String numeroIncidente;

	@Column(name="numero_zona")
	private Integer numeroZona;

	@Column(name="tipo_incidente")
	private String tipoIncidente;

	private String ubicacion;

	private Integer victimas;

	public VistaReporte() {
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcionLlamada() {
		return this.descripcionLlamada;
	}

	public void setDescripcionLlamada(String descripcionLlamada) {
		this.descripcionLlamada = descripcionLlamada;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDistritoConsejo() {
		return this.distritoConsejo;
	}

	public void setDistritoConsejo(String distritoConsejo) {
		this.distritoConsejo = distritoConsejo;
	}

	public String getEstadoCrimen() {
		return this.estadoCrimen;
	}

	public void setEstadoCrimen(String estadoCrimen) {
		this.estadoCrimen = estadoCrimen;
	}

	public Integer getInformes() {
		return this.informes;
	}

	public void setInformes(Integer informes) {
		this.informes = informes;
	}

	public Integer getLlamadasRealizadas() {
		return this.llamadasRealizadas;
	}

	public void setLlamadasRealizadas(Integer llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getModusOperandi() {
		return this.modusOperandi;
	}

	public void setModusOperandi(String modusOperandi) {
		this.modusOperandi = modusOperandi;
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

	public String getNombreOficial() {
		return this.nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	public String getNombreVictima() {
		return this.nombreVictima;
	}

	public void setNombreVictima(String nombreVictima) {
		this.nombreVictima = nombreVictima;
	}

	public String getNumeroIncidente() {
		return this.numeroIncidente;
	}

	public void setNumeroIncidente(String numeroIncidente) {
		this.numeroIncidente = numeroIncidente;
	}

	public Integer getNumeroZona() {
		return this.numeroZona;
	}

	public void setNumeroZona(Integer numeroZona) {
		this.numeroZona = numeroZona;
	}

	public String getTipoIncidente() {
		return this.tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getVictimas() {
		return this.victimas;
	}

	public void setVictimas(Integer victimas) {
		this.victimas = victimas;
	}

}