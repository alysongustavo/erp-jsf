package br.com.alyson.webservice.resources;

import br.com.alyson.almoxarifado.service.CategoriaService;
import br.com.alyson.core.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Categoria> listarCategoria() {
        return categoriaService.listar();
    }


}
