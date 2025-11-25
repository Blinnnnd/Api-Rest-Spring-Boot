package com.utn.productos_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "SISTEMA DE GESTIÓN DE INVENTARIO Y CONTROL DE STOCK DE PRODUCTOS",
        version = "1.0.0",
        description = "API RESTful profesional para la gestión centralizada de inventario y control de stock."
    )
)
public class ProductosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosApiApplication.class, args);
	}

}