package com.example.examen3accesodatos.dto;

import java.util.List;

public record EstadisticaDTO(Long totalItems, Long itemsBajoStock, List<String> fabricantes) {
}
