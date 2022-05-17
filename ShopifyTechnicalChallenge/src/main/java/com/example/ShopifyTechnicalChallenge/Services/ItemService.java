package com.example.ShopifyTechnicalChallenge.Services;

import com.example.ShopifyTechnicalChallenge.Entity.Item;
import com.example.ShopifyTechnicalChallenge.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepo;

    public ItemService(ItemRepository itemRepo){
        this.itemRepo = itemRepo;
    }

    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

    public Item saveItem(Item item){
        return itemRepo.save(item);
    }

    public Item getItemById(Long id){
        return itemRepo.findById(id).get();
    }

    public void deleteItem(Long id){
        itemRepo.deleteById(id);
    }


}
