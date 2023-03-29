package com.workshop.kartaca.repository;

import com.workshop.kartaca.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findById(Integer id);
    List<Item> findAll();
}
