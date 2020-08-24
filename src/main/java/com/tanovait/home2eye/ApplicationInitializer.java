package com.tanovait.home2eye;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
       ctx.setServletContext(servletContext);

       ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
       servletRegistration.setLoadOnStartup(1);
       servletRegistration.addMapping("/");
    }
}
