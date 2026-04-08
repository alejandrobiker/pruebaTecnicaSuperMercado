package com.todocodeacademy.PruebaTecSupermercado.service;

import com.todocodeacademy.PruebaTecSupermercado.dto.ProductoDTO;
import com.todocodeacademy.PruebaTecSupermercado.exception.NotFoundException;
import com.todocodeacademy.PruebaTecSupermercado.mapper.Mapper;
import com.todocodeacademy.PruebaTecSupermercado.model.Categoria;
import com.todocodeacademy.PruebaTecSupermercado.model.Producto;
import com.todocodeacademy.PruebaTecSupermercado.repository.CategoriaRepository;
import com.todocodeacademy.PruebaTecSupermercado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Override
    public List<ProductoDTO> traerProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {

        // Buscamos la categoría real en la BD usando el ID del DTO
        Categoria cat = categoriaRepo.findById(productoDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Producto prod = Producto.builder()
                .nombre(productoDto.getNombre())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .categoria(cat)
                .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto) {

        //vamos a buscar si existe ese producto
        Producto prod = repo.findById(id)
            .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        // Buscamos la categoría real en la BD usando el ID del DTO
        Categoria cat = categoriaRepo.findById(productoDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        prod.setNombre(productoDto.getNombre());
        prod.setCantidad(productoDto.getCantidad());
        prod.setPrecio(productoDto.getPrecio());
        prod.setCategoria(cat);

        return Mapper.toDTO(repo.save(prod));

    }

    @Override
    public void eliminarProducto(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Producto no encontrado para eliminar");
        }

        repo.deleteById(id);
    }
}
