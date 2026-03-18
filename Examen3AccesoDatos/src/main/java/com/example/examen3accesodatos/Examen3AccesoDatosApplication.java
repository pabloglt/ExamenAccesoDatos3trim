package com.example.examen3accesodatos;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Gracias a la dependencia de Swagger, se pueden usar los endpoints en el navegador, visualmente es mas atractivo.
//El securityScheme es obligatorio para ello
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class Examen3AccesoDatosApplication {
    public static void main(String[] args) {
        SpringApplication.run(Examen3AccesoDatosApplication.class, args);
    }
}