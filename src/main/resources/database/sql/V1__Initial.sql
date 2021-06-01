/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jorge
 * Created: 27 may. 2021
 */



--
-- Tablas
--

CREATE TABLE public.base_datos (
    cuentaid serial,
    url character varying(255),
    usuario character varying(30),
    contrasena character varying(255),
    driver character varying(100)
);

CREATE TABLE public.cuenta (
    id serial,
    usuario character varying(30),
    contrasena character varying(255),
    estado character varying(255) DEFAULT 'ACTIVA'::character varying,
    activa boolean DEFAULT false
);

CREATE TABLE public.token (
    cuentaid serial,
    token character varying(255),
    expira timestamp without time zone
);

--


--
-- TOC entry 2283 (class 2606 OID 165648)
-- Name: base_datos base_datos_pkey; Type: CONSTRAINT; Schema: public; Owner: pasarela_user
--

ALTER TABLE ONLY public.base_datos
    ADD CONSTRAINT base_datos_pkey PRIMARY KEY (cuentaid);


--
-- TOC entry 2285 (class 2606 OID 165661)
-- Name: cuenta cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: pasarela_user
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id);


--
-- TOC entry 2281 (class 2606 OID 165640)
-- Name: token token_pkey; Type: CONSTRAINT; Schema: public; Owner: pasarela_user
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (cuentaid);


--
-- TOC entry 2287 (class 2606 OID 165667)
-- Name: base_datos fkbase_datos13588; Type: FK CONSTRAINT; Schema: public; Owner: pasarela_user
--

ALTER TABLE ONLY public.base_datos
    ADD CONSTRAINT fkbase_datos13588 FOREIGN KEY (cuentaid) REFERENCES public.cuenta(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2286 (class 2606 OID 165662)
-- Name: token fktoken3984; Type: FK CONSTRAINT; Schema: public; Owner: pasarela_user
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT fktoken3984 FOREIGN KEY (cuentaid) REFERENCES public.cuenta(id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2021-05-31 19:34:49 CDT

--
-- PostgreSQL database dump complete
--

