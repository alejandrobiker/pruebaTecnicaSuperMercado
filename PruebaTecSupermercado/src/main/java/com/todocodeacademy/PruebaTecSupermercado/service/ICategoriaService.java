package com.todocodeacademy.PruebaTecSupermercado.service;

import com.todocodeacademy.PruebaTecSupermercado.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaDTO> traerCategorias();
    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);
    String eliminarCategoria(Long id);

}
