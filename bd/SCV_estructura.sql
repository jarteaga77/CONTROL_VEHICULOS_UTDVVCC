--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: consumo_combustible; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA consumo_combustible;


ALTER SCHEMA consumo_combustible OWNER TO postgres;

--
-- Name: SCHEMA consumo_combustible; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA consumo_combustible IS 'Registros de todo lo relacionado con el consumo de combustible';


--
-- Name: informes_mensuales; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA informes_mensuales;


ALTER SCHEMA informes_mensuales OWNER TO postgres;

--
-- Name: SCHEMA informes_mensuales; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA informes_mensuales IS 'Informes Mensuales del Consumo de Combustible por vehiculo y estación';


--
-- Name: mantenimientos_mecanica; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA mantenimientos_mecanica;


ALTER SCHEMA mantenimientos_mecanica OWNER TO postgres;

--
-- Name: utilidades; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA utilidades;


ALTER SCHEMA utilidades OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = consumo_combustible, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: consumo_estacion; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE consumo_estacion (
    id_ce integer NOT NULL,
    num_cta character varying,
    fecha_vence date,
    id_estacion integer,
    id_usuario integer,
    total_pesos integer DEFAULT 0,
    observaciones character varying,
    fecha_tran timestamp without time zone,
    aprobado boolean DEFAULT false,
    fecha_aprobacion timestamp without time zone,
    id_usuario_apro integer,
    fecha_mod timestamp without time zone
);


ALTER TABLE consumo_combustible.consumo_estacion OWNER TO postgres;

--
-- Name: TABLE consumo_estacion; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE consumo_estacion IS 'Control de vehiculo por estación de servicio diario';


--
-- Name: consumo_estacion_id_ce_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE consumo_estacion_id_ce_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.consumo_estacion_id_ce_seq OWNER TO postgres;

--
-- Name: consumo_estacion_id_ce_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE consumo_estacion_id_ce_seq OWNED BY consumo_estacion.id_ce;


--
-- Name: control_combustible; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE control_combustible (
    ctrl_com_id integer NOT NULL,
    ctrl_com_fecha_tran timestamp without time zone,
    id_vehiculo integer,
    usuario_id integer,
    ctrl_com_obs character varying,
    totalizado boolean DEFAULT false,
    docadjuntada boolean DEFAULT false,
    id_tipo_com integer,
    id_mes integer,
    id_year integer,
    aprobado boolean DEFAULT false,
    fecha_aprobacion timestamp without time zone,
    id_usuario_apro integer,
    fecha_mod timestamp without time zone
);


ALTER TABLE consumo_combustible.control_combustible OWNER TO postgres;

--
-- Name: TABLE control_combustible; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE control_combustible IS 'Control de Combustible por vehiculo Mensual';


--
-- Name: control_combustible_ctrl_com_id_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE control_combustible_ctrl_com_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.control_combustible_ctrl_com_id_seq OWNER TO postgres;

--
-- Name: control_combustible_ctrl_com_id_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE control_combustible_ctrl_com_id_seq OWNED BY control_combustible.ctrl_com_id;


--
-- Name: det_con_eds; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE det_con_eds (
    id_det_ceds integer NOT NULL,
    vale_utd integer,
    vale_eds character varying,
    id_tipo_com integer,
    cant_gal real,
    valor_total integer,
    kilometraje real,
    vlor_gal integer,
    id_vehiculo integer,
    obse character varying,
    id_ceds integer,
    fechatanq date
);


ALTER TABLE consumo_combustible.det_con_eds OWNER TO postgres;

--
-- Name: TABLE det_con_eds; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE det_con_eds IS 'Detalle de Consumo por estación';


--
-- Name: det_con_eds_id_det_ceds_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE det_con_eds_id_det_ceds_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.det_con_eds_id_det_ceds_seq OWNER TO postgres;

--
-- Name: det_con_eds_id_det_ceds_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE det_con_eds_id_det_ceds_seq OWNED BY det_con_eds.id_det_ceds;


--
-- Name: det_control_combustible; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE det_control_combustible (
    det_ctrl_com_id integer NOT NULL,
    det_ctrl_com_rc_esta character varying,
    det_ctrl_com_can_gal real,
    ctrl_com_id integer,
    esta_ser_id integer,
    det_ctrl_com_obs character varying,
    det_vlor_gaso integer,
    parcial_km real,
    fechatanq date,
    kmtanq real,
    valortanq integer,
    rendmto real,
    valeutd integer
);


ALTER TABLE consumo_combustible.det_control_combustible OWNER TO postgres;

--
-- Name: TABLE det_control_combustible; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE det_control_combustible IS 'Detalle de Control de combustible';


--
-- Name: det_control_combustible_det_ctrl_com_id_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE det_control_combustible_det_ctrl_com_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.det_control_combustible_det_ctrl_com_id_seq OWNER TO postgres;

--
-- Name: det_control_combustible_det_ctrl_com_id_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE det_control_combustible_det_ctrl_com_id_seq OWNED BY det_control_combustible.det_ctrl_com_id;


--
-- Name: doc_control_combustible; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE doc_control_combustible (
    id_num integer NOT NULL,
    id character(6),
    nombre character(64),
    archivo bytea,
    id_ctrl integer
);


ALTER TABLE consumo_combustible.doc_control_combustible OWNER TO postgres;

--
-- Name: TABLE doc_control_combustible; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE doc_control_combustible IS 'Documentación Adjunto del Control de combustible';


--
-- Name: doc_control_combustible_id_num_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE doc_control_combustible_id_num_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.doc_control_combustible_id_num_seq OWNER TO postgres;

--
-- Name: doc_control_combustible_id_num_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE doc_control_combustible_id_num_seq OWNED BY doc_control_combustible.id_num;


--
-- Name: no_tanqueo; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE no_tanqueo (
    id_notan integer NOT NULL,
    id_vehiculo integer,
    id_mes integer,
    id_year integer,
    total_gal integer,
    total_ctrl integer,
    observaciones character varying,
    fecha_tran timestamp without time zone,
    id_usuario integer,
    anulado boolean DEFAULT false
);


ALTER TABLE consumo_combustible.no_tanqueo OWNER TO postgres;

--
-- Name: TABLE no_tanqueo; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE no_tanqueo IS 'Vehiculo que no tuvo consumo de combustible';


--
-- Name: no_tanqueo_id_notan_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE no_tanqueo_id_notan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.no_tanqueo_id_notan_seq OWNER TO postgres;

--
-- Name: no_tanqueo_id_notan_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE no_tanqueo_id_notan_seq OWNED BY no_tanqueo.id_notan;


--
-- Name: total_ccostos_ce; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE total_ccostos_ce (
    id_total integer NOT NULL,
    nom_ccosto character varying,
    total_ccosto integer,
    id_ce integer
);


ALTER TABLE consumo_combustible.total_ccostos_ce OWNER TO postgres;

--
-- Name: TABLE total_ccostos_ce; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE total_ccostos_ce IS 'Total consumo de centro de costos x estación';


--
-- Name: total_ccostos_ce_id_total_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE total_ccostos_ce_id_total_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.total_ccostos_ce_id_total_seq OWNER TO postgres;

--
-- Name: total_ccostos_ce_id_total_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE total_ccostos_ce_id_total_seq OWNED BY total_ccostos_ce.id_total;


--
-- Name: total_control_combustible; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE total_control_combustible (
    t_ctrl_com_id integer NOT NULL,
    t_ctrl_com_total_km real,
    t_ctrl_com_rend_km_gal real,
    t_ctrl_com_total_pesos integer,
    t_ctrl_com_ren_hora real,
    ctrl_id integer
);


ALTER TABLE consumo_combustible.total_control_combustible OWNER TO postgres;

--
-- Name: TABLE total_control_combustible; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE total_control_combustible IS 'Total control de combustible por vehiculo x mes';


--
-- Name: total_control_combustible_t_ctrl_com_id_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE total_control_combustible_t_ctrl_com_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.total_control_combustible_t_ctrl_com_id_seq OWNER TO postgres;

--
-- Name: total_control_combustible_t_ctrl_com_id_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE total_control_combustible_t_ctrl_com_id_seq OWNED BY total_control_combustible.t_ctrl_com_id;


--
-- Name: total_galones; Type: TABLE; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

CREATE TABLE total_galones (
    t_gal_id integer NOT NULL,
    t_gal_est real,
    ctrl_com_id integer,
    estacion character varying
);


ALTER TABLE consumo_combustible.total_galones OWNER TO postgres;

--
-- Name: TABLE total_galones; Type: COMMENT; Schema: consumo_combustible; Owner: postgres
--

COMMENT ON TABLE total_galones IS 'Total Galones x estación - Relacion de combustible';


--
-- Name: total_galones_t_gal_id_seq; Type: SEQUENCE; Schema: consumo_combustible; Owner: postgres
--

CREATE SEQUENCE total_galones_t_gal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consumo_combustible.total_galones_t_gal_id_seq OWNER TO postgres;

--
-- Name: total_galones_t_gal_id_seq; Type: SEQUENCE OWNED BY; Schema: consumo_combustible; Owner: postgres
--

ALTER SEQUENCE total_galones_t_gal_id_seq OWNED BY total_galones.t_gal_id;


SET search_path = informes_mensuales, pg_catalog;

--
-- Name: det_inf_mens; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE det_inf_mens (
    id_det integer NOT NULL,
    id_men_info integer,
    placa character varying,
    dependencia character varying,
    tipo_combustible character varying,
    total_combustible real,
    total_pesos integer,
    id_rc integer
);


ALTER TABLE informes_mensuales.det_inf_mens OWNER TO postgres;

--
-- Name: TABLE det_inf_mens; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE det_inf_mens IS 'Detalle Informe Mensual';


--
-- Name: det_inf_mens_id_det_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE det_inf_mens_id_det_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.det_inf_mens_id_det_seq OWNER TO postgres;

--
-- Name: det_inf_mens_id_det_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE det_inf_mens_id_det_seq OWNED BY det_inf_mens.id_det;


--
-- Name: det_men_eds; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE det_men_eds (
    id_men_info integer,
    placa character varying,
    dependencia character varying,
    tipo_combustible character varying,
    total_combustible integer,
    total_pesos integer,
    id_det integer NOT NULL
);


ALTER TABLE informes_mensuales.det_men_eds OWNER TO postgres;

--
-- Name: TABLE det_men_eds; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE det_men_eds IS 'Detalle Informe Mensual EDS';


--
-- Name: det_men_eds_id_det_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE det_men_eds_id_det_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.det_men_eds_id_det_seq OWNER TO postgres;

