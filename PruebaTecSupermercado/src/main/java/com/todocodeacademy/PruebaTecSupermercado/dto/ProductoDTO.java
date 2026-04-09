package com.todocodeacademy.PruebaTecSupermercado.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {

    @Schema(description = "ID único del producto", example = "1")
    private Long id;
    @Schema(description = "Nombre del producto", example = "Pera")
    private String nombre;
    @Schema(description = "Precio del producto", example = "40.00")
    private Double precio;
    @Schema(description = "Cantidad en disposición del producto", example = "1")
    private int cantidad;

    // Se usa para RECIBIR el ID desde Postman
    @Schema(description = "ID unico de la categoria", example = "1")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long categoriaId;

    // Se usa para ENVIAR el objeto completo al cliente
    @Schema(description = "Categoria")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CategoriaDTO categoria;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
