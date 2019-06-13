package com.example.demo;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings( CorsRegistry registry )
    {
        registry.addMapping( "/**" )
                .allowedMethods( "GET", "POST", "PUT", "DELETE" )
                .allowedOrigins( "*" )
                .allowCredentials( false );
    }
}