--
-- Name: det_men_eds_id_det_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE det_men_eds_id_det_seq OWNED BY det_men_eds.id_det;


--
-- Name: mensual_ctrl; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE mensual_ctrl (
    id integer NOT NULL,
    fecha_gen timestamp without time zone,
    id_usuario integer,
    mes integer,
    year integer
);


ALTER TABLE informes_mensuales.mensual_ctrl OWNER TO postgres;

--
-- Name: TABLE mensual_ctrl; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE mensual_ctrl IS 'Informe Mensual de Vehiculos Equipos';


--
-- Name: mensual_ctrl_id_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE mensual_ctrl_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.mensual_ctrl_id_seq OWNER TO postgres;

--
-- Name: mensual_ctrl_id_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE mensual_ctrl_id_seq OWNED BY mensual_ctrl.id;


--
-- Name: mensual_eds; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE mensual_eds (
    fecha_gen timestamp without time zone,
    id_usuario integer,
    mes integer,
    year integer,
    id_eds integer,
    id integer NOT NULL
);


ALTER TABLE informes_mensuales.mensual_eds OWNER TO postgres;

--
-- Name: TABLE mensual_eds; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE mensual_eds IS 'Informe Mensual del Estación de servicio';


--
-- Name: mensual_eds_id_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE mensual_eds_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.mensual_eds_id_seq OWNER TO postgres;

--
-- Name: mensual_eds_id_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE mensual_eds_id_seq OWNED BY mensual_eds.id;


--
-- Name: total_ccostos_inf_men; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE total_ccostos_inf_men (
    id_total_ccostos integer NOT NULL,
    id_men_inf integer,
    ccostos character varying,
    total_gal real,
    total_pesos integer
);


ALTER TABLE informes_mensuales.total_ccostos_inf_men OWNER TO postgres;

--
-- Name: TABLE total_ccostos_inf_men; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE total_ccostos_inf_men IS 'Total Centro de Costos informe Mensual';


--
-- Name: total_ccostos_inf_men_id_total_ccostos_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE total_ccostos_inf_men_id_total_ccostos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.total_ccostos_inf_men_id_total_ccostos_seq OWNER TO postgres;

--
-- Name: total_ccostos_inf_men_id_total_ccostos_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE total_ccostos_inf_men_id_total_ccostos_seq OWNED BY total_ccostos_inf_men.id_total_ccostos;


--
-- Name: total_gal_inf_men; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE total_gal_inf_men (
    id_total_gal integer NOT NULL,
    id_men_inf integer,
    combustible character varying,
    total_can real,
    total_pesos integer
);


ALTER TABLE informes_mensuales.total_gal_inf_men OWNER TO postgres;

--
-- Name: TABLE total_gal_inf_men; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE total_gal_inf_men IS 'Total Combustible por mes';


--
-- Name: total_gal_inf_men_id_total_gal_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE total_gal_inf_men_id_total_gal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.total_gal_inf_men_id_total_gal_seq OWNER TO postgres;

--
-- Name: total_gal_inf_men_id_total_gal_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE total_gal_inf_men_id_total_gal_seq OWNED BY total_gal_inf_men.id_total_gal;


--
-- Name: total_gal_men_eds; Type: TABLE; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

CREATE TABLE total_gal_men_eds (
    id_men_inf integer,
    combustible character varying,
    total_can real,
    total_pesos integer,
    id_total_gal integer NOT NULL
);


ALTER TABLE informes_mensuales.total_gal_men_eds OWNER TO postgres;

--
-- Name: TABLE total_gal_men_eds; Type: COMMENT; Schema: informes_mensuales; Owner: postgres
--

COMMENT ON TABLE total_gal_men_eds IS 'Total Combustible por estación';


--
-- Name: total_gal_men_eds_id_total_gal_seq; Type: SEQUENCE; Schema: informes_mensuales; Owner: postgres
--

CREATE SEQUENCE total_gal_men_eds_id_total_gal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE informes_mensuales.total_gal_men_eds_id_total_gal_seq OWNER TO postgres;

--
-- Name: total_gal_men_eds_id_total_gal_seq; Type: SEQUENCE OWNED BY; Schema: informes_mensuales; Owner: postgres
--

ALTER SEQUENCE total_gal_men_eds_id_total_gal_seq OWNED BY total_gal_men_eds.id_total_gal;


SET search_path = mantenimientos_mecanica, pg_catalog;

--
-- Name: control_fact_mto_externo; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE control_fact_mto_externo (
    id_ctr_fact integer NOT NULL,
    fecha_reg timestamp with time zone,
    id_mes integer,
    id_anio integer,
    id_vehiculo integer
);


ALTER TABLE mantenimientos_mecanica.control_fact_mto_externo OWNER TO postgres;

--
-- Name: TABLE control_fact_mto_externo; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON TABLE control_fact_mto_externo IS 'Ingreso de facturas de mto externos a vehiculos / equipos';


--
-- Name: control_fact_mto_externo_id_ctr_fact_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE control_fact_mto_externo_id_ctr_fact_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.control_fact_mto_externo_id_ctr_fact_seq OWNER TO postgres;

--
-- Name: control_fact_mto_externo_id_ctr_fact_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE control_fact_mto_externo_id_ctr_fact_seq OWNED BY control_fact_mto_externo.id_ctr_fact;


--
-- Name: cos_fact_mto_ext; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE cos_fact_mto_ext (
    id_cos_fact integer NOT NULL,
    fecha_reg timestamp without time zone DEFAULT now(),
    id_mes integer NOT NULL,
    id_anio integer NOT NULL,
    observacion character varying,
    id_usuario integer NOT NULL,
    total_fact integer
);


ALTER TABLE mantenimientos_mecanica.cos_fact_mto_ext OWNER TO postgres;

--
-- Name: TABLE cos_fact_mto_ext; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON TABLE cos_fact_mto_ext IS 'Registro de facturas de los gastos de los vehiculos y equipos de la empresa';


--
-- Name: cos_fact_mto_ext_id_cos_fact_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE cos_fact_mto_ext_id_cos_fact_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.cos_fact_mto_ext_id_cos_fact_seq OWNER TO postgres;

--
-- Name: cos_fact_mto_ext_id_cos_fact_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE cos_fact_mto_ext_id_cos_fact_seq OWNED BY cos_fact_mto_ext.id_cos_fact;


--
-- Name: dt_cos_fact_mto_ext; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE dt_cos_fact_mto_ext (
    id_dt integer NOT NULL,
    id_vehiculo integer NOT NULL,
    id_fact_mto_ex integer NOT NULL,
    fecha_fact date NOT NULL,
    fact_num character varying NOT NULL,
    id_proveedor integer,
    concepto character varying NOT NULL,
    subtotal double precision NOT NULL,
    descuento double precision DEFAULT 0,
    vlor_iva double precision NOT NULL,
    total double precision NOT NULL,
    archivo_fact bytea,
    id character(6),
    nombre character(64),
    iva character varying NOT NULL,
    oc_ integer NOT NULL
);


ALTER TABLE mantenimientos_mecanica.dt_cos_fact_mto_ext OWNER TO postgres;

--
-- Name: TABLE dt_cos_fact_mto_ext; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON TABLE dt_cos_fact_mto_ext IS 'Detalle del costo y escaneo factura mes.';


--
-- Name: COLUMN dt_cos_fact_mto_ext.archivo_fact; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON COLUMN dt_cos_fact_mto_ext.archivo_fact IS 'Escaneo factura';


--
-- Name: dt_cos_fact_mto_ext_id_dt_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE dt_cos_fact_mto_ext_id_dt_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.dt_cos_fact_mto_ext_id_dt_seq OWNER TO postgres;

--
-- Name: dt_cos_fact_mto_ext_id_dt_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE dt_cos_fact_mto_ext_id_dt_seq OWNED BY dt_cos_fact_mto_ext.id_dt;


--
-- Name: dt_mto_interno; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE dt_mto_interno (
    id_mto_interno integer NOT NULL,
    observacion character varying,
    novedades character varying,
    id_labor_mec integer,
    id_dt_mto_interno integer NOT NULL,
    mto_externo boolean
);


ALTER TABLE mantenimientos_mecanica.dt_mto_interno OWNER TO postgres;

--
-- Name: dt_mto_interno_id_dt_mto_interno_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE dt_mto_interno_id_dt_mto_interno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.dt_mto_interno_id_dt_mto_interno_seq OWNER TO postgres;

--
-- Name: dt_mto_interno_id_dt_mto_interno_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE dt_mto_interno_id_dt_mto_interno_seq OWNED BY dt_mto_interno.id_dt_mto_interno;


--
-- Name: dte_mto_externo; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE dte_mto_externo (
    id_dt_mto_ex integer NOT NULL,
    id_mto_externo integer NOT NULL,
    descripcion character varying,
    can integer NOT NULL,
    um character varying NOT NULL,
    observacion character varying,
    item_sistema integer NOT NULL,
    id_dt_mto_interno integer DEFAULT 0,
    id_mto_interno integer DEFAULT 0
);


ALTER TABLE mantenimientos_mecanica.dte_mto_externo OWNER TO postgres;

--
-- Name: dte_mto_externo_id_dt_mto_ex_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE dte_mto_externo_id_dt_mto_ex_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.dte_mto_externo_id_dt_mto_ex_seq OWNER TO postgres;

--
-- Name: dte_mto_externo_id_dt_mto_ex_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE dte_mto_externo_id_dt_mto_ex_seq OWNED BY dte_mto_externo.id_dt_mto_ex;


--
-- Name: dte_mto_externo_observacion_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE dte_mto_externo_observacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.dte_mto_externo_observacion_seq OWNER TO postgres;

--
-- Name: dte_mto_externo_observacion_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE dte_mto_externo_observacion_seq OWNED BY dte_mto_externo.observacion;


--
-- Name: dtlle_ctrl_fact; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE dtlle_ctrl_fact (
    id_dtlle integer NOT NULL,
    id_ctrl integer,
    id_mto_externo integer,
    oc integer,
    concepto character varying,
    vlorunitario real,
    vlor_iva integer,
    dcto character(10),
    total integer,
    fact_num character varying,
    cantidad real,
    id_iva integer,
    vlordcto real
);


ALTER TABLE mantenimientos_mecanica.dtlle_ctrl_fact OWNER TO postgres;

--
-- Name: dtlle_ctrl_fact_id_dtlle_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE dtlle_ctrl_fact_id_dtlle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.dtlle_ctrl_fact_id_dtlle_seq OWNER TO postgres;

--
-- Name: dtlle_ctrl_fact_id_dtlle_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE dtlle_ctrl_fact_id_dtlle_seq OWNED BY dtlle_ctrl_fact.id_dtlle;


