package com.todocodeacademy.PruebaTecSupermercado.controller;

import com.todocodeacademy.PruebaTecSupermercado.dto.CategoriaDTO;
import com.todocodeacademy.PruebaTecSupermercado.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> traerCategorias() {
        return ResponseEntity.ok(categoriaService.traerCategorias());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria (@RequestBody CategoriaDTO dto) {
        CategoriaDTO creado = categoriaService.crearCategoria(dto);

        return ResponseEntity.created(URI.create("/api/categorias" + creado.getId())).body(creado);
    }

}
