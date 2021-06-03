/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jobits.pos.client.tennant.repo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * JoBits
 * @author Jorge
 * 
 */
@Entity
@Table(name = "token" , schema = "tennant")
@NamedQueries({
    @NamedQuery(name = "TokenEntity.findAll", query = "SELECT t FROM TokenEntity t"),
    @NamedQuery(name = "TokenEntity.findByTokenEntity", query = "SELECT t FROM TokenEntity t WHERE t.token = :token"),
    @NamedQuery(name = "TokenEntity.findByExpiracion", query = "SELECT t FROM TokenEntity t WHERE t.expiracion = :expiracion")})
public class TokenEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "token")
    private String token;
    @Column(name = "expiracion")
    @Temporal(TemporalType.DATE)
    private Date expiracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tokentoken")
    private List<BaseDatosEntity> baseDatosList;

    public TokenEntity() {
    }

    public TokenEntity(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }

    public List<BaseDatosEntity> getBaseDatosList() {
        return baseDatosList;
    }

    public void setBaseDatosList(List<BaseDatosEntity> baseDatosList) {
        this.baseDatosList = baseDatosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (token != null ? token.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TokenEntity)) {
            return false;
        }
        TokenEntity other = (TokenEntity) object;
        if ((this.token == null && other.token != null) || (this.token != null && !this.token.equals(other.token))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jobits.pos.client.tennant.repo.entity.Token[ token=" + token + " ]";
    }

}
