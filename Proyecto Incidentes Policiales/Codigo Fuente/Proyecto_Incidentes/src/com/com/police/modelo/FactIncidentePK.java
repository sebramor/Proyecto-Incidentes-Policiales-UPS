package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fact_incidente database table.
 * 
 */
@Embeddable
public class FactIncidentePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="sk_victimas")
	private Integer skVictimas;

	@Column(name="sk_division")
	private Integer skDivision;

	@Column(name="sk_incidentes")
	private Integer skIncidentes;

	@Column(name="sk_apartamento")
	private Integer skApartamento;

	@Column(name="sk_investigaciones")
	private Integer skInvestigaciones;

	@Column(name="sk_fecha")
	private Integer skFecha;

	public FactIncidentePK() {
	}
	public Integer getSkVictimas() {
		return this.skVictimas;
	}
	public void setSkVictimas(Integer skVictimas) {
		this.skVictimas = skVictimas;
	}
	public Integer getSkDivision() {
		return this.skDivision;
	}
	public void setSkDivision(Integer skDivision) {
		this.skDivision = skDivision;
	}
	public Integer getSkIncidentes() {
		return this.skIncidentes;
	}
	public void setSkIncidentes(Integer skIncidentes) {
		this.skIncidentes = skIncidentes;
	}
	public Integer getSkApartamento() {
		return this.skApartamento;
	}
	public void setSkApartamento(Integer skApartamento) {
		this.skApartamento = skApartamento;
	}
	public Integer getSkInvestigaciones() {
		return this.skInvestigaciones;
	}
	public void setSkInvestigaciones(Integer skInvestigaciones) {
		this.skInvestigaciones = skInvestigaciones;
	}
	public Integer getSkFecha() {
		return this.skFecha;
	}
	public void setSkFecha(Integer skFecha) {
		this.skFecha = skFecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FactIncidentePK)) {
			return false;
		}
		FactIncidentePK castOther = (FactIncidentePK)other;
		return 
			this.skVictimas.equals(castOther.skVictimas)
			&& this.skDivision.equals(castOther.skDivision)
			&& this.skIncidentes.equals(castOther.skIncidentes)
			&& this.skApartamento.equals(castOther.skApartamento)
			&& this.skInvestigaciones.equals(castOther.skInvestigaciones)
			&& this.skFecha.equals(castOther.skFecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.skVictimas.hashCode();
		hash = hash * prime + this.skDivision.hashCode();
		hash = hash * prime + this.skIncidentes.hashCode();
		hash = hash * prime + this.skApartamento.hashCode();
		hash = hash * prime + this.skInvestigaciones.hashCode();
		hash = hash * prime + this.skFecha.hashCode();
		
		return hash;
	}
}