package com.example.examen3accesodatos.service;

import com.example.examen3accesodatos.config.ItemConfig;
import com.example.examen3accesodatos.dto.EstadisticaDTO;
import com.example.examen3accesodatos.exception.CategoryNotFoundException;
import com.example.examen3accesodatos.exception.ItemNotFoundException;
import com.example.examen3accesodatos.model.Item;
import com.example.examen3accesodatos.repository.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemConfig itemConfig;

    public ItemService(ItemRepository itemRepository, ItemConfig itemConfig) {
        this.itemRepository = itemRepository;
        this.itemConfig = itemConfig;
    }

    public void agregarItem(Item item) {
        this.itemRepository.save(item);
    }

    public void eliminarItem(Long id) {
        this.obtenerDetalles(id);
        this.itemRepository.deleteByItemId(id);
    }

    public Item obtenerDetalles(Long id) {
        return this.itemRepository.findByItemId(id)
                .orElseThrow(() -> new ItemNotFoundException("ID no encontrado en la BD"));
    }

    public List<Item> listarPorCategoria(String categoria) {
        List<Item> items = this.itemRepository.getItemByCategory(categoria);
        if (items.isEmpty()) {
            throw new CategoryNotFoundException("Categoría no encontrada");
        } else {
            return items;
        }
    }

    public void cambiarCategoria(String categoriaAntigua, String categoriaNueva) {
        List<Item> items = this.listarPorCategoria(categoriaAntigua);
        items.forEach((item) -> item.setCategory(categoriaNueva));
        this.itemRepository.saveAll(items);
    }

    public EstadisticaDTO mostrarEstadisticas() {
        List<String> fabricantes = this.itemRepository.findAll().stream()
                .map(Item::getManufacturer)
                .filter((m) -> m != null)
                .distinct()
                .toList();
        return new EstadisticaDTO(
                this.itemRepository.count(),
                this.itemRepository.countByCountLessThan(this.itemConfig.getStockMinimo()),
                fabricantes
        );
    }
}