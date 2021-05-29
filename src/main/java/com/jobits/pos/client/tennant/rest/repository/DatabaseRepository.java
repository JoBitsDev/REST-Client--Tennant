/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.client.tennant.rest.repository;

import com.jobits.pos.client.tennant.rest.domain.BaseDatos;
import com.jobits.pos.client.tennant.rest.domain.Cuenta;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jobits.db.core.domain.ConexionPropertiesModel;
import org.jobits.db.core.domain.TipoConexion;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class DatabaseRepository {

    private static final String PU_DEFAULT_NAME = "pasarela_loggeo";
    private static final HashMap<String, String> PU_DEFAULT_PROPERTIES = getDefaultProperties();
    private static final EntityManagerFactory DEFAULT_EMF = Persistence.createEntityManagerFactory(PU_DEFAULT_NAME, PU_DEFAULT_PROPERTIES);

    public static EntityManagerFactory getDefaultFactory() {
        return DEFAULT_EMF;
    }

    public static EntityManager getDefaultConnection() {
        return getDefaultFactory().createEntityManager();
    }

    public static EntityManagerFactory getFactoryFrom(Cuenta cuenta) {
        return Persistence.createEntityManagerFactory(PU_DEFAULT_NAME, getPropertiesFrom(cuenta.getBaseDatos()));
    }

    private static HashMap<String, String> getDefaultProperties() {
        HashMap<String, String> ret = new HashMap<>();
//        ret.put(PersistenceProperties.URL.getName(), "jdbc:postgresql://localhost:5432/jobitsjv_pasarela_loggeo");
//        ret.put(PersistenceProperties.USER.getName(), "jobitsjv_pasarela_user");
//        ret.put(PersistenceProperties.PASSWORD.getName(), "a123b456c789.");
//        ret.put(PersistenceProperties.DRIVER.getName(), "org.postgresql.Driver");
        ret.put(PersistenceProperties.URL.getName(), "jdbc:postgresql://localhost:5432/pasarela_loggeo");
        ret.put(PersistenceProperties.USER.getName(), "pasarela_user");
        ret.put(PersistenceProperties.PASSWORD.getName(), "pasarela_user");
        ret.put(PersistenceProperties.DRIVER.getName(), "org.postgresql.Driver");
        return ret;
    }

    private static Map getPropertiesFrom(BaseDatos baseDatos) {
        HashMap<String, String> ret = new HashMap<>();
        ret.put(PersistenceProperties.URL.getName(), baseDatos.getUrl());
        ret.put(PersistenceProperties.USER.getName(), baseDatos.getUsuario());
        ret.put(PersistenceProperties.PASSWORD.getName(), baseDatos.getContrasena());
        ret.put(PersistenceProperties.DRIVER.getName(), baseDatos.getDriver());
        return ret;
    }

    public static ConexionPropertiesModel getDefautlUbicacion() {
        
        return new ConexionPropertiesModel() {
            @Override
            public String getContrasena() {
                return "pasarela_user";
            }

            @Override
            public String getDriver() {
                return "org.postgresql.Driver";
            }

            @Override
            public String getNombreUbicacion() {
                return "DEFAULT";
            }

            @Override
            public TipoConexion getTipoUbicacion() {
                return TipoConexion.MASTER;//TODO: fix
            }

            @Override
            public String getUrl() {
                return "jdbc:postgresql://localhost:5432/pasarela_loggeo";
            }

            @Override
            public String getUsuario() {
                return "pasarela_user";
            }
        };
    }

}
