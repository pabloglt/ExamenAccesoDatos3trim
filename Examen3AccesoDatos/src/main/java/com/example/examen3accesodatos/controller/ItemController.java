package com.example.examen3accesodatos.controller;

import com.example.examen3accesodatos.dto.EstadisticaDTO;
import com.example.examen3accesodatos.model.Item;
import com.example.examen3accesodatos.service.ItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "basicAuth")
@RequestMapping({"/items"})
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Void> agregarItem(@RequestBody Item item) {
        this.itemService.agregarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        this.itemService.eliminarItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> obtenerDetalles(@PathVariable Long id) {
        return ResponseEntity.ok(this.itemService.obtenerDetalles(id));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Item>> listarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(this.itemService.listarPorCategoria(categoria));
    }

    @PutMapping("/categoria")
    public ResponseEntity<Void> cambiarCategoria(
            @RequestParam String catAntigua,
            @RequestParam String catNueva) {
        this.itemService.cambiarCategoria(catAntigua, catNueva);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/stats")
    public ResponseEntity<EstadisticaDTO> mostrarEstadisticas() {
        return ResponseEntity.ok(this.itemService.mostrarEstadisticas());
    }
}