package com.todocodeacademy.PruebaTecSupermercado.service;

import com.todocodeacademy.PruebaTecSupermercado.dto.CategoriaDTO;
import com.todocodeacademy.PruebaTecSupermercado.mapper.Mapper;
import com.todocodeacademy.PruebaTecSupermercado.model.Categoria;
import com.todocodeacademy.PruebaTecSupermercado.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Override
    public List<CategoriaDTO> traerCategorias() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria cat = Categoria.builder()
                .nombre(categoriaDTO.getNombre())
                .build();

        return Mapper.toDTO(repo.save(cat));
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {

    }
}
