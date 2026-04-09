package com.todocodeacademy.PruebaTecSupermercado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private int cantidad;

    // Se usa para RECIBIR el ID desde Postman
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long categoriaId;

    // Se usa para ENVIAR el objeto completo al cliente
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CategoriaDTO categoria;
}
