/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.jobits.pos.client.tennant.core.usecase.CuentaUseCase;
import org.jobits.pos.client.tennant.core.usecase.impl.CuentaUseCaseImpl;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class TennantInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuentaUseCase.class).to(CuentaUseCaseImpl.class).in(Scopes.SINGLETON);

    }

}
