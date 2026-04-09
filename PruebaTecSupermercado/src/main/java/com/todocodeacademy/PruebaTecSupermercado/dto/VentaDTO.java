package com.todocodeacademy.PruebaTecSupermercado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    //datos de la venta
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate fecha;

    private String estado;

    //datos de la sucursal
    private Long idSucursal;

    //lista de detalles
    private List<DetalleVentaDTO> detalle;

    //total de la venta
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double total;

}
