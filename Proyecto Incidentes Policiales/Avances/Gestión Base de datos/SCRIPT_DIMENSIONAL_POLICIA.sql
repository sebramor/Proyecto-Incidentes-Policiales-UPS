
CREATE TABLE public.DIM_FECHA (
                sk_fecha INTEGER NOT NULL,
                fecha_incidente DATE NOT NULL,
                hora_incidente VARCHAR(15) NOT NULL,
                año_incidente INTEGER NOT NULL,
                mes_incidente INTEGER NOT NULL,
                nombre_mes_incidente VARCHAR(25) NOT NULL,
                dia_incidente INTEGER NOT NULL,
                fecha_reporte DATE NOT NULL,
                año_reporte INTEGER NOT NULL,
                mes_reporte INTEGER NOT NULL,
                nombre_mes_reporte VARCHAR(25) NOT NULL,
                dia_reporte INTEGER NOT NULL,
                CONSTRAINT pk_dim_fecha PRIMARY KEY (sk_fecha)
);


CREATE TABLE public.DIM_INVESTIGACION (
                sk_investigacion INTEGER NOT NULL,
                pk_investigacion VARCHAR(6) NOT NULL,
                nombre_unidad VARCHAR(80) NOT NULL,
                distrito VARCHAR(30) NOT NULL,
                modo_operacion VARCHAR(30) NOT NULL,
                clase_arma VARCHAR(30) NOT NULL,
                estado_investigacion VARCHAR(30) NOT NULL,
                historial_llamada VARCHAR(180) NOT NULL,
                valido_desde DATE,
                valido_hasta DATE,
                version INTEGER NOT NULL,
                CONSTRAINT pk_dim_investigaciones PRIMARY KEY (sk_investigacion)
);


CREATE TABLE public.DIM_OFICIAL (
                sk_oficial INTEGER NOT NULL,
                pk_oficial VARCHAR(30),
                nombre_policia VARCHAR(40),
                numero_distrito NUMERIC(20) NOT NULL,
                division_asignada VARCHAR(50) NOT NULL,
                valido_desde DATE,
                valido_hasta DATE,
                version INTEGER NOT NULL,
                CONSTRAINT pk_dim_oficial PRIMARY KEY (sk_oficial)
);


CREATE TABLE public.DIM_VICTIMA (
                sk_victima INTEGER NOT NULL,
                pk_victima VARCHAR(30) NOT NULL,
                nombre_victima VARCHAR(50) NOT NULL,
                edad_victima NUMERIC(10) NOT NULL,
                genero_victima VARCHAR(30) NOT NULL,
                raza_victima VARCHAR(40) NOT NULL,
                condicion_victima VARCHAR(30) NOT NULL,
                domicilio_victima VARCHAR(120) NOT NULL,
                ciudad_victima VARCHAR(30) NOT NULL,
                valido_desde DATE,
                valido_hasta DATE,
                version INTEGER NOT NULL,
                CONSTRAINT pk_dim_victima PRIMARY KEY (sk_victima)
);


CREATE TABLE public.DIM_INCIDENTE (
                sk_incidente INTEGER NOT NULL,
                pk_incidente VARCHAR(60) NOT NULL,
                categoria_incidente VARCHAR(180) NOT NULL,
                ciudad_incidente VARCHAR(60) NOT NULL,
                ubicacion_incidente VARCHAR(50) NOT NULL,
                estado_incidente VARCHAR(30) NOT NULL,
                valido_desde DATE,
                valido_hasta DATE,
                version INTEGER NOT NULL,
                CONSTRAINT pk_dim_incidente PRIMARY KEY (sk_incidente)
);


CREATE TABLE public.FACT_REPORTE (
                sk_oficial INTEGER NOT NULL,
                sk_incidente INTEGER NOT NULL,
                sk_victima INTEGER NOT NULL,
                sk_investigacion INTEGER NOT NULL,
                sk_fecha INTEGER NOT NULL,
                numero_victimas INTEGER,
                cantidad_reportes INTEGER,
                numero_llamadas_realizadas INTEGER,
                CONSTRAINT pk_fact_reporte PRIMARY KEY (sk_oficial, sk_incidente, sk_victima, sk_investigacion, sk_fecha)
);


ALTER TABLE public.FACT_REPORTE ADD CONSTRAINT dim_fecha_fact_reporte_fk
FOREIGN KEY (sk_fecha)
REFERENCES public.DIM_FECHA (sk_fecha)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FACT_REPORTE ADD CONSTRAINT dim_investigacion_fact_reporte_fk
FOREIGN KEY (sk_investigacion)
REFERENCES public.DIM_INVESTIGACION (sk_investigacion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FACT_REPORTE ADD CONSTRAINT dim_oficial_fact_reporte_fk
FOREIGN KEY (sk_oficial)
REFERENCES public.DIM_OFICIAL (sk_oficial)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FACT_REPORTE ADD CONSTRAINT dim_victima_fact_reporte_fk
FOREIGN KEY (sk_victima)
REFERENCES public.DIM_VICTIMA (sk_victima)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FACT_REPORTE ADD CONSTRAINT dim_incidente_fact_reporte_fk
FOREIGN KEY (sk_incidente)
REFERENCES public.DIM_INCIDENTE (sk_incidente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
