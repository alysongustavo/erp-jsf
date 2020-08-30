package br.com.alyson.webservice.init;

import br.com.alyson.core.config.PersistenceConfig;
import br.com.alyson.core.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        context.register(new Class<?>[]{PersistenceConfig.class, WebConfig.class});
        context.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.addListener(new RequestContextListener());
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dynamic.addMapping("/api/*");
        dynamic.setLoadOnStartup(1);

        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.setInitParameter(
                "contextConfigLocation", "br.com.alyson.webservice.resources");

    }
}
