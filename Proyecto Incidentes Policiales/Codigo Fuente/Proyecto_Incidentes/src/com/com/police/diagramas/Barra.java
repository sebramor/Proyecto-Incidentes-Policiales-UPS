package com.police.diagramas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.PrimeFaces;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.axes.radial.RadialScales;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearAngleLines;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearPointLabels;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.bubble.BubbleChartDataSet;
import org.primefaces.model.charts.bubble.BubbleChartModel;
import org.primefaces.model.charts.data.BubblePoint;
import org.primefaces.model.charts.data.NumericPoint;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.elements.Elements;
import org.primefaces.model.charts.optionconfig.elements.ElementsLine;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.optionconfig.tooltip.Tooltip;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.polar.PolarAreaChartDataSet;
import org.primefaces.model.charts.polar.PolarAreaChartModel;
import org.primefaces.model.charts.radar.RadarChartDataSet;
import org.primefaces.model.charts.radar.RadarChartModel;
import org.primefaces.model.charts.radar.RadarChartOptions;
import org.primefaces.model.charts.scatter.ScatterChartModel;

import com.police.beans.AuditoriaBean;
import com.police.beans.bloqueadoBean;
import com.police.datos.consultarDao;
import com.police.modelo.Auditoria;
import com.police.modelo.DimCiudadDivision;
import com.police.modelo.DimFecha;
import com.police.modelo.DimIncidenteLlamada;
import com.police.modelo.DimOficialInvestigacion;
import com.police.modelo.FactIncidente;
import com.police.modelo.Usuario;
import com.police.modelo.VistaReporte;

import javafx.animation.Animation;

@Named("barra")
@RequestScoped
public class Barra implements Serializable {
    
    private PieChartModel pieModel;
    
    private PolarAreaChartModel polarAreaModel;
    
    private LineChartModel lineModel;
    
    private LineChartModel cartesianLinerModel;
    
    private BarChartModel barModel;
    
    private BarChartModel barModel2;
    
    private HorizontalBarChartModel hbarModel;
    
    private BarChartModel stackedBarModel;
    
    private BarChartModel stackedGroupBarModel;
    
    private RadarChartModel radarModel;
    
    private RadarChartModel radarModel2;
    
    private BubbleChartModel bubbleModel;
    
    private BarChartModel mixedModel;
    
    private DonutChartModel donutModel;
    
    private ScatterChartModel scatterModel;
    
    //CREATE DONUT MODEL + DATOS EN CAJAS/ ETIQUETAS DE AUDITORIA 
    private Integer actualizados=0, eliminados=0, agregados=0;
    
    private Integer anio;
	private String descripcionLlamada;
	private Integer dia;
	private String distritoConsejo;
	private String estadoCrimen;
	private Integer informes;
	private Integer llamadasRealizadas;
	private Integer mes;
	private String modusOperandi;
	private String nombreCiudad;
	private String nombreDivision;
	private String nombreOficial;
	private String nombreVictima;
	private String numeroIncidente;
	private Integer numeroZona;
	private String tipoIncidente;
	private String ubicacion;
	private Integer victimas;
	private Date fecha;

    public Integer getActualizados() {
		return actualizados;
	}

	public void setActualizados(Integer actualizados) {
		this.actualizados = actualizados;
	}

	public Integer getEliminados() {
		return eliminados;
	}

	public void setEliminados(Integer eliminados) {
		this.eliminados = eliminados;
	}

	public Integer getAgregados() {
		return agregados;
	}

	public void setAgregados(Integer agregados) {
		this.agregados = agregados;
	}
	
	

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcionLlamada() {
		return descripcionLlamada;
	}