--
-- Name: mto_internos; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE mto_internos (
    fecha_reg timestamp with time zone,
    id_vehiculo integer NOT NULL,
    id_rutina integer NOT NULL,
    km_llegada integer,
    km_proximo_mto integer,
    id_tipo_mto integer NOT NULL,
    horas_uso integer,
    id_mecanico integer NOT NULL,
    id_usuario integer NOT NULL,
    consecutivo_vehiculo integer NOT NULL,
    salida_almacen integer,
    fecha_entrada date,
    hora_entrada time without time zone,
    fecha_salida date,
    hora_salida time without time zone,
    id_us_mod integer,
    fecha_mod timestamp without time zone,
    anulado boolean DEFAULT false,
    observacion_anulado character varying,
    mto_externo boolean DEFAULT false,
    id_mto_interno integer NOT NULL
);


ALTER TABLE mantenimientos_mecanica.mto_internos OWNER TO postgres;

--
-- Name: TABLE mto_internos; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON TABLE mto_internos IS 'Mantenimientos internos taller mecanica UTD';


--
-- Name: mto_internos_id_mto_interno_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE mto_internos_id_mto_interno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.mto_internos_id_mto_interno_seq OWNER TO postgres;

--
-- Name: mto_internos_id_mto_interno_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE mto_internos_id_mto_interno_seq OWNED BY mto_internos.id_mto_interno;


--
-- Name: mto_internos_id_us_mod_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE mto_internos_id_us_mod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.mto_internos_id_us_mod_seq OWNER TO postgres;

--
-- Name: mto_internos_id_us_mod_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE mto_internos_id_us_mod_seq OWNED BY mto_internos.id_us_mod;


--
-- Name: mtos_externos; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE mtos_externos (
    id_mto_externo integer NOT NULL,
    fecha_reg timestamp without time zone NOT NULL,
    id_vehiculo integer NOT NULL,
    id_taller integer NOT NULL,
    anulado boolean DEFAULT false,
    fecha_anulado timestamp without time zone,
    id_usuario_anula integer,
    id_usuario_reg integer NOT NULL,
    observacion_anulado character varying,
    id_mto_interno integer DEFAULT 0,
    consecutivo_vehiculo integer NOT NULL,
    solicita character varying,
    id_tipo_mto integer
);


ALTER TABLE mantenimientos_mecanica.mtos_externos OWNER TO postgres;

--
-- Name: TABLE mtos_externos; Type: COMMENT; Schema: mantenimientos_mecanica; Owner: postgres
--

COMMENT ON TABLE mtos_externos IS 'Mantenimientos Externos ';


--
-- Name: mtos_externos_id_mto_externo_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE mtos_externos_id_mto_externo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.mtos_externos_id_mto_externo_seq OWNER TO postgres;

--
-- Name: mtos_externos_id_mto_externo_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE mtos_externos_id_mto_externo_seq OWNED BY mtos_externos.id_mto_externo;


--
-- Name: mtos_externos_id_usuario_reg_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE mtos_externos_id_usuario_reg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.mtos_externos_id_usuario_reg_seq OWNER TO postgres;

--
-- Name: mtos_externos_id_usuario_reg_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE mtos_externos_id_usuario_reg_seq OWNED BY mtos_externos.id_usuario_reg;


--
-- Name: trabajo_taller_ext; Type: TABLE; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

CREATE TABLE trabajo_taller_ext (
    id_taller_ext integer NOT NULL,
    id_mto_externo integer,
    descripcion character varying,
    repuestos character varying,
    observacion character varying,
    persona_a_cargo character varying,
    recibe character varying
);


ALTER TABLE mantenimientos_mecanica.trabajo_taller_ext OWNER TO postgres;

--
-- Name: trabajo_taller_ext_id_taller_ext_seq; Type: SEQUENCE; Schema: mantenimientos_mecanica; Owner: postgres
--

CREATE SEQUENCE trabajo_taller_ext_id_taller_ext_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mantenimientos_mecanica.trabajo_taller_ext_id_taller_ext_seq OWNER TO postgres;

--
-- Name: trabajo_taller_ext_id_taller_ext_seq; Type: SEQUENCE OWNED BY; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER SEQUENCE trabajo_taller_ext_id_taller_ext_seq OWNED BY trabajo_taller_ext.id_taller_ext;


SET search_path = public, pg_catalog;

--
-- Name: prueba; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prueba (
    hora time without time zone
);


ALTER TABLE public.prueba OWNER TO postgres;

SET search_path = utilidades, pg_catalog;

--
-- Name: alertas_doc_ven_ve; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE alertas_doc_ven_ve (
    id_alerta integer NOT NULL,
    id_vehiculo integer,
    descripcion character varying,
    fecha_alerta timestamp with time zone,
    id_doc_vehiculo integer
);


ALTER TABLE utilidades.alertas_doc_ven_ve OWNER TO postgres;

--
-- Name: TABLE alertas_doc_ven_ve; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE alertas_doc_ven_ve IS 'Alertas de falta de documentación de vehiculos';


--
-- Name: alertas_doc_vencidos_id_alerta_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE alertas_doc_vencidos_id_alerta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.alertas_doc_vencidos_id_alerta_seq OWNER TO postgres;

--
-- Name: alertas_doc_vencidos_id_alerta_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE alertas_doc_vencidos_id_alerta_seq OWNED BY alertas_doc_ven_ve.id_alerta;


--
-- Name: alertas_no_pago_comparendos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE alertas_no_pago_comparendos (
    id_alerta integer NOT NULL,
    fechar_alerta timestamp with time zone,
    descripcion character varying,
    id_comparendo integer
);


ALTER TABLE utilidades.alertas_no_pago_comparendos OWNER TO postgres;

--
-- Name: TABLE alertas_no_pago_comparendos; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE alertas_no_pago_comparendos IS 'Alertas de comparendos';


--
-- Name: alertas_no_pago_comparendos_id_alerta_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE alertas_no_pago_comparendos_id_alerta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.alertas_no_pago_comparendos_id_alerta_seq OWNER TO postgres;

--
-- Name: alertas_no_pago_comparendos_id_alerta_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE alertas_no_pago_comparendos_id_alerta_seq OWNED BY alertas_no_pago_comparendos.id_alerta;


--
-- Name: asignacion_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE asignacion_vehiculo (
    id integer NOT NULL,
    fecha_asignacion date NOT NULL,
    fecha_reg timestamp without time zone DEFAULT now(),
    id_conductor integer NOT NULL,
    id_vehiculo integer NOT NULL,
    estado_entrega boolean DEFAULT true NOT NULL,
    observacion_entrega character varying,
    id_usuario integer NOT NULL,
    cancelar_asignacion boolean DEFAULT false,
    preoperacional boolean DEFAULT true NOT NULL,
    hora_asignacion time without time zone,
    fecha_cancelado timestamp without time zone,
    concepto_cancelado character varying
);


ALTER TABLE utilidades.asignacion_vehiculo OWNER TO postgres;

--
-- Name: asignacion_vehiculo_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE asignacion_vehiculo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.asignacion_vehiculo_id_seq OWNER TO postgres;

--
-- Name: asignacion_vehiculo_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE asignacion_vehiculo_id_seq OWNED BY asignacion_vehiculo.id;


--
-- Name: asignacion_vehiculo_id_usuario_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE asignacion_vehiculo_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.asignacion_vehiculo_id_usuario_seq OWNER TO postgres;

--
-- Name: asignacion_vehiculo_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE asignacion_vehiculo_id_usuario_seq OWNED BY asignacion_vehiculo.id_usuario;


--
-- Name: categoria_pase; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria_pase (
    id integer NOT NULL,
    categoria character varying
);


ALTER TABLE utilidades.categoria_pase OWNER TO postgres;

--
-- Name: categoria_pase_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE categoria_pase_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.categoria_pase_id_seq OWNER TO postgres;

--
-- Name: categoria_pase_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE categoria_pase_id_seq OWNED BY categoria_pase.id;


--
-- Name: centrocostos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE centrocostos (
    nombre_centro_costos character varying NOT NULL,
    sigla_ccostos character varying,
    id_centrocostos integer NOT NULL
);


ALTER TABLE utilidades.centrocostos OWNER TO postgres;

--
-- Name: centroCostos_nombre_centro_costos_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE "centroCostos_nombre_centro_costos_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades."centroCostos_nombre_centro_costos_seq" OWNER TO postgres;

--
-- Name: centroCostos_nombre_centro_costos_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE "centroCostos_nombre_centro_costos_seq" OWNED BY centrocostos.nombre_centro_costos;


--
-- Name: centrocostos_id_centrocostos_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE centrocostos_id_centrocostos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.centrocostos_id_centrocostos_seq OWNER TO postgres;

--
-- Name: centrocostos_id_centrocostos_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE centrocostos_id_centrocostos_seq OWNED BY centrocostos.id_centrocostos;


--
-- Name: comparendos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE comparendos (
    id_comparendo integer NOT NULL,
    fecha_reg timestamp with time zone DEFAULT now() NOT NULL,
    id_vehiculo integer NOT NULL,
    id_conductor integer NOT NULL,
    descripcion_multa character varying NOT NULL,
    num_comparendo character varying NOT NULL,
    estado boolean DEFAULT false,
    valor integer NOT NULL,
    archivo bytea NOT NULL,
    fecha_comparendo date NOT NULL,
    id_usuario integer NOT NULL,
    id character(6),
    nombre character(64)
);


ALTER TABLE utilidades.comparendos OWNER TO postgres;

--
-- Name: TABLE comparendos; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE comparendos IS 'Multas vehiculos';


--
-- Name: comparendos_descripcion_multa_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE comparendos_descripcion_multa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.comparendos_descripcion_multa_seq OWNER TO postgres;

--
-- Name: comparendos_descripcion_multa_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE comparendos_descripcion_multa_seq OWNED BY comparendos.descripcion_multa;


--
-- Name: comparendos_id_comparendo_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE comparendos_id_comparendo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.comparendos_id_comparendo_seq OWNER TO postgres;

--
-- Name: comparendos_id_comparendo_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE comparendos_id_comparendo_seq OWNED BY comparendos.id_comparendo;


--
-- Name: comparendos_num_comparendo_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE comparendos_num_comparendo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.comparendos_num_comparendo_seq OWNER TO postgres;

--
-- Name: comparendos_num_comparendo_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE comparendos_num_comparendo_seq OWNED BY comparendos.num_comparendo;


