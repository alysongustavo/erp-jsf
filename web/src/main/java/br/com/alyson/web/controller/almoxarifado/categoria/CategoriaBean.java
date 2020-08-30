package br.com.alyson.web.controller.almoxarifado.categoria;

import br.com.alyson.almoxarifado.service.CategoriaService;
import br.com.alyson.core.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@ViewScoped
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CategoriaService categoriaService;

    private List<Categoria> categorias = new ArrayList<>();

    private Categoria categoriaSelecionada = new Categoria();

    @PostConstruct
    public void init(){
        categorias = categoriaService.listar();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }
}
