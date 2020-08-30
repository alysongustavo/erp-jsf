package br.com.alyson.almoxarifado.service;

import br.com.alyson.core.model.Categoria;
import br.com.alyson.core.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }
}
