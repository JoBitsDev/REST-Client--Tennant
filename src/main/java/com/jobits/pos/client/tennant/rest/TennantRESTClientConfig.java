/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.client.tennant.rest;

import org.jobits.db.core.module.DataVersionControlModule;
import org.springframework.stereotype.Component;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@Component
public class TennantRESTClientConfig {

    public static final String BASE_PACKAGE = "com.jobits.pos.client.tennant.rest";

    public TennantRESTClientConfig() {
        DataVersionControlModule.init();
        //org.jobits.db.core.usecase.UbicacionConexionHandler.registerUbicacionConexionService(DataBaseUbicacionService.getInstance());
    }

}
