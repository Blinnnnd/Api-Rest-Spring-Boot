package com.utn.productos_api.controller;

import com.utn.productos_api.dto.ActualizarStockDTO;
import com.utn.productos_api.dto.ProductoDTO;
import com.utn.productos_api.dto.ProductoResponseDTO;
import com.utn.productos_api.exception.ErrorResponse;
import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Administración de Inventario", description = "Controlador principal para operaciones de catálogo y stock")
public class ProductoController {

    private final ProductoService service; // Renombrado de productoService a service

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @Operation(summary = "Registrar nuevo ítem", description = "Da de alta un producto en el catálogo validando la información")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ítem registrado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Información inválida o incompleta",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
            })
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> altaProducto(@Valid @RequestBody ProductoDTO dto) {
        ProductoResponseDTO nuevo = service.crearProducto(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @Operation(summary = "Consultar catálogo completo")
    @ApiResponse(responseCode = "200", description = "Inventario recuperado exitosamente")
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> obtenerCatalogo() {
        List<ProductoResponseDTO> lista = service.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Buscar detalle de producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalle encontrado"),
            @ApiResponse(responseCode = "404", description = "El ID especificado no existe",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        ProductoResponseDTO item = service.obtenerPorId(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @Operation(summary = "Filtrado por Categoría")
    @ApiResponse(responseCode = "200", description = "Resultados del filtro")
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoResponseDTO>> filtrarCategoria(@PathVariable Categoria categoria) {
        List<ProductoResponseDTO> filtrados = service.obtenerPorCategoria(categoria);
        return new ResponseEntity<>(filtrados, HttpStatus.OK);
    }

    @Operation(summary = "Modificar información del producto (PUT)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualización exitosa"),
            @ApiResponse(responseCode = "400", description = "Datos erróneos"),
            @ApiResponse(responseCode = "404", description = "Producto no hallado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> editarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO dto) {
        ProductoResponseDTO actualizado = service.actualizarProducto(id, dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @Operation(summary = "Ajuste rápido de Stock (PATCH)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nivel de stock modificado"),
            @ApiResponse(responseCode = "400", description = "Valor inválido (negativo)"),
            @ApiResponse(responseCode = "404", description = "ID incorrecto")
    })
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductoResponseDTO> ajustarStock(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarStockDTO stockDTO) {
        ProductoResponseDTO modificado = service.actualizarStock(id, stockDTO);
        return new ResponseEntity<>(modificado, HttpStatus.OK);
    }

    @Operation(summary = "Baja de producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Registro eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encontró el recurso a eliminar")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> bajaProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}