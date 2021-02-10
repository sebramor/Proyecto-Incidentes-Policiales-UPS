package com.police.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.police.datos.Conexion;
import com.police.datos.consultarDao;
import com.police.modelo.DimCrimVict;


@Named("victima")
@RequestScoped
public class VictimaBean 
{
	private static final long serialVersionUID = 1L;

	private Integer skVictimas;
	private Integer codigoCriminal;
	private String domicilioVictima;
	private Integer edadVictima;
	private String estadoCrimen;
	private String estadoReporte;
	private String generoVictima;
	private String idVictima;
	private String modusOperandi;
	private String nombreVictima;
	private Integer pkCrimen;
	private Integer pkVictimas;
	private String tipoArma;
	private String tipoVictima;
	private Date validoDesde;
	private Date validoHasta;
	private Integer version;

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
	EntityManager em = entityManagerFactory.createEntityManager();
	Query q = em.createNativeQuery("SELECT * FROM dim_crim_vict limit 100;", DimCrimVict.class);
	
	List<DimCrimVict> usuarios = (List<DimCrimVict>) q.getResultList();

	public List<DimCrimVict> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<DimCrimVict> usuarios) {
		this.usuarios = usuarios;
	}

	public VictimaBean() 
	{
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

	public void consultarDatosVictima()
	{
		consultarDao conexion = new consultarDao();
		conexion.consultarDatosVictima();
	}
	
	
	

}