	public void setDescripcionLlamada(String descripcionLlamada) {
		this.descripcionLlamada = descripcionLlamada;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDistritoConsejo() {
		return distritoConsejo;
	}

	public void setDistritoConsejo(String distritoConsejo) {
		this.distritoConsejo = distritoConsejo;
	}

	public String getEstadoCrimen() {
		return estadoCrimen;
	}

	public void setEstadoCrimen(String estadoCrimen) {
		this.estadoCrimen = estadoCrimen;
	}

	public Integer getInformes() {
		return informes;
	}

	public void setInformes(Integer informes) {
		this.informes = informes;
	}

	public Integer getLlamadasRealizadas() {
		return llamadasRealizadas;
	}

	public void setLlamadasRealizadas(Integer llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getModusOperandi() {
		return modusOperandi;
	}

	public void setModusOperandi(String modusOperandi) {
		this.modusOperandi = modusOperandi;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getNombreDivision() {
		return nombreDivision;
	}

	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	public String getNombreOficial() {
		return nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	public String getNombreVictima() {
		return nombreVictima;
	}

	public void setNombreVictima(String nombreVictima) {
		this.nombreVictima = nombreVictima;
	}

	public String getNumeroIncidente() {
		return numeroIncidente;
	}

	public void setNumeroIncidente(String numeroIncidente) {
		this.numeroIncidente = numeroIncidente;
	}

	public Integer getNumeroZona() {
		return numeroZona;
	}

	public void setNumeroZona(Integer numeroZona) {
		this.numeroZona = numeroZona;
	}

	public String getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getVictimas() {
		return victimas;
	}

	public void setVictimas(Integer victimas) {
		this.victimas = victimas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@PostConstruct
    public void init() {
        createPieModel();
        createPolarAreaModel();
        createLineModel();
        createCartesianLinerModel();
        createBarModel();
        createBarModel2();
        createHorizontalBarModel();
        createStackedBarModel();
        createStackedGroupBarModel();
        createRadarModel();
        createRadarModel2();
        createBubbleModel();
        createMixedModel();
        createDonutModel();
        createScatterModel();
    }
    
    private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
        
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
        
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);
        
        pieModel.setData(data);
    }
    
    private void createPolarAreaModel() {
        polarAreaModel = new PolarAreaChartModel();
        ChartData data = new ChartData();
        
        PolarAreaChartDataSet dataSet = new PolarAreaChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(11);
        values.add(16);
        values.add(7);
        values.add(3);
        values.add(14);
        dataSet.setData(values);
        
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(75, 192, 192)");
        bgColors.add("rgb(255, 205, 86)");
        bgColors.add("rgb(201, 203, 207)");
        bgColors.add("rgb(54, 162, 235)");
        dataSet.setBackgroundColor(bgColors);
        
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Green");
        labels.add("Yellow");
        labels.add("Grey");
        labels.add("Blue");
        data.setLabels(labels);
        
        polarAreaModel.setData(data);
    }
    
    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
        
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        
        //Options
        LineChartOptions options = new LineChartOptions();        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);
        
        lineModel.setOptions(options);
        lineModel.setData(data);
    }
    
    public void createScatterModel() {
        scatterModel = new ScatterChartModel();
        ChartData data = new ChartData();
        
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        values.add(new NumericPoint(-10, 0));
        values.add(new NumericPoint(0,10));
        values.add(new NumericPoint(10, 5));
        values.add(new NumericPoint(8, 14));
        values.add(new NumericPoint(12, 2));
        values.add(new NumericPoint(13, 7));
        values.add(new NumericPoint(6, 9));
        dataSet.setData(values);
        dataSet.setLabel("Red Dataset");
        dataSet.setBorderColor("rgb(249, 24, 24)");
        dataSet.setShowLine(false);
        data.addChartDataSet(dataSet);
        
        //Options
        LineChartOptions options = new LineChartOptions();        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Scatter Chart");
        options.setShowLines(false);
        options.setTitle(title);
        
        scatterModel.setOptions(options);
        scatterModel.setData(data);
    }
    
    public void createCartesianLinerModel() {
        cartesianLinerModel = new LineChartModel();
        ChartData data = new ChartData();
        
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        values.add(20);
        values.add(50);
        values.add(100);
        values.add(75);
        values.add(25);
        values.add(0);
        dataSet.setData(values);
        dataSet.setLabel("Left Dataset");
        dataSet.setYaxisID("left-y-axis");
        
        LineChartDataSet dataSet2 = new LineChartDataSet();
        List<Object> values2 = new ArrayList<>();
        values2.add(0.1);
        values2.add(0.5);
        values2.add(1.0);
        values2.add(2.0);
        values2.add(1.5);
        values2.add(0);
        dataSet2.setData(values2);
        dataSet2.setLabel("Right Dataset");
        dataSet2.setYaxisID("right-y-axis");
        
        data.addChartDataSet(dataSet);
        data.addChartDataSet(dataSet2);
        
        List<String> labels = new ArrayList<>();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
        labels.add("Jun");
        data.setLabels(labels);
        cartesianLinerModel.setData(data);
        
        //Options
        LineChartOptions options = new LineChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setId("left-y-axis");
        linearAxes.setPosition("left");
        CartesianLinearAxes linearAxes2 = new CartesianLinearAxes();
        linearAxes2.setId("right-y-axis");
        linearAxes2.setPosition("right");
        
        cScales.addYAxesData(linearAxes);
        cScales.addYAxesData(linearAxes2);
        options.setScales(cScales);    
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Cartesian Linear Chart");
        options.setTitle(title);
        
        cartesianLinerModel.setOptions(options);
    }
    
    public void createBarModel() {
    	String mes="";
    	String dia="";
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Reportes Gr�ficos");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		// LISTA DE LAS CLASES UTILIZADAS PARA LAS CONSULTAS 
		List<DimIncidenteLlamada> reportes = null;
		List<FactIncidente> reportes_generados = null;
		List<DimFecha> reportes_fecha = null;
		List<DimOficialInvestigacion> reportes_oficial = null;
		// LISTA DE LOS VALORES CUANTITATIVOS QUE IR�N EN EL GR�FICO
		List<Number> values = new ArrayList<>();
		// LISTA DE LOS VALORES CUALITATIVOS QUE IR�N EN EL GRAFICO
		List<String> labels = new ArrayList<>();
		// TIPO DE VARIABLES PARA CONSULTAS QUERY
		Query q,c = null;
		try {
			if(fecha!=null) {
				
				if(fecha.getMonth()+1<10)
				{
					mes = "0"+String.valueOf(fecha.getMonth()+1);
				}else {
					mes = String.valueOf(fecha.getMonth()+1);
				}
				if(fecha.getDate()<10)
				{
					dia = "0"+String.valueOf(fecha.getDate());  
				}else {
					dia = String.valueOf(fecha.getDate());
				}
				barDataSet.setLabel("N�mero de incidentes por tipo en  "+ (fecha.getYear()+1900)+"/"+mes+"/"+dia);
				// Datos Cuantitativos
				 q = em.createNativeQuery("SELECT * from dim_incidente_llamadas, fact_incidente where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes and sk_fecha = '"+(fecha.getYear()+1900)+mes+dia+"' limit 7;", DimIncidenteLlamada.class);
				 reportes = (List<DimIncidenteLlamada>) q.getResultList();
				 for (DimIncidenteLlamada usuario : reportes) {
					 labels.add(usuario.getTipoIncidente());
				     values.add(usuario.getSkIncidentes()/1000);
					}
				 barDataSet.setData(values);
				 data.addChartDataSet(barDataSet);
				 data.setLabels(labels);
			     barModel.setData(data);
			} else {
				if(tipoIncidente!=null) 
				{
					barDataSet.setLabel("Total reportes generados por "+tipoIncidente+" ");
					q = em.createNativeQuery("SELECT * from dim_incidente_llamadas, fact_incidente where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes and tipo_incidente like '%"+tipoIncidente+"%' limit 7;", FactIncidente.class);
					c = em.createNativeQuery("SELECT * from dim_incidente_llamadas, fact_incidente where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes and tipo_incidente like '%"+tipoIncidente+"%' limit 7;", DimIncidenteLlamada.class);
					reportes_generados = (List<FactIncidente>) q.getResultList();
					reportes = (List<DimIncidenteLlamada>) c.getResultList();
					
					
					for (DimIncidenteLlamada usuario : reportes) {
						 labels.add(usuario.getTipoIncidente());
						}
					for (FactIncidente usuario : reportes_generados) {
					     values.add(usuario.getReportesGenerados());
						}
					 barDataSet.setData(values);
					 data.addChartDataSet(barDataSet);
					 data.setLabels(labels);
				     barModel.setData(data);
				} else
				{
					if(distritoConsejo!=null) 
					{
						barDataSet.setLabel("Total incidentes reportados por el distrito "+distritoConsejo+" ");
						q = em.createNativeQuery("SELECT (fact_incidente.sk_incidentes) , dim_incidente_llamadas.tipo_incidente from dim_incidente_llamadas, \r\n"
								+ "fact_incidente , dim_apartamento \r\n"
								+ "where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes \r\n"
								+ "and dim_apartamento.sk_apartamento=fact_incidente.sk_apartamento       \r\n"
								+ "and distrito_consejo='"+distritoConsejo+"' limit 7", DimIncidenteLlamada.class);
						reportes = (List<DimIncidenteLlamada>) q.getResultList();
						
						for (DimIncidenteLlamada usuario : reportes) {
							 labels.add(usuario.getTipoIncidente());
							 values.add(usuario.getSkIncidentes());
							}
						 barDataSet.setData(values);
						 data.addChartDataSet(barDataSet);
						 data.setLabels(labels);
					     barModel.setData(data);
					} else 
					{
						if(nombreOficial!=null) 
						{
							barDataSet.setLabel("Incidentes reportados por fecha de "+nombreOficial+" ");
							q = em.createNativeQuery("SELECT * from dim_incidente_llamadas, \r\n"
									+ "fact_incidente , dim_oficial_investigacion\r\n"
									+ "where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes \r\n"
									+ "and dim_oficial_investigacion.sk_investigaciones=fact_incidente.sk_investigaciones and nombre_oficial = '"+nombreOficial+"'    \r\n"
									+ " limit 7 ", DimFecha.class);
							c = em.createNativeQuery("SELECT * from dim_incidente_llamadas, \r\n"
									+ "fact_incidente , dim_oficial_investigacion\r\n"
									+ "where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes \r\n"
									+ "and dim_oficial_investigacion.sk_investigaciones=fact_incidente.sk_investigaciones and nombre_oficial = '"+nombreOficial+"'    \r\n"
									+ " limit 7 ", DimIncidenteLlamada.class);
							reportes_fecha = (List<DimFecha>) q.getResultList();
							reportes = (List<DimIncidenteLlamada>) c.getResultList();
							
							for (DimFecha usuario : reportes_fecha) {
								 labels.add(String.valueOf(usuario.getSkFecha()));
								}
							for (DimIncidenteLlamada usuario : reportes) {
							     values.add(usuario.getSkIncidentes()/500);
								}
							 barDataSet.setData(values);
							 data.addChartDataSet(barDataSet);
							 data.setLabels(labels);
						     barModel.setData(data);
						} else 
						{
							if(nombreDivision!=null) {
								barDataSet.setLabel("Reportes por oficial de la divisi�n "+nombreDivision+" ");
								q = em.createNativeQuery("SELECT * from dim_incidente_llamadas, \r\n"
										+ "fact_incidente , dim_ciudad_division, dim_oficial_investigacion\r\n"
										+ "where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes \r\n"
										+ "and dim_ciudad_division.sk_division=fact_incidente.sk_division and dim_oficial_investigacion.sk_investigaciones = fact_incidente.sk_investigaciones and nombre_division = '"+nombreDivision+"' and nombre_oficial != 'null' limit 7", DimOficialInvestigacion.class);
								c = em.createNativeQuery("SELECT * from dim_incidente_llamadas, \r\n"
										+ "fact_incidente , dim_ciudad_division, dim_oficial_investigacion\r\n"
										+ "where dim_incidente_llamadas.sk_incidentes = fact_incidente.sk_incidentes \r\n"
										+ "and dim_ciudad_division.sk_division=fact_incidente.sk_division and dim_oficial_investigacion.sk_investigaciones = fact_incidente.sk_investigaciones and nombre_division = '"+nombreDivision+"' and nombre_oficial != 'null' limit 7", DimIncidenteLlamada.class);
								reportes_oficial = (List<DimOficialInvestigacion>) q.getResultList();
								reportes = (List<DimIncidenteLlamada>) c.getResultList();
								
								for (DimOficialInvestigacion usuario : reportes_oficial) {
									 labels.add(usuario.getNombreOficial());
									}
								for (DimIncidenteLlamada usuario : reportes) {
								     values.add(usuario.getSkIncidentes());
									}
								 barDataSet.setData(values);
								 data.addChartDataSet(barDataSet);
								 data.setLabels(labels);
							     barModel.setData(data);
							}
						}
					
					}
				}
			}
			
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido alg�n tipo de error, porfavor vuelva a intentarlo"); 
	        PrimeFaces.current().dialog().showMessageDynamic(message);
		}
        
        
        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        barDataSet.setBackgroundColor(bgColor);
        
        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);
        
      
        
       
      
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
        
        

        barModel.setOptions(options);
    }
    
