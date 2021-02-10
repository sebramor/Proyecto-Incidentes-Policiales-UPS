package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fact_incidente database table.
 * 
 */
@Entity
@Table(name="fact_incidente")
@NamedQuery(name="FactIncidente.findAll", query="SELECT f FROM FactIncidente f")
public class FactIncidente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FactIncidentePK id;

	@Column(name="informes_zona")
	private Integer informesZona;

	@Column(name="llamadas_realizadas")
	private Integer llamadasRealizadas;

	@Column(name="reportes_generados")
	private Integer reportesGenerados;

	@Column(name="victimas_ocasionadas")
	private Integer victimasOcasionadas;

	public FactIncidente() {
	}

	public FactIncidentePK getId() {
		return this.id;
	}

	public void setId(FactIncidentePK id) {
		this.id = id;
	}

	public Integer getInformesZona() {
		return this.informesZona;
	}

	public void setInformesZona(Integer informesZona) {
		this.informesZona = informesZona;
	}

	public Integer getLlamadasRealizadas() {
		return this.llamadasRealizadas;
	}

	public void setLlamadasRealizadas(Integer llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}

	public Integer getReportesGenerados() {
		return this.reportesGenerados;
	}

	public void setReportesGenerados(Integer reportesGenerados) {
		this.reportesGenerados = reportesGenerados;
	}

	public Integer getVictimasOcasionadas() {
		return this.victimasOcasionadas;
	}

	public void setVictimasOcasionadas(Integer victimasOcasionadas) {
		this.victimasOcasionadas = victimasOcasionadas;
	}

}