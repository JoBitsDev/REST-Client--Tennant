/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.domain;

import java.util.Objects;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class BaseDatos {

    private int id;
    private String nombreBaseDatos;
    private String url;
    private String usuario;
    private String contrasena;
    private String driver;
    private Token accessToken;

    public BaseDatos() {
    }

    public BaseDatos(Integer cuentaid) {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseDatos other = (BaseDatos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombreBaseDatos, other.nombreBaseDatos)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.driver, other.driver)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseDatos{" + "id=" + id + ", nombreBaseDatos=" + nombreBaseDatos + ", url=" + url + ", usuario=" + usuario + ", contrasena=" + contrasena + ", driver=" + driver + '}';
    }

}
