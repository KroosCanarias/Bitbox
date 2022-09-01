package com.bitbox.selectionproces.repository;

import com.bitbox.selectionproces.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
