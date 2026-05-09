package org.example.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.example.controller.BookResource;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Bean
    public ServletRegistrationBean<?> cxfServlet() {
        CXFNonSpringJaxrsServlet servlet = new CXFNonSpringJaxrsServlet();
        ServletRegistrationBean<?> bean = new ServletRegistrationBean<>(servlet, "/rest/*");

        bean.addInitParameter("jaxrs.providers", JacksonJsonProvider.class.getName());
        bean.addInitParameter("jaxrs.serviceClasses", BookResource.class.getName());

        return bean;
    }
}
