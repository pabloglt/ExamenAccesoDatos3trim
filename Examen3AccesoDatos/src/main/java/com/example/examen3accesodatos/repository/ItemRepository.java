package com.example.examen3accesodatos.repository;

import com.example.examen3accesodatos.model.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    // Cambiado de String a Long para coincidir con el campo itemId de la clase Item
    Optional<Item> findByItemId(Long itemId);

    @Transactional
    void deleteByItemId(Long itemId);

    List<Item> getItemByCategory(String category);

    Long countByCountLessThan(Integer stockMinimo);
}