    public String refrescarGrafico() {
    	return "graficos";
    }
    
   
    public void createBarModel2() {
        barModel2 = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Agregados");
        barDataSet.setBackgroundColor("rgba(99, 255, 108, 0.2)");
        barDataSet.setBorderColor("rgb(99, 255, 108)");
        barDataSet.setBorderWidth(1);
 
        List<Number> values = new ArrayList<>();
        values.add(6);
        barDataSet.setData(values);
        
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("Actualizados");
        barDataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
        barDataSet2.setBorderColor("rgb(255, 159, 64)");
        barDataSet2.setBorderWidth(1);
        List<Number> values2 = new ArrayList<>();
        values2.add(1);
        barDataSet2.setData(values2);

        BarChartDataSet barDataSet3 = new BarChartDataSet();
        barDataSet3.setLabel("Eliminados");
        barDataSet3.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        barDataSet3.setBorderColor("rgb(255, 99, 132)");
        barDataSet3.setBorderWidth(1);
 
        List<Number> values3 = new ArrayList<>();
        values3.add(2);
        barDataSet.setData(values3);
        
        
        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        data.addChartDataSet(barDataSet3);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        barModel2.setData(data);
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);
        
        barModel2.setOptions(options);
    }
    
    public void createHorizontalBarModel() {
        hbarModel = new HorizontalBarChartModel();
        ChartData data = new ChartData();
        
        HorizontalBarChartDataSet hbarDataSet = new HorizontalBarChartDataSet();
        hbarDataSet.setLabel("My First Dataset");
        
        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        hbarDataSet.setData(values);
        
        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        hbarDataSet.setBackgroundColor(bgColor);
        
        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        hbarDataSet.setBorderColor(borderColor);
        hbarDataSet.setBorderWidth(1);
        
        data.addChartDataSet(hbarDataSet);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        hbarModel.setData(data);
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Horizontal Bar Chart");
        options.setTitle(title);
        
        hbarModel.setOptions(options);
    }
    
    public void createStackedBarModel() {
        stackedBarModel = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Dataset 1");
        barDataSet.setBackgroundColor("rgb(255, 99, 132)");
        List<Number> dataVal = new ArrayList<>();
        dataVal.add(62);
        dataVal.add(-58);
        dataVal.add(-49);
        dataVal.add(25);
        dataVal.add(4);
        dataVal.add(77);
        dataVal.add(-41);
        barDataSet.setData(dataVal);
        
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("Dataset 2");
        barDataSet2.setBackgroundColor("rgb(54, 162, 235)");
        List<Number> dataVal2 = new ArrayList<>();
        dataVal2.add(-1);
        dataVal2.add(32);
        dataVal2.add(-52);
        dataVal2.add(11);
        dataVal2.add(97);
        dataVal2.add(76);
        dataVal2.add(-78);
        barDataSet2.setData(dataVal2);
        
        BarChartDataSet barDataSet3 = new BarChartDataSet();
        barDataSet3.setLabel("Dataset 3");
        barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
        List<Number> dataVal3 = new ArrayList<>();
        dataVal3.add(-44);
        dataVal3.add(25);
        dataVal3.add(15);
        dataVal3.add(92);
        dataVal3.add(80);
        dataVal3.add(-25);
        dataVal3.add(-11);
        barDataSet3.setData(dataVal3);
        
        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        data.addChartDataSet(barDataSet3);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        stackedBarModel.setData(data);
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setStacked(true);
        linearAxes.setOffset(true);
        cScales.addXAxesData(linearAxes);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart - Stacked");
        options.setTitle(title);
        
        Tooltip tooltip = new Tooltip();
        tooltip.setMode("index");
        tooltip.setIntersect(false);
        options.setTooltip(tooltip);  
        
        stackedBarModel.setOptions(options);
    }
    
    public void createStackedGroupBarModel() {
        stackedGroupBarModel = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Dataset 1");
        barDataSet.setBackgroundColor("rgb(255, 99, 132)");
        barDataSet.setStack("Stack 0");
        List<Number> dataVal = new ArrayList<>();
        dataVal.add(-32);
        dataVal.add(-70);
        dataVal.add(-33);
        dataVal.add(30);
        dataVal.add(-49);
        dataVal.add(23);
        dataVal.add(-92);
        barDataSet.setData(dataVal);
        
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("Dataset 2");
        barDataSet2.setBackgroundColor("rgb(54, 162, 235)");
        barDataSet2.setStack("Stack 0");
        List<Number> dataVal2 = new ArrayList<>();
        dataVal2.add(83);
        dataVal2.add(18);
        dataVal2.add(86);
        dataVal2.add(8);
        dataVal2.add(34);
        dataVal2.add(46);
        dataVal2.add(11);
        barDataSet2.setData(dataVal2);
        
        BarChartDataSet barDataSet3 = new BarChartDataSet();
        barDataSet3.setLabel("Dataset 3");
        barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
        barDataSet3.setStack("Stack 1");
        List<Number> dataVal3 = new ArrayList<>();
        dataVal3.add(-45);
        dataVal3.add(73);
        dataVal3.add(-25);
        dataVal3.add(65);
        dataVal3.add(49);
        dataVal3.add(-18);
        dataVal3.add(46);
        barDataSet3.setData(dataVal3);
        
        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        data.addChartDataSet(barDataSet3);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        stackedGroupBarModel.setData(data);
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setStacked(true);
        linearAxes.setOffset(true);
        cScales.addXAxesData(linearAxes);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart - Stacked Group");
        options.setTitle(title);
        
        Tooltip tooltip = new Tooltip();
        tooltip.setMode("index");
        tooltip.setIntersect(false);
        options.setTooltip(tooltip);  
        
        stackedGroupBarModel.setOptions(options);
    }
    
    public void createRadarModel() {
        radarModel = new RadarChartModel();
        ChartData data = new ChartData();
        
        RadarChartDataSet radarDataSet = new RadarChartDataSet();
        radarDataSet.setLabel("My First Dataset");
        radarDataSet.setFill(true);
        radarDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        radarDataSet.setBorderColor("rgb(255, 99, 132)");
        radarDataSet.setPointBackgroundColor("rgb(255, 99, 132)");
        radarDataSet.setPointBorderColor("#fff");
        radarDataSet.setPointHoverBackgroundColor("#fff");
        radarDataSet.setPointHoverBorderColor("rgb(255, 99, 132)");
        List<Number> dataVal = new ArrayList<>();
        dataVal.add(65);
        dataVal.add(59);
        dataVal.add(90);
        dataVal.add(81);
        dataVal.add(56);
        dataVal.add(55);
        dataVal.add(40);
        radarDataSet.setData(dataVal);
        
        RadarChartDataSet radarDataSet2 = new RadarChartDataSet();
        radarDataSet2.setLabel("My Second Dataset");
        radarDataSet2.setFill(true);
        radarDataSet2.setBackgroundColor("rgba(54, 162, 235, 0.2)");
        radarDataSet2.setBorderColor("rgb(54, 162, 235)");
        radarDataSet2.setPointBackgroundColor("rgb(54, 162, 235)");
        radarDataSet2.setPointBorderColor("#fff");
        radarDataSet2.setPointHoverBackgroundColor("#fff");
        radarDataSet2.setPointHoverBorderColor("rgb(54, 162, 235)");
        List<Number> dataVal2 = new ArrayList<>();
        dataVal2.add(28);
        dataVal2.add(48);
        dataVal2.add(40);
        dataVal2.add(19);
        dataVal2.add(96);
        dataVal2.add(27);
        dataVal2.add(100);
        radarDataSet2.setData(dataVal2);
        
        data.addChartDataSet(radarDataSet);
        data.addChartDataSet(radarDataSet2);
        
        List<String> labels = new ArrayList<>();
        labels.add("Eating");
        labels.add("Drinking");
        labels.add("Sleeping");
        labels.add("Designing");
        labels.add("Coding");
        labels.add("Cycling");
        labels.add("Running");
        data.setLabels(labels);
        
        /* Options */
        RadarChartOptions options = new RadarChartOptions();
        Elements elements = new Elements();
        ElementsLine elementsLine = new ElementsLine();
        elementsLine.setTension(0);
        elementsLine.setBorderWidth(3);
        elements.setLine(elementsLine);
        options.setElements(elements);
        
        radarModel.setOptions(options);
        radarModel.setData(data);
    }
    
    public void createRadarModel2() {
        radarModel2 = new RadarChartModel();
        ChartData data = new ChartData();
        
        RadarChartDataSet radarDataSet = new RadarChartDataSet();
        radarDataSet.setLabel("P.Practitioner");
        radarDataSet.setLineTension(0.1);
        radarDataSet.setBackgroundColor("rgba(102, 153, 204, 0.2)");
        radarDataSet.setBorderColor("rgba(102, 153, 204, 1)");
        radarDataSet.setPointBackgroundColor("rgba(102, 153, 204, 1)");
        radarDataSet.setPointBorderColor("#fff");
        radarDataSet.setPointHoverRadius(5);
        radarDataSet.setPointHoverBackgroundColor("#fff");
        radarDataSet.setPointHoverBorderColor("rgba(102, 153, 204, 1)");
        List<Number> dataVal = new ArrayList<>();
        dataVal.add(2);
        dataVal.add(3);
        dataVal.add(2);
        dataVal.add(1);
        dataVal.add(3);
        radarDataSet.setData(dataVal);

        RadarChartDataSet radarDataSet2 = new RadarChartDataSet();
        radarDataSet2.setLabel("P.Manager");
        radarDataSet2.setLineTension(0.1);
        radarDataSet2.setBackgroundColor("rgba(255, 204, 102, 0.2)");
        radarDataSet2.setBorderColor("rgba(255, 204, 102, 1)");
        radarDataSet2.setPointBackgroundColor("rgba(255, 204, 102, 1)");
        radarDataSet2.setPointBorderColor("#fff");
        radarDataSet2.setPointHoverRadius(5);
        radarDataSet2.setPointHoverBackgroundColor("#fff");
        radarDataSet2.setPointHoverBorderColor("rgba(255, 204, 102, 1)");
        List<Number> dataVal2 = new ArrayList<>();
        dataVal2.add(2);
        dataVal2.add(3);
        dataVal2.add(3);
        dataVal2.add(2);
        dataVal2.add(3);
        radarDataSet2.setData(dataVal2);
        
        data.addChartDataSet(radarDataSet);
        data.addChartDataSet(radarDataSet2);
        
        List<List<String>> labels = new ArrayList<>();
        labels.add(new ArrayList(Arrays.asList("Process","Excellence")));
        labels.add(new ArrayList(Arrays.asList("Problem","Solving")));
        labels.add(new ArrayList(Arrays.asList("Facilitation")));
        labels.add(new ArrayList(Arrays.asList("Project","Mgmt")));
        labels.add(new ArrayList(Arrays.asList("Change","Mgmt")));
        data.setLabels(labels);

        /* Options */
        RadarChartOptions options = new RadarChartOptions();
        RadialScales rScales = new RadialScales();
        
        RadialLinearAngleLines angelLines = new RadialLinearAngleLines();
        angelLines.setDisplay(true);
        angelLines.setLineWidth(0.5);
        angelLines.setColor("rgba(128, 128, 128, 0.2)");
        rScales.setAngelLines(angelLines);
        
        RadialLinearPointLabels pointLabels = new RadialLinearPointLabels();
        pointLabels.setFontSize(14);
        pointLabels.setFontStyle("300");
        pointLabels.setFontColor("rgba(204, 204, 204, 1)");
        pointLabels.setFontFamily("Lato, sans-serif");
        
        RadialLinearTicks ticks = new RadialLinearTicks();
        ticks.setBeginAtZero(true);
        ticks.setMaxTicksLimit(3);
        ticks.setMin(0);
        ticks.setMax(3);
        ticks.setDisplay(false);

        options.setScales(rScales);
        
        radarModel2.setOptions(options);
        radarModel2.setData(data);
        radarModel2.setExtender("skinRadarChart");
    }
    
    public void createBubbleModel() {
        bubbleModel = new BubbleChartModel();
        ChartData data = new ChartData();
        
        BubbleChartDataSet dataSet = new BubbleChartDataSet();
        List<BubblePoint> values = new ArrayList<>();
        values.add(new BubblePoint(20, 30, 15));
        values.add(new BubblePoint(40, 10, 10));
        dataSet.setData(values);
        dataSet.setBackgroundColor("rgb(255, 99, 132)");
        dataSet.setLabel("First Dataset");
        data.addChartDataSet(dataSet);
        bubbleModel.setData(data);
    }
    
    public void createMixedModel() {
        mixedModel = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet dataSet = new BarChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(10);
        values.add(20);
        values.add(30);
        values.add(40);
        dataSet.setData(values);
        dataSet.setLabel("Bar Dataset");
        dataSet.setBorderColor("rgb(255, 99, 132)");
        dataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        
        LineChartDataSet dataSet2 = new LineChartDataSet();
        List<Object> values2 = new ArrayList<>();
        values2.add(50);
        values2.add(50);
        values2.add(50);
        values2.add(50);
        dataSet2.setData(values2);
        dataSet2.setLabel("Line Dataset");
        dataSet2.setFill(false);
        dataSet2.setBorderColor("rgb(54, 162, 235)");
        
        data.addChartDataSet(dataSet);
        data.addChartDataSet(dataSet2);
        
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        data.setLabels(labels);
        
        mixedModel.setData(data);
        
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        mixedModel.setOptions(options);
    }
    
    public void createDonutModel() {
    	donutModel = new DonutChartModel();
        ChartData data = new ChartData();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Proyecto_Incidentes_Policiales");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * from auditoria.auditoria;", Auditoria.class);
		List lista = new ArrayList();
		List<Auditoria> aud = (List<Auditoria>) q.getResultList();
		
		for (Auditoria auditoria : aud) {
			try {
				if(auditoria.getOperacionAud().equals("UPDATE") && auditoria.getTablaAud().equals("registrado")) {
					actualizados++;	
				}	
				if(auditoria.getOperacionAud().equals("DELETE") && auditoria.getTablaAud().equals("registrado")) {
					eliminados++;	
				}	
				if(auditoria.getOperacionAud().equals("INSERT") && auditoria.getTablaAud().equals("registrado")) {
					agregados++;	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
				
		}
        DonutChartDataSet dataSet = new DonutChartDataSet();
        
        // DATOS CUANTITATIVOS DE LA AUDITORIA
        List<Number> values = new ArrayList<>();
        values.add(actualizados);
        values.add(eliminados);
        values.add(agregados);
        dataSet.setData(values);
        
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
        
        //DATOS CUALITATIVOS DE LA AUDITORIA
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Actualizados");
        labels.add("Eliminados");
        labels.add("Agregados");
        data.setLabels(labels);
        
        donutModel.setData(data);
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public PolarAreaChartModel getPolarAreaModel() {
        return polarAreaModel;
    }

    public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
        this.polarAreaModel = polarAreaModel;
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public LineChartModel getCartesianLinerModel() {
        return cartesianLinerModel;
    }

    public void setCartesianLinerModel(LineChartModel cartesianLinerModel) {
        this.cartesianLinerModel = cartesianLinerModel;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }

    public HorizontalBarChartModel getHbarModel() {
        return hbarModel;
    }

    public void setHbarModel(HorizontalBarChartModel hbarModel) {
        this.hbarModel = hbarModel;
    }

    public BarChartModel getStackedBarModel() {
        return stackedBarModel;
    }

    public void setStackedBarModel(BarChartModel stackedBarModel) {
        this.stackedBarModel = stackedBarModel;
    }

    public BarChartModel getStackedGroupBarModel() {
        return stackedGroupBarModel;
    }

    public void setStackedGroupBarModel(BarChartModel stackedGroupBarModel) {
        this.stackedGroupBarModel = stackedGroupBarModel;
    }

    public RadarChartModel getRadarModel() {
        return radarModel;
    }

    public void setRadarModel(RadarChartModel radarModel) {
        this.radarModel = radarModel;
    }

    public RadarChartModel getRadarModel2() {
        return radarModel2;
    }

    public void setRadarModel2(RadarChartModel radarModel2) {
        this.radarModel2 = radarModel2;
    }

    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }

    public void setBubbleModel(BubbleChartModel bubbleModel) {
        this.bubbleModel = bubbleModel;
    }

    public BarChartModel getMixedModel() {
        return mixedModel;
    }

    public void setMixedModel(BarChartModel mixedModel) {
        this.mixedModel = mixedModel;
    }

    public DonutChartModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }
    
    public ScatterChartModel getScatterModel() {
        return scatterModel;
    }
    
    public void setScatterModel(ScatterChartModel scatterModel) {
        this.scatterModel = scatterModel;
    }
}
