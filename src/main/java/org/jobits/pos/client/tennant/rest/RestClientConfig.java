/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jobits.pos.client.tennant.rest;

import org.jobits.pos.client.tennant.rest.endpoint.CuentaEndpoint;
import org.jobits.pos.client.tennant.rest.service.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * JoBits
 * @author Jorge
 * 
 */
@Configuration
public class RestClientConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new RequestInterceptor()).excludePathPatterns(
               "/**/tennant/cuenta/**");//.addPathPatterns("/*");
    }
} 
