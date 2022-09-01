package com.bitbox.selectionproces.dao.interfaces;

import com.bitbox.selectionproces.model.Item;

import java.util.List;

public interface IItemDAO {
    public List<Item> getAllItem();
    public List<Item> getAllItemByState(boolean state);
    public void deleteItem(Long item_id);
    public void addItem(Item item);
    public void updateItem(Item item);

    public Item addPriceReduction(Long priceId, Long id);
    public Item addSupplier(Long supplierId, Long id);
    //public List<Item> getCheapestItemBySupplier();

}
