/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.rest.endpoint;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.util.Base64;
import javax.websocket.server.PathParam;
import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.jobits.pos.client.tennant.core.domain.BaseDatos;
import org.jobits.pos.client.tennant.core.domain.Cuenta;
import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.usecase.BaseDatosUseCase;
import org.jobits.pos.client.tennant.core.usecase.CuentaUseCase;
import org.jobits.pos.client.tennant.rest.endpoint.assembler.CuentaAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpServerErrorException;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@RestController
@RequestMapping(path = "/tennant/cuenta")
public class CuentaEndpoint extends CrudRestServiceTemplate<Cuenta> {

    private static final String PATH_ADD_DB = "/{idCuenta}/add-db";
    private static final String PATH_REMOVE_DB = "/{idCuenta}/remove-db";
    private static final String PATH_GET_TOKEN_FOR = "/{idCuenta}/token-for/{idBaseDatos}";

    @RequestMapping(method = {RequestMethod.POST}, path = {PATH_ADD_DB})
    public EntityModel<Cuenta> addBaseDatosToCuenta(@PathVariable("idCuenta") int idCuenta, @RequestBody BaseDatos baseDatos) {
        Cuenta cuenta = findBy(idCuenta).getContent();
        if (cuenta != null) {
            cuenta.addBaseDatos(baseDatos);
        }
        edit(cuenta);
        return getAssembler().toModel(cuenta);
    }

    @RequestMapping(method = {RequestMethod.GET}, path = {PATH_GET_TOKEN_FOR})
    public EntityModel<Token> getTokenFor(
            @RequestHeader("Authorization") String base64Credentials,
            @PathVariable("idCuenta") int idCuenta,
            @PathVariable("idBaseDatos") int idBaseDatos) {
        Cuenta cuenta = findBy(idCuenta).getContent();
        if (cuenta != null) {
            if (authenticate(cuenta, base64Credentials)) {
                if (validateDataBaseId(cuenta, idBaseDatos)) {
                    Token t;
                    t = TennantCoreModule.getInstance().getImplementation(BaseDatosUseCase.class).getOrRefreshTokenFor(idBaseDatos);
                    return EntityModel.of(t, linkTo(methodOn(this.getClass()).getTokenFor(null, idCuenta, idBaseDatos)).withSelfRel());
                }
            }
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }
        throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe cuenta");
    }

    @Override
    public CrudModelAssembler<Cuenta> getAssembler() {
        return new CuentaAssembler();
    }

    @Override
    public CRUDUseCase<Cuenta> getUc() {
        return TennantCoreModule.getInstance().getImplementation(CuentaUseCase.class);
    }

    private boolean authenticate(Cuenta cuenta, String base64Credentials) {
        if (base64Credentials.contains("Basic")) {
            String ret = new String(Base64.getDecoder().decode(base64Credentials.substring(6)));
            String[] credentials = ret.split(":");
            if (credentials.length == 2) {
                return credentials[0].equals(cuenta.getUsuario()) && credentials[1].equals(cuenta.getContrasena()) && true;
            }
        }
        return false;
    }

    private boolean validateDataBaseId(Cuenta cuenta, int idBaseDatos) {
        for (BaseDatos bd : cuenta.getBaseDatos()) {
            if (bd.getId() == idBaseDatos) {
                return true;
            }
        }
        return false;
    }

}
