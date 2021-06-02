/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.rest;

import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
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

    public static final String BASE_PACKAGE = "org.jobits.pos.client.tennant.rest";

    public TennantRESTClientConfig() {
        TennantCoreModule.init();
    }

}
