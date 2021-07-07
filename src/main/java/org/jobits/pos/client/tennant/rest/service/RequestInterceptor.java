/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jobits.pos.client.tennant.core.domain.TennantWrapper;
import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.usecase.BaseDatosUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class RequestInterceptor implements AsyncHandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        var tennantID = getTennantToken(request);
        if (tennantID == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().append("Tenant not present in the Request Header");
            return false;
        }
        pointConexionTo(tennantID);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView); //To change body of generated methods, choose Tools | Templates.
    }

    private String getTennantToken(HttpServletRequest request) {
        System.out.println("In preHandle we are Intercepting the Request");
        System.out.println("____________________________________________");
        String requestURI = request.getRequestURI();
        String tenantID = request.getHeader("Tennant");
        System.out.println("RequestURI::" + requestURI + " || Search for Tenant  :: " + tenantID);
        System.out.println("____________________________________________");
        return tenantID;

    }

    private void pointConexionTo(String tennantID) {
        var baseDatosUseCase = TennantCoreModule.getInstance().getImplementation(BaseDatosUseCase.class);
        var bd = baseDatosUseCase.findByToken(tennantID);
        TennantWrapper wrapper = new TennantWrapper(bd.getToken(), bd);
        DataBaseUbicacionService.getInstance().setSelectedConexion(wrapper.getTennantProperties());

    }

}
