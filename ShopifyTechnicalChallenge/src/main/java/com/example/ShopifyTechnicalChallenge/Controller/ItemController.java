package com.example.ShopifyTechnicalChallenge.Controller;

import com.example.ShopifyTechnicalChallenge.Entity.Item;
import com.example.ShopifyTechnicalChallenge.Services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
Controller to Handle all the operation that available
 */

@Controller
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }


    @GetMapping(value={"", "/", "/Items"})
    public String listItems(Model model){
        model.addAttribute("Items",itemService.getAllItems());

        return "Items";
    }
    @GetMapping("/Items/new")
    public String createNewItemForm(Model model){
        Item item = new Item(); //Creating a blank item for use
        model.addAttribute("item", item);
        return "newItem";
    }
    @PostMapping("/Items")
    public String saveItem(@ModelAttribute("item") Item item){
        itemService.saveItem(item);
        return "redirect:/Items";
    }

    @GetMapping("/Items/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model){
        //Grabbing the item to edit
        model.addAttribute("item",itemService.getItemById(id));
        return "editItem";
    }

    @PostMapping("/Items/edit/{id}")
    public String editItem(@PathVariable Long id,
                @ModelAttribute("item") Item item,
                Model model){

        Item oldItem = itemService.getItemById(id); //Grab item from db
        oldItem.setId(id);  //Set values from dbItem to the one of the new item
        oldItem.setItemName(item.getItemName());
        oldItem.setQty(item.getQty());
        itemService.saveItem(oldItem);
        return "redirect:/Items";
    }



    @GetMapping("/Items/delete_comm/{id}")
    public String deleteItemForm(@PathVariable Long id, Model model){
        model.addAttribute("item",itemService.getItemById(id));
        return "deleteItemForm";
    }

    @PostMapping("/Items/delete/{id}")
    public String deleteAndCommentItem(@PathVariable Long id,
                           @ModelAttribute("item") Item item,
                           Model model){
        //Grab item from db
        Item oldItem = itemService.getItemById(id);

        oldItem.setComment(item.getComment());
        itemService.saveItem(oldItem);
        itemService.deleteItem(id);
        if(oldItem.getDeleted()){ //Check what page we were just at and redirect back to it
            //Could also use referer header here instead, but that is unreliable

            return "redirect:/Items/recycle";
        }else{
            return "redirect:/Items";
        }

    }


    @GetMapping("/Items/recycle")
    public String recycle(Model model){
        model.addAttribute("Items",itemService.getAllItems());
        return "deletedItems";
    }
    @GetMapping("/Items/recycle/{id}")
    public String restoreItem(@PathVariable Long id,
                              @ModelAttribute("item") Item item,
                              Model model){
        Item restoreItem = (itemService.getItemById(id));

        restoreItem.setDeleted(false);
        itemService.saveItem(restoreItem);
        return "redirect:/Items/recycle";
    }



}
