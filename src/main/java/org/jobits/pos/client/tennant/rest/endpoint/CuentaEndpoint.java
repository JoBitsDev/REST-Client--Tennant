/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.rest.endpoint;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.jobits.pos.client.tennant.core.domain.Cuenta;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.usecase.CuentaUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@RestController
@RequestMapping(path = "/cuenta")
public class CuentaEndpoint extends CrudRestServiceTemplate<Cuenta> {

    private final CrudModelAssembler<Cuenta> a = new CrudModelAssembler<Cuenta>(CuentaEndpoint.class) {
        @Override
        public Object getId(Cuenta entity) {
            return entity.getId();
        }
    };

    @Override
    public CrudModelAssembler<Cuenta> getAssembler() {
        return a;
    }

    @Override
    public CRUDUseCase<Cuenta> getUc() {
        return TennantCoreModule.getInstance().getImplementation(CuentaUseCase.class);
    }

}
