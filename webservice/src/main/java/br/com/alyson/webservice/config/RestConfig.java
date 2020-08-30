package br.com.alyson.webservice.config;

import br.com.alyson.webservice.resources.CategoriaResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api")
public class RestConfig extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<>(
                Arrays.asList(
                        CategoriaResource.class));
    }
}
