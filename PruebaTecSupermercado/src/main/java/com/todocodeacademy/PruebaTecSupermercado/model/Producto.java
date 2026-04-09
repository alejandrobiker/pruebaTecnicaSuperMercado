package com.todocodeacademy.PruebaTecSupermercado.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private int cantidad;
    // Categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @Column(updatable = false, nullable = false)
    @CreatedDate // Se llena automáticamente al insertar
    private LocalDateTime createdAt;

    @LastModifiedDate // Se llena automáticamente al editar
    private LocalDateTime updatedAt;
}
