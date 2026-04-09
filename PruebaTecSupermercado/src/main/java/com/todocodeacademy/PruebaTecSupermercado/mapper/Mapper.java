package com.todocodeacademy.PruebaTecSupermercado.mapper;

import com.todocodeacademy.PruebaTecSupermercado.dto.*;
import com.todocodeacademy.PruebaTecSupermercado.model.Categoria;
import com.todocodeacademy.PruebaTecSupermercado.model.Producto;
import com.todocodeacademy.PruebaTecSupermercado.model.Sucursal;
import com.todocodeacademy.PruebaTecSupermercado.model.Venta;

import java.util.stream.Collectors;

public class Mapper {


    //Mapeo de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto p) {
        if (p == null) return null;

        // Creamos el objeto para enviarlo en la respuesta
        CategoriaDTO cat = p.getCategoria() != null ? new CategoriaDTO(p.getCategoria().getId(), p.getCategoria().getNombre()) : null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .precio(p.getPrecio())
                .cantidad(p.getCantidad())
                // Extraemos el ID de la relación ManyToOne
                .categoria(cat)
                .build();
    }

    //Mapeo de Categoria a CategoriaDTO
    public static CategoriaDTO toDTO(Categoria c) {
        if (c == null) return null;

        return CategoriaDTO.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .build();
    }

    //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProd().getId())
                        .nombreProd(det.getProd().getNombre())
                        .cantProd(det.getCantProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }


    //Mapeo de Sucursal a SucursalDTO
    public static SucursalDTO toDTO(Sucursal s) {
        if (s == null) return null;
        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();
    }

}
