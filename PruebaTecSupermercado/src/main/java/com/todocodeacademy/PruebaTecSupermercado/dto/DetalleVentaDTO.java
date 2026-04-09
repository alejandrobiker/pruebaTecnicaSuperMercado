package com.todocodeacademy.PruebaTecSupermercado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {
    private Long id;
    private Integer cantProd;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nombreProd;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double precio;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subtotal;
}
