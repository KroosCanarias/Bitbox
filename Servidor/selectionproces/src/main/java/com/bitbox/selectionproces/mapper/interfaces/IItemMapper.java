package com.bitbox.selectionproces.mapper.interfaces;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.model.Item;

public interface IItemMapper {
    public Item DTOToItem(ItemDTO item);
    public ItemDTO itemToDTO(Item item);
}
