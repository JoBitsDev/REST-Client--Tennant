/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.rest.endpoint.assembler;

import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.jobits.pos.client.tennant.core.domain.Cuenta;
import org.jobits.pos.client.tennant.rest.endpoint.CuentaEndpoint;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class CuentaAssembler extends CrudModelAssembler<Cuenta> {

    public CuentaAssembler() {
        super(CuentaEndpoint.class);
    }

    @Override
    public Object getId(Cuenta entity) {
        return entity.getId();
    }

    @Override
    public EntityModel<Cuenta> toModel(Cuenta entity) {
        return super.toModel(entity).add(
                linkTo(methodOn(CuentaEndpoint.class).addBaseDatosToCuenta(entity.getId(), null)).withRel("add_base_datos")
                //,linkTo(methodOn(CuentaEndpoint.class).getTokenFor(entity.getId())).withRel("get_token")
        ); //To change body of generated methods, choose Tools | Templates.
    }
}
