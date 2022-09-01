package com.bitbox.selectionproces.dao.imp;

import com.bitbox.selectionproces.dao.interfaces.IItemDAO;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.model.Supplier;
import com.bitbox.selectionproces.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ItemDAOImp implements IItemDAO {


    @PersistenceContext
    EntityManager entitryManager;
    @Autowired
    private ItemRepository repository;


    @Override
    public List<Item> getAllItem() {
        return (List<Item>)repository.findAll();
    }

    @Override
    public List<Item> getAllItemByState(boolean state) {

        String hql="FROM usuario where state=: state";
        List<Item> itemList=(List<Item>)entitryManager.createQuery(hql)
                .setParameter("state",state)
                .getResultList();
        return itemList;
    }

    @Override
    public void deleteItem(Long item_id) {
        if(item_id==null) return ;
        repository.deleteById(item_id);
    }

    @Override
    public void addItem(Item item) {
        if(item==null)return;
        repository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        if(item==null)return;
        repository.save(item);
    }


    @Override
    public Item addPriceReduction(Long idPrice, Long id) {
        if(idPrice==null||id==null) return null;
        Item item=getItemById(id);
        PriceReduction priceReduction=getPriceReductionById(idPrice);
        item.addPriceReduction(priceReduction);
        priceReduction.getItemList().add(item);
        repository.save(item);
        return item;
    }

    @Override
    public Item addSupplier(Long supplierId, Long id) {
        Item item=getItemById(id);
        if(supplierId==null || id==null ||item==null) return null;

        Supplier supplier=getSupplierById(supplierId);
        item.addSupplier(supplier);
        repository.save(item);
        return item;
    }

    private Item getItemById(Long id){
        if(id==null)return null;
        String hql="FROM Item u where u.id=:id";
        List<Item> itemList=(List<Item>)entitryManager.createQuery(hql)
                .setParameter("id",id)
                .getResultList();
        if(itemList.size()==0)return null;
        return itemList.get(0);
    }
    private Supplier getSupplierById(Long id){
        if(id==null)return null;
        String hql="FROM Supplier u where u.id=:id";
        List<Supplier> itemList=(List<Supplier>)entitryManager.createQuery(hql)
                .setParameter("id",id)
                .getResultList();
        if(itemList.size()==0)return null;
        return itemList.get(0);
    }
    private PriceReduction getPriceReductionById(Long id){
        if(id==null) return null;
        String hql="FROM PriceReduction u where u.id=:id";
        List<PriceReduction> itemList=(List<PriceReduction>)entitryManager.createQuery(hql)
                .setParameter("id",id)
                .getResultList();
        return itemList.get(0);
    }


}
