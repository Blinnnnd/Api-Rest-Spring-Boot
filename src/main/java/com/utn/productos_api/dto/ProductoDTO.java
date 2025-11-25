package com.utn.productos_api.dto;

import com.utn.productos_api.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductoDTO {

    @Schema(description = "Denominación comercial del ítem", example = "Smart TV 55 4K")
    @NotEmpty(message = "Es obligatorio asignar un nombre al producto")
    @Size(min = 3, max = 100, message = "El nombre debe contener entre 3 y 100 caracteres")
    private String nombre;

    @Schema(description = "Detalle técnico o comercial", example = "Pantalla LED con resolución UHD")
    @Size(max = 500, message = "La descripción excede el límite de 500 caracteres")
    private String descripcion;

    @Schema(description = "Precio unitario de venta", example = "150000.00")
    @NotNull(message = "Debe especificar el precio")
    @Min(value = 1, message = "El valor mínimo permitido es 1")
    private Double precio;

    @Schema(description = "Cantidad disponible en depósito", example = "25")
    @NotNull(message = "El campo stock es requerido")
    @Min(value = 0, message = "El stock no puede ser inferior a 0")
    private Integer stock;

    @Schema(description = "Clasificación del ítem", example = "ELECTRONICA")
    @NotNull(message = "Seleccione una categoría válida")
    private Categoria categoria;

    // --- Getters y Setters ---

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}