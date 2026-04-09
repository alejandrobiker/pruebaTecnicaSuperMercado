package com.todocodeacademy.PruebaTecSupermercado.controller;

import com.todocodeacademy.PruebaTecSupermercado.dto.CategoriaDTO;
import com.todocodeacademy.PruebaTecSupermercado.service.ICategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
@Tag(name = "Categoria", description = "Operaciones de categorias para productos")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> traerCategorias() {
        return ResponseEntity.ok(categoriaService.traerCategorias());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO dto) {
        CategoriaDTO creado = categoriaService.crearCategoria(dto);

        return ResponseEntity.created(URI.create("/api/categorias" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        CategoriaDTO actualizado = categoriaService.actualizarCategoria(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCategoria (@PathVariable Long id) {

        return ResponseEntity.ok(categoriaService.eliminarCategoria(id));
    }

}