--
-- Name: conductor; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE conductor (
    id_conductor integer NOT NULL,
    cedula bigint NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    celular character varying,
    tel character varying,
    jefe_inmediato character varying NOT NULL,
    id_area integer NOT NULL,
    activo boolean DEFAULT true,
    direccion character varying,
    eps character varying,
    arl character varying,
    id_usuario integer,
    fecha_reg timestamp without time zone DEFAULT now(),
    id_usuario_mod integer,
    fecha_mod timestamp without time zone,
    foto boolean DEFAULT false
);


ALTER TABLE utilidades.conductor OWNER TO postgres;

--
-- Name: conductor_id_conductor_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE conductor_id_conductor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.conductor_id_conductor_seq OWNER TO postgres;

--
-- Name: conductor_id_conductor_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE conductor_id_conductor_seq OWNED BY conductor.id_conductor;


--
-- Name: dependencia; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE dependencia (
    id integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.dependencia OWNER TO postgres;

--
-- Name: dependencia_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE dependencia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.dependencia_id_seq OWNER TO postgres;

--
-- Name: dependencia_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE dependencia_id_seq OWNED BY dependencia.id;


--
-- Name: doc_conductor; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE doc_conductor (
    id integer NOT NULL,
    fecha_reg timestamp without time zone DEFAULT now(),
    num_licencia character varying,
    categoria character varying,
    desde date,
    hasta date,
    restriccion character varying,
    id_usuario integer,
    activo boolean DEFAULT true,
    id_conductor integer,
    id_tipo_doc integer,
    doc_vence boolean,
    id_a character(6),
    nombre character(64),
    archivo bytea
);


ALTER TABLE utilidades.doc_conductor OWNER TO postgres;

--
-- Name: TABLE doc_conductor; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE doc_conductor IS 'Documento de conductor';


--
-- Name: doc_conductor_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE doc_conductor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.doc_conductor_id_seq OWNER TO postgres;

--
-- Name: doc_conductor_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE doc_conductor_id_seq OWNED BY doc_conductor.id;


--
-- Name: documentacion_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE documentacion_vehiculo (
    id_doc integer NOT NULL,
    id_vehiculo integer,
    fecha_reg timestamp without time zone DEFAULT now(),
    fecha_vencimiento date,
    doc_vence boolean,
    activo boolean DEFAULT true,
    id_tipo_doc integer,
    archivo bytea,
    id_usuario integer,
    id character(6),
    nombre character(64),
    fecha_inicio date,
    n_documento character varying
);


ALTER TABLE utilidades.documentacion_vehiculo OWNER TO postgres;

--
-- Name: documentacion_vehiculo_id_doc_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE documentacion_vehiculo_id_doc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.documentacion_vehiculo_id_doc_seq OWNER TO postgres;

--
-- Name: documentacion_vehiculo_id_doc_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE documentacion_vehiculo_id_doc_seq OWNED BY documentacion_vehiculo.id_doc;


--
-- Name: estaciones_servicio; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE estaciones_servicio (
    est_ser_id integer NOT NULL,
    est_ser_desc character varying
);


ALTER TABLE utilidades.estaciones_servicio OWNER TO postgres;

--
-- Name: estaciones_servicio_est_ser_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE estaciones_servicio_est_ser_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.estaciones_servicio_est_ser_id_seq OWNER TO postgres;

--
-- Name: estaciones_servicio_est_ser_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE estaciones_servicio_est_ser_id_seq OWNED BY estaciones_servicio.est_ser_id;


--
-- Name: ficha_tecnica_vehiculo_equipo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE ficha_tecnica_vehiculo_equipo (
    id_ficha integer NOT NULL,
    id_vehiculo integer,
    tipo_carroceria character varying,
    modelo character varying,
    serie character varying,
    chasis character varying,
    n_motor character varying,
    color character varying,
    cilindraje character varying,
    n_pasajeros character varying,
    motor_arranque character varying,
    v_marcha_minima character varying,
    peso_bruto character varying,
    cap_aceite_motor character varying,
    cap_refrigerante character varying,
    cap_tan_combustible character varying,
    tipo_caja_cambios character varying,
    cap_caja_cambios character varying,
    tipo_direccion character varying,
    cap_aceite_direccion character varying,
    tipo_diferencial character varying,
    cap_aceite_diferencial character varying,
    n_rin_rueda character varying,
    referencia_llanta character varying,
    presion_inflado character varying,
    referencia_bateria character varying,
    alternador character varying,
    id_usuario integer DEFAULT 2,
    fecha_creacion timestamp with time zone DEFAULT ('now'::text)::date,
    id_usuario_mod integer DEFAULT 2,
    fecha_mod timestamp with time zone DEFAULT ('now'::text)::date
);


ALTER TABLE utilidades.ficha_tecnica_vehiculo_equipo OWNER TO postgres;

--
-- Name: ficha_tecnica_vehiculo_equipo_id_ficha_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE ficha_tecnica_vehiculo_equipo_id_ficha_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.ficha_tecnica_vehiculo_equipo_id_ficha_seq OWNER TO postgres;

--
-- Name: ficha_tecnica_vehiculo_equipo_id_ficha_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE ficha_tecnica_vehiculo_equipo_id_ficha_seq OWNED BY ficha_tecnica_vehiculo_equipo.id_ficha;


--
-- Name: forma_pago; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE forma_pago (
    id_forma integer NOT NULL,
    descripcion_pago character varying
);


ALTER TABLE utilidades.forma_pago OWNER TO postgres;

--
-- Name: TABLE forma_pago; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE forma_pago IS 'Forma de pago';


--
-- Name: forma_pago_id_forma_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE forma_pago_id_forma_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.forma_pago_id_forma_seq OWNER TO postgres;

--
-- Name: forma_pago_id_forma_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE forma_pago_id_forma_seq OWNED BY forma_pago.id_forma;


--
-- Name: foto_conductor; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE foto_conductor (
    id character(6),
    nombre character(64),
    foto bytea,
    id_conductor integer,
    id_foto integer NOT NULL
);


ALTER TABLE utilidades.foto_conductor OWNER TO postgres;

--
-- Name: foto_conductor_id_foto_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE foto_conductor_id_foto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.foto_conductor_id_foto_seq OWNER TO postgres;

--
-- Name: foto_conductor_id_foto_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE foto_conductor_id_foto_seq OWNED BY foto_conductor.id_foto;


--
-- Name: foto_vehiculos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE foto_vehiculos (
    id_foto integer NOT NULL,
    id character(6),
    nombre character(64),
    foto bytea,
    id_vehiculo_equipo integer
);


ALTER TABLE utilidades.foto_vehiculos OWNER TO postgres;

--
-- Name: foto_vehiculos_id_foto_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE foto_vehiculos_id_foto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.foto_vehiculos_id_foto_seq OWNER TO postgres;

--
-- Name: foto_vehiculos_id_foto_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE foto_vehiculos_id_foto_seq OWNED BY foto_vehiculos.id_foto;


--
-- Name: itemccostos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE itemccostos (
    id_item_ccostos integer NOT NULL,
    nombre_item_ccostos character varying,
    id_centrocostos integer
);


ALTER TABLE utilidades.itemccostos OWNER TO postgres;

--
-- Name: item_ccostos_id_item_ccostos_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE item_ccostos_id_item_ccostos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.item_ccostos_id_item_ccostos_seq OWNER TO postgres;

--
-- Name: item_ccostos_id_item_ccostos_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE item_ccostos_id_item_ccostos_seq OWNED BY itemccostos.id_item_ccostos;


--
-- Name: items_sistema; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE items_sistema (
    id integer NOT NULL,
    descripcion character varying,
    id_sistema integer
);


ALTER TABLE utilidades.items_sistema OWNER TO postgres;

--
-- Name: TABLE items_sistema; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE items_sistema IS 'Items Sistema Auotmotor';


--
-- Name: items_sistema_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE items_sistema_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.items_sistema_id_seq OWNER TO postgres;

--
-- Name: items_sistema_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE items_sistema_id_seq OWNED BY items_sistema.id;


--
-- Name: labor_mecanico; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE labor_mecanico (
    id_labor integer NOT NULL,
    labor character varying,
    dur_labor double precision,
    costo integer,
    id_rutina integer
);


ALTER TABLE utilidades.labor_mecanico OWNER TO postgres;

--
-- Name: labor_mecanico_id_labor_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE labor_mecanico_id_labor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.labor_mecanico_id_labor_seq OWNER TO postgres;

--
-- Name: labor_mecanico_id_labor_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE labor_mecanico_id_labor_seq OWNED BY labor_mecanico.id_labor;


--
-- Name: level; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE level (
    id_level integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.level OWNER TO postgres;

--
-- Name: level_id_level_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE level_id_level_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.level_id_level_seq OWNER TO postgres;

--
-- Name: level_id_level_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE level_id_level_seq OWNED BY level.id_level;


--
-- Name: linea_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE linea_vehiculo (
    id_linea_vehi integer NOT NULL,
    descripcion character varying,
    id_marca integer
);


ALTER TABLE utilidades.linea_vehiculo OWNER TO postgres;

--
-- Name: linea_vehiculo_id_linea_vehi_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE linea_vehiculo_id_linea_vehi_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.linea_vehiculo_id_linea_vehi_seq OWNER TO postgres;

--
-- Name: linea_vehiculo_id_linea_vehi_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE linea_vehiculo_id_linea_vehi_seq OWNED BY linea_vehiculo.id_linea_vehi;


--
-- Name: marca_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE marca_vehiculo (
    id_marca integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.marca_vehiculo OWNER TO postgres;

--
-- Name: marca_vehiculo_id_marca_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE marca_vehiculo_id_marca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.marca_vehiculo_id_marca_seq OWNER TO postgres;

--
-- Name: marca_vehiculo_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE marca_vehiculo_id_marca_seq OWNED BY marca_vehiculo.id_marca;


--
-- Name: mecanico_utd; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE mecanico_utd (
    id_meca integer NOT NULL,
    nombre_apellido character varying NOT NULL,
    cedula bigint NOT NULL,
    cel bigint,
    tel integer,
    observacion character varying,
    activo boolean DEFAULT true,
    direccion character varying,
    eps character varying
);


ALTER TABLE utilidades.mecanico_utd OWNER TO postgres;

--
-- Name: mecanico_utd_id_meca_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE mecanico_utd_id_meca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.mecanico_utd_id_meca_seq OWNER TO postgres;

--
-- Name: mecanico_utd_id_meca_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE mecanico_utd_id_meca_seq OWNED BY mecanico_utd.id_meca;


--
-- Name: mes; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE mes (
    id_mes integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.mes OWNER TO postgres;

--
-- Name: mes_id_mes_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE mes_id_mes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.mes_id_mes_seq OWNER TO postgres;

--
-- Name: mes_id_mes_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE mes_id_mes_seq OWNED BY mes.id_mes;


--
-- Name: pagos_comparendos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE pagos_comparendos (
    id_pago integer NOT NULL,
    id_comparendo integer NOT NULL,
    fecha_pago date NOT NULL,
    valor integer NOT NULL,
    fecha_reg timestamp with time zone DEFAULT now(),
    descripcion character varying NOT NULL,
    archivo bytea,
    paz_salvo_num character varying NOT NULL,
    id_forma_pago integer,
    id_usuario integer,
    id character(6),
    nombre character(64)
);


ALTER TABLE utilidades.pagos_comparendos OWNER TO postgres;

--
-- Name: TABLE pagos_comparendos; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE pagos_comparendos IS 'Pagos realizados a comparendos registrados';


--
-- Name: pagos_comparendos_id_pago_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE pagos_comparendos_id_pago_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.pagos_comparendos_id_pago_seq OWNER TO postgres;

--
-- Name: pagos_comparendos_id_pago_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE pagos_comparendos_id_pago_seq OWNED BY pagos_comparendos.id_pago;


--
-- Name: rutina; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE rutina (
    id_rutina integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.rutina OWNER TO postgres;

--
-- Name: TABLE rutina; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE rutina IS 'Rutina de los vehiculos / equipos para mto.';


--
-- Name: rutina_id_rutina_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE rutina_id_rutina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.rutina_id_rutina_seq OWNER TO postgres;

--
-- Name: rutina_id_rutina_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE rutina_id_rutina_seq OWNED BY rutina.id_rutina;


--
-- Name: sistema_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE sistema_vehiculo (
    id_sistema integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.sistema_vehiculo OWNER TO postgres;

--
-- Name: sistema_vehiculo_id_sistema_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE sistema_vehiculo_id_sistema_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.sistema_vehiculo_id_sistema_seq OWNER TO postgres;

--
-- Name: sistema_vehiculo_id_sistema_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE sistema_vehiculo_id_sistema_seq OWNED BY sistema_vehiculo.id_sistema;


--
-- Name: talleres_externos_mec; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE talleres_externos_mec (
    id integer NOT NULL,
    direccion character varying,
    observacion character varying,
    razon_social character varying,
    nit bigint,
    persona_encargada character varying,
    telefono integer,
    celular bigint,
    ciudad character varying
);


ALTER TABLE utilidades.talleres_externos_mec OWNER TO postgres;

--
-- Name: talleres_externos_mec_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE talleres_externos_mec_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.talleres_externos_mec_id_seq OWNER TO postgres;

--
-- Name: talleres_externos_mec_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE talleres_externos_mec_id_seq OWNED BY talleres_externos_mec.id;


--
-- Name: tipo_combustible; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_combustible (
    name_combustible character varying,
    id_tipo_com integer NOT NULL
);


ALTER TABLE utilidades.tipo_combustible OWNER TO postgres;

--
-- Name: tipo_combustible_id_tipo_com_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE tipo_combustible_id_tipo_com_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.tipo_combustible_id_tipo_com_seq OWNER TO postgres;

--
-- Name: tipo_combustible_id_tipo_com_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE tipo_combustible_id_tipo_com_seq OWNED BY tipo_combustible.id_tipo_com;


--
-- Name: tipo_doc; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_doc (
    id integer NOT NULL,
    tipo_doc character varying
);


ALTER TABLE utilidades.tipo_doc OWNER TO postgres;

--
-- Name: tipo_doc_id_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE tipo_doc_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.tipo_doc_id_seq OWNER TO postgres;

--
-- Name: tipo_doc_id_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE tipo_doc_id_seq OWNED BY tipo_doc.id;


--
-- Name: tipo_mto; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_mto (
    id_tipo_mto integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.tipo_mto OWNER TO postgres;

--
-- Name: TABLE tipo_mto; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON TABLE tipo_mto IS 'Tipo de mantenimiento que se realiza a los vehiculos / equipos';


--
-- Name: tipo_mto_id_tipo_mto_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE tipo_mto_id_tipo_mto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.tipo_mto_id_tipo_mto_seq OWNER TO postgres;

--
-- Name: tipo_mto_id_tipo_mto_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE tipo_mto_id_tipo_mto_seq OWNED BY tipo_mto.id_tipo_mto;


--
-- Name: tipo_vehiculo; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_vehiculo (
    id_tipo_vehi integer NOT NULL,
    descripcion character varying
);


ALTER TABLE utilidades.tipo_vehiculo OWNER TO postgres;

--
-- Name: tipo_vehiculo_id_tipo_vehi_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE tipo_vehiculo_id_tipo_vehi_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.tipo_vehiculo_id_tipo_vehi_seq OWNER TO postgres;

--
-- Name: tipo_vehiculo_id_tipo_vehi_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE tipo_vehiculo_id_tipo_vehi_seq OWNED BY tipo_vehiculo.id_tipo_vehi;


--
-- Name: usuarios; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id_usuario integer NOT NULL,
    usuario character varying,
    passw character varying,
    nom_apell character varying,
    id_level integer,
    activo boolean DEFAULT true
);


ALTER TABLE utilidades.usuarios OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.usuarios_id_usuario_seq OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE usuarios_id_usuario_seq OWNED BY usuarios.id_usuario;


--
-- Name: vehiculos_equipos; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE vehiculos_equipos (
    id_vehiculo integer NOT NULL,
    placa_identi character varying,
    id_tipo_com integer,
    id_tipo_vehiculo integer,
    id_linea integer,
    id_item_ccostos integer,
    estado boolean DEFAULT true,
    id_2tipo_com integer,
    consecutivo_mto_interno integer DEFAULT 0,
    consecutivo_mto_externo integer DEFAULT 0,
    ficha_tecnica boolean DEFAULT false,
    id_usuario integer DEFAULT 2,
    fecha_creacion timestamp with time zone DEFAULT ('now'::text)::date,
    foto boolean DEFAULT false
);


ALTER TABLE utilidades.vehiculos_equipos OWNER TO postgres;

--
-- Name: COLUMN vehiculos_equipos.ficha_tecnica; Type: COMMENT; Schema: utilidades; Owner: postgres
--

COMMENT ON COLUMN vehiculos_equipos.ficha_tecnica IS 'True---Cuando tenga relacionado la ficha, False-- Cuando no tenga relacionado la ficha tecnica';


--
-- Name: vehiculos_equipos_id_vehiculo_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE vehiculos_equipos_id_vehiculo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.vehiculos_equipos_id_vehiculo_seq OWNER TO postgres;

--
-- Name: vehiculos_equipos_id_vehiculo_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE vehiculos_equipos_id_vehiculo_seq OWNED BY vehiculos_equipos.id_vehiculo;


--
-- Name: year; Type: TABLE; Schema: utilidades; Owner: postgres; Tablespace: 
--

CREATE TABLE year (
    id_year integer NOT NULL,
    year integer
);


ALTER TABLE utilidades.year OWNER TO postgres;

--
-- Name: year_id_year_seq; Type: SEQUENCE; Schema: utilidades; Owner: postgres
--

CREATE SEQUENCE year_id_year_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilidades.year_id_year_seq OWNER TO postgres;

--
-- Name: year_id_year_seq; Type: SEQUENCE OWNED BY; Schema: utilidades; Owner: postgres
--

ALTER SEQUENCE year_id_year_seq OWNED BY year.id_year;


SET search_path = consumo_combustible, pg_catalog;

--
-- Name: id_ce; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY consumo_estacion ALTER COLUMN id_ce SET DEFAULT nextval('consumo_estacion_id_ce_seq'::regclass);


--
-- Name: ctrl_com_id; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible ALTER COLUMN ctrl_com_id SET DEFAULT nextval('control_combustible_ctrl_com_id_seq'::regclass);


--
-- Name: id_det_ceds; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_con_eds ALTER COLUMN id_det_ceds SET DEFAULT nextval('det_con_eds_id_det_ceds_seq'::regclass);


--
-- Name: det_ctrl_com_id; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_control_combustible ALTER COLUMN det_ctrl_com_id SET DEFAULT nextval('det_control_combustible_det_ctrl_com_id_seq'::regclass);


--
-- Name: id_num; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY doc_control_combustible ALTER COLUMN id_num SET DEFAULT nextval('doc_control_combustible_id_num_seq'::regclass);


--
-- Name: id_notan; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY no_tanqueo ALTER COLUMN id_notan SET DEFAULT nextval('no_tanqueo_id_notan_seq'::regclass);


--
-- Name: id_total; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_ccostos_ce ALTER COLUMN id_total SET DEFAULT nextval('total_ccostos_ce_id_total_seq'::regclass);


--
-- Name: t_ctrl_com_id; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_control_combustible ALTER COLUMN t_ctrl_com_id SET DEFAULT nextval('total_control_combustible_t_ctrl_com_id_seq'::regclass);


--
-- Name: t_gal_id; Type: DEFAULT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_galones ALTER COLUMN t_gal_id SET DEFAULT nextval('total_galones_t_gal_id_seq'::regclass);


SET search_path = informes_mensuales, pg_catalog;

--
-- Name: id_det; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY det_inf_mens ALTER COLUMN id_det SET DEFAULT nextval('det_inf_mens_id_det_seq'::regclass);


--
-- Name: id_det; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY det_men_eds ALTER COLUMN id_det SET DEFAULT nextval('det_men_eds_id_det_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_ctrl ALTER COLUMN id SET DEFAULT nextval('mensual_ctrl_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_eds ALTER COLUMN id SET DEFAULT nextval('mensual_eds_id_seq'::regclass);


--
-- Name: id_total_ccostos; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY total_ccostos_inf_men ALTER COLUMN id_total_ccostos SET DEFAULT nextval('total_ccostos_inf_men_id_total_ccostos_seq'::regclass);


--
-- Name: id_total_gal; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY total_gal_inf_men ALTER COLUMN id_total_gal SET DEFAULT nextval('total_gal_inf_men_id_total_gal_seq'::regclass);


--
-- Name: id_total_gal; Type: DEFAULT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY total_gal_men_eds ALTER COLUMN id_total_gal SET DEFAULT nextval('total_gal_men_eds_id_total_gal_seq'::regclass);


SET search_path = mantenimientos_mecanica, pg_catalog;

--
-- Name: id_ctr_fact; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY control_fact_mto_externo ALTER COLUMN id_ctr_fact SET DEFAULT nextval('control_fact_mto_externo_id_ctr_fact_seq'::regclass);


--
-- Name: id_cos_fact; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY cos_fact_mto_ext ALTER COLUMN id_cos_fact SET DEFAULT nextval('cos_fact_mto_ext_id_cos_fact_seq'::regclass);


--
-- Name: id_dt; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_cos_fact_mto_ext ALTER COLUMN id_dt SET DEFAULT nextval('dt_cos_fact_mto_ext_id_dt_seq'::regclass);


--
-- Name: id_dt_mto_interno; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_mto_interno ALTER COLUMN id_dt_mto_interno SET DEFAULT nextval('dt_mto_interno_id_dt_mto_interno_seq'::regclass);


--
-- Name: id_dt_mto_ex; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dte_mto_externo ALTER COLUMN id_dt_mto_ex SET DEFAULT nextval('dte_mto_externo_id_dt_mto_ex_seq'::regclass);


--
-- Name: id_dtlle; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dtlle_ctrl_fact ALTER COLUMN id_dtlle SET DEFAULT nextval('dtlle_ctrl_fact_id_dtlle_seq'::regclass);


--
-- Name: id_mto_interno; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos ALTER COLUMN id_mto_interno SET DEFAULT nextval('mto_internos_id_mto_interno_seq'::regclass);


--
-- Name: id_mto_externo; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos ALTER COLUMN id_mto_externo SET DEFAULT nextval('mtos_externos_id_mto_externo_seq'::regclass);


--
-- Name: id_taller_ext; Type: DEFAULT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY trabajo_taller_ext ALTER COLUMN id_taller_ext SET DEFAULT nextval('trabajo_taller_ext_id_taller_ext_seq'::regclass);


SET search_path = utilidades, pg_catalog;

--
-- Name: id_alerta; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY alertas_doc_ven_ve ALTER COLUMN id_alerta SET DEFAULT nextval('alertas_doc_vencidos_id_alerta_seq'::regclass);


--
-- Name: id_alerta; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY alertas_no_pago_comparendos ALTER COLUMN id_alerta SET DEFAULT nextval('alertas_no_pago_comparendos_id_alerta_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY asignacion_vehiculo ALTER COLUMN id SET DEFAULT nextval('asignacion_vehiculo_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY categoria_pase ALTER COLUMN id SET DEFAULT nextval('categoria_pase_id_seq'::regclass);


--
-- Name: id_centrocostos; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY centrocostos ALTER COLUMN id_centrocostos SET DEFAULT nextval('centrocostos_id_centrocostos_seq'::regclass);


--
-- Name: id_comparendo; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY comparendos ALTER COLUMN id_comparendo SET DEFAULT nextval('comparendos_id_comparendo_seq'::regclass);


--
-- Name: id_conductor; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY conductor ALTER COLUMN id_conductor SET DEFAULT nextval('conductor_id_conductor_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY dependencia ALTER COLUMN id SET DEFAULT nextval('dependencia_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY doc_conductor ALTER COLUMN id SET DEFAULT nextval('doc_conductor_id_seq'::regclass);


--
-- Name: id_doc; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY documentacion_vehiculo ALTER COLUMN id_doc SET DEFAULT nextval('documentacion_vehiculo_id_doc_seq'::regclass);


--
-- Name: est_ser_id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY estaciones_servicio ALTER COLUMN est_ser_id SET DEFAULT nextval('estaciones_servicio_est_ser_id_seq'::regclass);


--
-- Name: id_ficha; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY ficha_tecnica_vehiculo_equipo ALTER COLUMN id_ficha SET DEFAULT nextval('ficha_tecnica_vehiculo_equipo_id_ficha_seq'::regclass);


--
-- Name: id_forma; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY forma_pago ALTER COLUMN id_forma SET DEFAULT nextval('forma_pago_id_forma_seq'::regclass);


--
-- Name: id_foto; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY foto_conductor ALTER COLUMN id_foto SET DEFAULT nextval('foto_conductor_id_foto_seq'::regclass);


--
-- Name: id_foto; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY foto_vehiculos ALTER COLUMN id_foto SET DEFAULT nextval('foto_vehiculos_id_foto_seq'::regclass);


--
-- Name: id_item_ccostos; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY itemccostos ALTER COLUMN id_item_ccostos SET DEFAULT nextval('item_ccostos_id_item_ccostos_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY items_sistema ALTER COLUMN id SET DEFAULT nextval('items_sistema_id_seq'::regclass);


--
-- Name: id_labor; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY labor_mecanico ALTER COLUMN id_labor SET DEFAULT nextval('labor_mecanico_id_labor_seq'::regclass);


--
-- Name: id_level; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY level ALTER COLUMN id_level SET DEFAULT nextval('level_id_level_seq'::regclass);


--
-- Name: id_linea_vehi; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY linea_vehiculo ALTER COLUMN id_linea_vehi SET DEFAULT nextval('linea_vehiculo_id_linea_vehi_seq'::regclass);


--
-- Name: id_marca; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY marca_vehiculo ALTER COLUMN id_marca SET DEFAULT nextval('marca_vehiculo_id_marca_seq'::regclass);


--
-- Name: id_meca; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY mecanico_utd ALTER COLUMN id_meca SET DEFAULT nextval('mecanico_utd_id_meca_seq'::regclass);


--
-- Name: id_mes; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY mes ALTER COLUMN id_mes SET DEFAULT nextval('mes_id_mes_seq'::regclass);


--
-- Name: id_pago; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY pagos_comparendos ALTER COLUMN id_pago SET DEFAULT nextval('pagos_comparendos_id_pago_seq'::regclass);


--
-- Name: id_rutina; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY rutina ALTER COLUMN id_rutina SET DEFAULT nextval('rutina_id_rutina_seq'::regclass);


--
-- Name: id_sistema; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY sistema_vehiculo ALTER COLUMN id_sistema SET DEFAULT nextval('sistema_vehiculo_id_sistema_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY talleres_externos_mec ALTER COLUMN id SET DEFAULT nextval('talleres_externos_mec_id_seq'::regclass);


--
-- Name: id_tipo_com; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY tipo_combustible ALTER COLUMN id_tipo_com SET DEFAULT nextval('tipo_combustible_id_tipo_com_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY tipo_doc ALTER COLUMN id SET DEFAULT nextval('tipo_doc_id_seq'::regclass);


--
-- Name: id_tipo_mto; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY tipo_mto ALTER COLUMN id_tipo_mto SET DEFAULT nextval('tipo_mto_id_tipo_mto_seq'::regclass);


--
-- Name: id_tipo_vehi; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY tipo_vehiculo ALTER COLUMN id_tipo_vehi SET DEFAULT nextval('tipo_vehiculo_id_tipo_vehi_seq'::regclass);


--
-- Name: id_usuario; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('usuarios_id_usuario_seq'::regclass);


--
-- Name: id_vehiculo; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos ALTER COLUMN id_vehiculo SET DEFAULT nextval('vehiculos_equipos_id_vehiculo_seq'::regclass);


--
-- Name: id_year; Type: DEFAULT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY year ALTER COLUMN id_year SET DEFAULT nextval('year_id_year_seq'::regclass);


SET search_path = consumo_combustible, pg_catalog;

--
-- Name: consumo_estacion_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY consumo_estacion
    ADD CONSTRAINT consumo_estacion_pkey PRIMARY KEY (id_ce);


--
-- Name: control_combustible_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT control_combustible_pkey PRIMARY KEY (ctrl_com_id);


--
-- Name: det_con_eds_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_con_eds
    ADD CONSTRAINT det_con_eds_pkey PRIMARY KEY (id_det_ceds);


--
-- Name: det_control_combustible_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_control_combustible
    ADD CONSTRAINT det_control_combustible_pkey PRIMARY KEY (det_ctrl_com_id);


--
-- Name: doc_control_combustible_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY doc_control_combustible
    ADD CONSTRAINT doc_control_combustible_pkey PRIMARY KEY (id_num);


--
-- Name: no_tanqueo_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY no_tanqueo
    ADD CONSTRAINT no_tanqueo_pkey PRIMARY KEY (id_notan);


--
-- Name: total_ccostos_ce_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_ccostos_ce
    ADD CONSTRAINT total_ccostos_ce_pkey PRIMARY KEY (id_total);


--
-- Name: total_control_combustible_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_control_combustible
    ADD CONSTRAINT total_control_combustible_pkey PRIMARY KEY (t_ctrl_com_id);


--
-- Name: total_galones_pkey; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_galones
    ADD CONSTRAINT total_galones_pkey PRIMARY KEY (t_gal_id);


--
-- Name: unique_num_cta; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY consumo_estacion
    ADD CONSTRAINT unique_num_cta UNIQUE (num_cta);


--
-- Name: unique_rc_esta; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_control_combustible
    ADD CONSTRAINT unique_rc_esta UNIQUE (det_ctrl_com_rc_esta);


--
-- Name: unique_vale_ceds; Type: CONSTRAINT; Schema: consumo_combustible; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_con_eds
    ADD CONSTRAINT unique_vale_ceds UNIQUE (vale_eds);


SET search_path = informes_mensuales, pg_catalog;

--
-- Name: det_inf_mens_pkey; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_inf_mens
    ADD CONSTRAINT det_inf_mens_pkey PRIMARY KEY (id_det);


--
-- Name: mensual_ctrl_pkey; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mensual_ctrl
    ADD CONSTRAINT mensual_ctrl_pkey PRIMARY KEY (id);


--
-- Name: pk_id; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mensual_eds
    ADD CONSTRAINT pk_id PRIMARY KEY (id);


--
-- Name: pk_iddet; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_men_eds
    ADD CONSTRAINT pk_iddet PRIMARY KEY (id_det);


--
-- Name: pk_idtotal; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_gal_men_eds
    ADD CONSTRAINT pk_idtotal PRIMARY KEY (id_total_gal);


--
-- Name: total_ccostos_inf_men_pkey; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_ccostos_inf_men
    ADD CONSTRAINT total_ccostos_inf_men_pkey PRIMARY KEY (id_total_ccostos);


--
-- Name: total_gal_inf_men_pkey; Type: CONSTRAINT; Schema: informes_mensuales; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY total_gal_inf_men
    ADD CONSTRAINT total_gal_inf_men_pkey PRIMARY KEY (id_total_gal);


SET search_path = mantenimientos_mecanica, pg_catalog;

--
-- Name: control_fact_mto_externo_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_fact_mto_externo
    ADD CONSTRAINT control_fact_mto_externo_pkey PRIMARY KEY (id_ctr_fact);


--
-- Name: cos_fact_mto_ext_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cos_fact_mto_ext
    ADD CONSTRAINT cos_fact_mto_ext_pkey PRIMARY KEY (id_cos_fact);


--
-- Name: dt_cos_fact_mto_ext_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dt_cos_fact_mto_ext
    ADD CONSTRAINT dt_cos_fact_mto_ext_pkey PRIMARY KEY (id_dt);


--
-- Name: dte_mto_externo_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dte_mto_externo
    ADD CONSTRAINT dte_mto_externo_pkey PRIMARY KEY (id_dt_mto_ex);


--
-- Name: dtlle_ctrl_fact_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dtlle_ctrl_fact
    ADD CONSTRAINT dtlle_ctrl_fact_pkey PRIMARY KEY (id_dtlle);


--
-- Name: mtos_externos_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT mtos_externos_pkey PRIMARY KEY (id_mto_externo);


--
-- Name: pk_dt_mto_interno; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dt_mto_interno
    ADD CONSTRAINT pk_dt_mto_interno PRIMARY KEY (id_dt_mto_interno);


--
-- Name: pk_idmto_interno; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT pk_idmto_interno PRIMARY KEY (id_mto_interno);


--
-- Name: trabajo_taller_ext_pkey; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY trabajo_taller_ext
    ADD CONSTRAINT trabajo_taller_ext_pkey PRIMARY KEY (id_taller_ext);


--
-- Name: unique_fact; Type: CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dt_cos_fact_mto_ext
    ADD CONSTRAINT unique_fact UNIQUE (fact_num);


SET search_path = utilidades, pg_catalog;

--
-- Name: alertas_doc_vencidos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY alertas_doc_ven_ve
    ADD CONSTRAINT alertas_doc_vencidos_pkey PRIMARY KEY (id_alerta);


--
-- Name: alertas_no_pago_comparendos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY alertas_no_pago_comparendos
    ADD CONSTRAINT alertas_no_pago_comparendos_pkey PRIMARY KEY (id_alerta);


--
-- Name: asignacion_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asignacion_vehiculo
    ADD CONSTRAINT asignacion_vehiculo_pkey PRIMARY KEY (id);


--
-- Name: categoria_pase_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria_pase
    ADD CONSTRAINT categoria_pase_pkey PRIMARY KEY (id);


--
-- Name: comparendos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comparendos
    ADD CONSTRAINT comparendos_pkey PRIMARY KEY (id_comparendo);


--
-- Name: conductor_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY conductor
    ADD CONSTRAINT conductor_pkey PRIMARY KEY (id_conductor);


--
-- Name: dependencia_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dependencia
    ADD CONSTRAINT dependencia_pkey PRIMARY KEY (id);


--
-- Name: doc_conductor_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY doc_conductor
    ADD CONSTRAINT doc_conductor_pkey PRIMARY KEY (id);


--
-- Name: documentacion_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documentacion_vehiculo
    ADD CONSTRAINT documentacion_vehiculo_pkey PRIMARY KEY (id_doc);


--
-- Name: estaciones_servicio_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estaciones_servicio
    ADD CONSTRAINT estaciones_servicio_pkey PRIMARY KEY (est_ser_id);


--
-- Name: ficha_tecnica_vehiculo_equipo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ficha_tecnica_vehiculo_equipo
    ADD CONSTRAINT ficha_tecnica_vehiculo_equipo_pkey PRIMARY KEY (id_ficha);


--
-- Name: forma_pago_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY forma_pago
    ADD CONSTRAINT forma_pago_pkey PRIMARY KEY (id_forma);


--
-- Name: foto_vehiculos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY foto_vehiculos
    ADD CONSTRAINT foto_vehiculos_pkey PRIMARY KEY (id_foto);


--
-- Name: items_sistema_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY items_sistema
    ADD CONSTRAINT items_sistema_pkey PRIMARY KEY (id);


--
-- Name: labor_mecanico_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY labor_mecanico
    ADD CONSTRAINT labor_mecanico_pkey PRIMARY KEY (id_labor);


--
-- Name: level_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY level
    ADD CONSTRAINT level_pkey PRIMARY KEY (id_level);


--
-- Name: linea_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY linea_vehiculo
    ADD CONSTRAINT linea_vehiculo_pkey PRIMARY KEY (id_linea_vehi);


--
-- Name: marca_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY marca_vehiculo
    ADD CONSTRAINT marca_vehiculo_pkey PRIMARY KEY (id_marca);


--
-- Name: mecanico_utd_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mecanico_utd
    ADD CONSTRAINT mecanico_utd_pkey PRIMARY KEY (id_meca);


--
-- Name: mes_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mes
    ADD CONSTRAINT mes_pkey PRIMARY KEY (id_mes);


--
-- Name: pagos_comparendos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagos_comparendos
    ADD CONSTRAINT pagos_comparendos_pkey PRIMARY KEY (id_pago);


--
-- Name: pk_ccostos; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY centrocostos
    ADD CONSTRAINT pk_ccostos PRIMARY KEY (id_centrocostos);


--
-- Name: pk_idfoto; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY foto_conductor
    ADD CONSTRAINT pk_idfoto PRIMARY KEY (id_foto);


--
-- Name: pk_idtipocom; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_combustible
    ADD CONSTRAINT pk_idtipocom PRIMARY KEY (id_tipo_com);


--
-- Name: pk_idusuario; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT pk_idusuario PRIMARY KEY (id_usuario);


--
-- Name: pk_itemccostos; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY itemccostos
    ADD CONSTRAINT pk_itemccostos PRIMARY KEY (id_item_ccostos);


--
-- Name: rutina_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rutina
    ADD CONSTRAINT rutina_pkey PRIMARY KEY (id_rutina);


--
-- Name: sistema_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sistema_vehiculo
    ADD CONSTRAINT sistema_vehiculo_pkey PRIMARY KEY (id_sistema);


--
-- Name: talleres_externos_mec_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talleres_externos_mec
    ADD CONSTRAINT talleres_externos_mec_pkey PRIMARY KEY (id);


--
-- Name: tipo_doc_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_doc
    ADD CONSTRAINT tipo_doc_pkey PRIMARY KEY (id);


--
-- Name: tipo_mto_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_mto
    ADD CONSTRAINT tipo_mto_pkey PRIMARY KEY (id_tipo_mto);


--
-- Name: tipo_vehiculo_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_vehiculo
    ADD CONSTRAINT tipo_vehiculo_pkey PRIMARY KEY (id_tipo_vehi);


--
-- Name: uni_ced; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY conductor
    ADD CONSTRAINT uni_ced UNIQUE (cedula);


--
-- Name: unique_cedula; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mecanico_utd
    ADD CONSTRAINT unique_cedula UNIQUE (cedula);


--
-- Name: unique_comparendo; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comparendos
    ADD CONSTRAINT unique_comparendo UNIQUE (num_comparendo);


--
-- Name: unique_identi; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT unique_identi UNIQUE (placa_identi);


--
-- Name: unique_ndocumento; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documentacion_vehiculo
    ADD CONSTRAINT unique_ndocumento UNIQUE (n_documento);


--
-- Name: unique_nit; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talleres_externos_mec
    ADD CONSTRAINT unique_nit UNIQUE (nit);


--
-- Name: unique_paz_salvo; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagos_comparendos
    ADD CONSTRAINT unique_paz_salvo UNIQUE (paz_salvo_num);


--
-- Name: vehiculos_equipos_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT vehiculos_equipos_pkey PRIMARY KEY (id_vehiculo);


--
-- Name: year_pkey; Type: CONSTRAINT; Schema: utilidades; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY year
    ADD CONSTRAINT year_pkey PRIMARY KEY (id_year);


SET search_path = consumo_combustible, pg_catalog;

--
-- Name: det_control_combustible_esta_ser_id_fkey; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_control_combustible
    ADD CONSTRAINT det_control_combustible_esta_ser_id_fkey FOREIGN KEY (esta_ser_id) REFERENCES utilidades.estaciones_servicio(est_ser_id);


--
-- Name: fk_ceds; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_con_eds
    ADD CONSTRAINT fk_ceds FOREIGN KEY (id_ceds) REFERENCES consumo_estacion(id_ce);


--
-- Name: fk_ctrl_com; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_galones
    ADD CONSTRAINT fk_ctrl_com FOREIGN KEY (ctrl_com_id) REFERENCES control_combustible(ctrl_com_id);


--
-- Name: fk_ctrl_com; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_control_combustible
    ADD CONSTRAINT fk_ctrl_com FOREIGN KEY (ctrl_id) REFERENCES control_combustible(ctrl_com_id);


--
-- Name: fk_id_ctrl_com; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_control_combustible
    ADD CONSTRAINT fk_id_ctrl_com FOREIGN KEY (ctrl_com_id) REFERENCES control_combustible(ctrl_com_id);


--
-- Name: fk_idce; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY total_ccostos_ce
    ADD CONSTRAINT fk_idce FOREIGN KEY (id_ce) REFERENCES consumo_estacion(id_ce);


--
-- Name: fk_idctrl; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY doc_control_combustible
    ADD CONSTRAINT fk_idctrl FOREIGN KEY (id_ctrl) REFERENCES control_combustible(ctrl_com_id);


--
-- Name: fk_ideds; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY consumo_estacion
    ADD CONSTRAINT fk_ideds FOREIGN KEY (id_estacion) REFERENCES utilidades.estaciones_servicio(est_ser_id);


--
-- Name: fk_idmes; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT fk_idmes FOREIGN KEY (id_mes) REFERENCES utilidades.mes(id_mes);


--
-- Name: fk_idmes; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY no_tanqueo
    ADD CONSTRAINT fk_idmes FOREIGN KEY (id_mes) REFERENCES utilidades.mes(id_mes);


--
-- Name: fk_idus; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY no_tanqueo
    ADD CONSTRAINT fk_idus FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (usuario_id) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY consumo_estacion
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_idvehiculo; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT fk_idvehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


--
-- Name: fk_idvehiculo; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_con_eds
    ADD CONSTRAINT fk_idvehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


--
-- Name: fk_idvehiculo; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY no_tanqueo
    ADD CONSTRAINT fk_idvehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


--
-- Name: fk_idyear; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY no_tanqueo
    ADD CONSTRAINT fk_idyear FOREIGN KEY (id_year) REFERENCES utilidades.year(id_year);


--
-- Name: fk_tipocom; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY det_con_eds
    ADD CONSTRAINT fk_tipocom FOREIGN KEY (id_tipo_com) REFERENCES utilidades.tipo_combustible(id_tipo_com);


--
-- Name: fkidtc; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT fkidtc FOREIGN KEY (id_tipo_com) REFERENCES utilidades.tipo_combustible(id_tipo_com);


--
-- Name: fkidus; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT fkidus FOREIGN KEY (id_usuario_apro) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fkidus; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY consumo_estacion
    ADD CONSTRAINT fkidus FOREIGN KEY (id_usuario_apro) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: idyear; Type: FK CONSTRAINT; Schema: consumo_combustible; Owner: postgres
--

ALTER TABLE ONLY control_combustible
    ADD CONSTRAINT idyear FOREIGN KEY (id_year) REFERENCES utilidades.year(id_year);


SET search_path = informes_mensuales, pg_catalog;

--
-- Name: FK_idus; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_ctrl
    ADD CONSTRAINT "FK_idus" FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_eds; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_eds
    ADD CONSTRAINT fk_eds FOREIGN KEY (id_eds) REFERENCES utilidades.estaciones_servicio(est_ser_id);


--
-- Name: fk_id_men_info; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY det_inf_mens
    ADD CONSTRAINT fk_id_men_info FOREIGN KEY (id_men_info) REFERENCES mensual_ctrl(id);


--
-- Name: fk_id_men_info; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY total_gal_inf_men
    ADD CONSTRAINT fk_id_men_info FOREIGN KEY (id_men_inf) REFERENCES mensual_ctrl(id);


--
-- Name: fk_idme_eds; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY det_men_eds
    ADD CONSTRAINT fk_idme_eds FOREIGN KEY (id_men_info) REFERENCES mensual_eds(id);


--
-- Name: fk_idmen_eds; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY total_gal_men_eds
    ADD CONSTRAINT fk_idmen_eds FOREIGN KEY (id_men_inf) REFERENCES mensual_eds(id);


--
-- Name: fk_idmes; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_ctrl
    ADD CONSTRAINT fk_idmes FOREIGN KEY (mes) REFERENCES utilidades.mes(id_mes);


--
-- Name: fk_idyear; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_ctrl
    ADD CONSTRAINT fk_idyear FOREIGN KEY (year) REFERENCES utilidades.year(id_year);


--
-- Name: fk_mes; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_eds
    ADD CONSTRAINT fk_mes FOREIGN KEY (mes) REFERENCES utilidades.mes(id_mes);


--
-- Name: fk_us; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_eds
    ADD CONSTRAINT fk_us FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_year; Type: FK CONSTRAINT; Schema: informes_mensuales; Owner: postgres
--

ALTER TABLE ONLY mensual_eds
    ADD CONSTRAINT fk_year FOREIGN KEY (year) REFERENCES utilidades.year(id_year);


SET search_path = mantenimientos_mecanica, pg_catalog;

--
-- Name: fk_anio; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY cos_fact_mto_ext
    ADD CONSTRAINT fk_anio FOREIGN KEY (id_anio) REFERENCES utilidades.year(id_year);


--
-- Name: fk_id_fact_costo; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_cos_fact_mto_ext
    ADD CONSTRAINT fk_id_fact_costo FOREIGN KEY (id_fact_mto_ex) REFERENCES cos_fact_mto_ext(id_cos_fact);


--
-- Name: fk_id_mes; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY cos_fact_mto_ext
    ADD CONSTRAINT fk_id_mes FOREIGN KEY (id_mes) REFERENCES utilidades.mes(id_mes);


--
-- Name: fk_id_mto_interno; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_mto_interno
    ADD CONSTRAINT fk_id_mto_interno FOREIGN KEY (id_mto_interno) REFERENCES mto_internos(id_mto_interno);


--
-- Name: fk_id_proveedor; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_cos_fact_mto_ext
    ADD CONSTRAINT fk_id_proveedor FOREIGN KEY (id_proveedor) REFERENCES utilidades.talleres_externos_mec(id);


--
-- Name: fk_id_usuario; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_id_usuariomod; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_id_usuariomod FOREIGN KEY (id_us_mod) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_id_vehiculo; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_cos_fact_mto_ext
    ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


--
-- Name: fk_idmecanico; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_idmecanico FOREIGN KEY (id_mecanico) REFERENCES utilidades.mecanico_utd(id_meca);


--
-- Name: fk_idmtoext; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dte_mto_externo
    ADD CONSTRAINT fk_idmtoext FOREIGN KEY (id_mto_externo) REFERENCES mtos_externos(id_mto_externo);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario_reg) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY cos_fact_mto_ext
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_idusuario_anulado; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT fk_idusuario_anulado FOREIGN KEY (id_usuario_anula) REFERENCES utilidades.usuarios(id_usuario);


--
-- Name: fk_rutina; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_rutina FOREIGN KEY (id_rutina) REFERENCES utilidades.rutina(id_rutina);


--
-- Name: fk_servicio; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dt_mto_interno
    ADD CONSTRAINT fk_servicio FOREIGN KEY (id_labor_mec) REFERENCES utilidades.labor_mecanico(id_labor);


--
-- Name: fk_sistema; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY dte_mto_externo
    ADD CONSTRAINT fk_sistema FOREIGN KEY (item_sistema) REFERENCES utilidades.items_sistema(id);


--
-- Name: fk_taller; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT fk_taller FOREIGN KEY (id_taller) REFERENCES utilidades.talleres_externos_mec(id);


--
-- Name: fk_tipo_mto; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_tipo_mto FOREIGN KEY (id_tipo_mto) REFERENCES utilidades.tipo_mto(id_tipo_mto);


--
-- Name: fk_tipo_mto; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT fk_tipo_mto FOREIGN KEY (id_tipo_mto) REFERENCES utilidades.tipo_mto(id_tipo_mto);


--
-- Name: fk_vehiculo; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mtos_externos
    ADD CONSTRAINT fk_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


--
-- Name: fk_vehiculo; Type: FK CONSTRAINT; Schema: mantenimientos_mecanica; Owner: postgres
--

ALTER TABLE ONLY mto_internos
    ADD CONSTRAINT fk_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES utilidades.vehiculos_equipos(id_vehiculo);


SET search_path = utilidades, pg_catalog;

--
-- Name: fk_comparendo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY alertas_no_pago_comparendos
    ADD CONSTRAINT fk_comparendo FOREIGN KEY (id_comparendo) REFERENCES comparendos(id_comparendo);


--
-- Name: fk_comparendo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY pagos_comparendos
    ADD CONSTRAINT fk_comparendo FOREIGN KEY (id_comparendo) REFERENCES comparendos(id_comparendo);


--
-- Name: fk_doc_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY alertas_doc_ven_ve
    ADD CONSTRAINT fk_doc_vehiculo FOREIGN KEY (id_doc_vehiculo) REFERENCES documentacion_vehiculo(id_doc);


--
-- Name: fk_id2tipocom; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_id2tipocom FOREIGN KEY (id_2tipo_com) REFERENCES tipo_combustible(id_tipo_com);


--
-- Name: fk_id_conductor; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY doc_conductor
    ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_conductor) REFERENCES conductor(id_conductor);


--
-- Name: fk_id_conductor; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY asignacion_vehiculo
    ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_conductor) REFERENCES conductor(id_conductor);


--
-- Name: fk_id_conductor; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY foto_conductor
    ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_conductor) REFERENCES conductor(id_conductor);


--
-- Name: fk_id_conductor; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY comparendos
    ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_conductor) REFERENCES conductor(id_conductor);


--
-- Name: fk_id_forma_pago; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY pagos_comparendos
    ADD CONSTRAINT fk_id_forma_pago FOREIGN KEY (id_forma_pago) REFERENCES forma_pago(id_forma);


--
-- Name: fk_id_itemccostos; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY conductor
    ADD CONSTRAINT fk_id_itemccostos FOREIGN KEY (id_area) REFERENCES itemccostos(id_item_ccostos);


--
-- Name: fk_id_rutina; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY labor_mecanico
    ADD CONSTRAINT fk_id_rutina FOREIGN KEY (id_rutina) REFERENCES rutina(id_rutina);


--
-- Name: fk_id_usuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY pagos_comparendos
    ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_id_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY ficha_tecnica_vehiculo_equipo
    ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: fk_id_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY foto_vehiculos
    ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo_equipo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: fk_id_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY asignacion_vehiculo
    ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: fk_id_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY comparendos
    ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: fk_idccostos; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY itemccostos
    ADD CONSTRAINT fk_idccostos FOREIGN KEY (id_centrocostos) REFERENCES centrocostos(id_centrocostos);


--
-- Name: fk_idlevel; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT fk_idlevel FOREIGN KEY (id_level) REFERENCES level(id_level);


--
-- Name: fk_idlinea; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_idlinea FOREIGN KEY (id_linea) REFERENCES linea_vehiculo(id_linea_vehi);


--
-- Name: fk_idmarca; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY linea_vehiculo
    ADD CONSTRAINT fk_idmarca FOREIGN KEY (id_marca) REFERENCES marca_vehiculo(id_marca);


--
-- Name: fk_idsistema; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY items_sistema
    ADD CONSTRAINT fk_idsistema FOREIGN KEY (id_sistema) REFERENCES sistema_vehiculo(id_sistema);


--
-- Name: fk_idtipocom; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_idtipocom FOREIGN KEY (id_tipo_com) REFERENCES tipo_combustible(id_tipo_com);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY documentacion_vehiculo
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY conductor
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY doc_conductor
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY comparendos
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_itemccostos; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_itemccostos FOREIGN KEY (id_item_ccostos) REFERENCES itemccostos(id_item_ccostos);


--
-- Name: fk_tipo_doc; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY documentacion_vehiculo
    ADD CONSTRAINT fk_tipo_doc FOREIGN KEY (id_tipo_doc) REFERENCES tipo_doc(id);


--
-- Name: fk_tipo_doc; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY doc_conductor
    ADD CONSTRAINT fk_tipo_doc FOREIGN KEY (id_tipo_doc) REFERENCES tipo_doc(id);


--
-- Name: fk_tipovehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY vehiculos_equipos
    ADD CONSTRAINT fk_tipovehiculo FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id_tipo_vehi);


--
-- Name: fk_usuario; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY ficha_tecnica_vehiculo_equipo
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- Name: fk_usuario_mod; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY conductor
    ADD CONSTRAINT fk_usuario_mod FOREIGN KEY (id_usuario_mod) REFERENCES usuarios(id_usuario);


--
-- Name: fk_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY documentacion_vehiculo
    ADD CONSTRAINT fk_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: fk_vehiculo; Type: FK CONSTRAINT; Schema: utilidades; Owner: postgres
--

ALTER TABLE ONLY alertas_doc_ven_ve
    ADD CONSTRAINT fk_vehiculo FOREIGN KEY (id_vehiculo) REFERENCES vehiculos_equipos(id_vehiculo);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

