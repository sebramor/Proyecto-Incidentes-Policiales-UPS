package com.police.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dim_crim_vict database table.
 * 
 */
@Entity
@Table(name="dim_crim_vict")
@NamedQuery(name="DimCrimVict.findAll", query="SELECT d FROM DimCrimVict d")
public class DimCrimVict implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sk_victimas")
	private Integer skVictimas;

	@Column(name="codigo_criminal")
	private Integer codigoCriminal;

	@Column(name="domicilio_victima")
	private String domicilioVictima;

	@Column(name="edad_victima")
	private Integer edadVictima;

	@Column(name="estado_crimen")
	private String estadoCrimen;

	@Column(name="estado_reporte")
	private String estadoReporte;

	@Column(name="genero_victima")
	private String generoVictima;

	@Column(name="id_victima")
	private String idVictima;

	@Column(name="modus_operandi")
	private String modusOperandi;

	@Column(name="nombre_victima")
	private String nombreVictima;

	@Column(name="pk_crimen")
	private Integer pkCrimen;

	@Column(name="pk_victimas")
	private Integer pkVictimas;

	@Column(name="tipo_arma")
	private String tipoArma;

	@Column(name="tipo_victima")
	private String tipoVictima;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_desde")
	private Date validoDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="valido_hasta")
	private Date validoHasta;

	private Integer version;

	public DimCrimVict() {
	}

	public Integer getSkVictimas() {
		return this.skVictimas;
	}

	public void setSkVictimas(Integer skVictimas) {
		this.skVictimas = skVictimas;
	}

	public Integer getCodigoCriminal() {
		return this.codigoCriminal;
	}

	public void setCodigoCriminal(Integer codigoCriminal) {
		this.codigoCriminal = codigoCriminal;
	}

	public String getDomicilioVictima() {
		return this.domicilioVictima;
	}

	public void setDomicilioVictima(String domicilioVictima) {
		this.domicilioVictima = domicilioVictima;
	}

	public Integer getEdadVictima() {
		return this.edadVictima;
	}

	public void setEdadVictima(Integer edadVictima) {
		this.edadVictima = edadVictima;
	}

	public String getEstadoCrimen() {
		return this.estadoCrimen;
	}

	public void setEstadoCrimen(String estadoCrimen) {
		this.estadoCrimen = estadoCrimen;
	}

	public String getEstadoReporte() {
		return this.estadoReporte;
	}

	public void setEstadoReporte(String estadoReporte) {
		this.estadoReporte = estadoReporte;
	}

	public String getGeneroVictima() {
		return this.generoVictima;
	}

	public void setGeneroVictima(String generoVictima) {
		this.generoVictima = generoVictima;
	}

	public String getIdVictima() {
		return this.idVictima;
	}

	public void setIdVictima(String idVictima) {
		this.idVictima = idVictima;
	}

	public String getModusOperandi() {
		return this.modusOperandi;
	}

	public void setModusOperandi(String modusOperandi) {
		this.modusOperandi = modusOperandi;
	}

	public String getNombreVictima() {
		return this.nombreVictima;
	}

	public void setNombreVictima(String nombreVictima) {
		this.nombreVictima = nombreVictima;
	}

	public Integer getPkCrimen() {
		return this.pkCrimen;
	}

	public void setPkCrimen(Integer pkCrimen) {
		this.pkCrimen = pkCrimen;
	}

	public Integer getPkVictimas() {
		return this.pkVictimas;
	}

	public void setPkVictimas(Integer pkVictimas) {
		this.pkVictimas = pkVictimas;
	}

	public String getTipoArma() {
		return this.tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public String getTipoVictima() {
		return this.tipoVictima;
	}

	public void setTipoVictima(String tipoVictima) {
		this.tipoVictima = tipoVictima;
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