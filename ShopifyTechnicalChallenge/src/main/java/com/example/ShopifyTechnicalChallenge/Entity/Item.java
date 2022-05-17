package com.example.ShopifyTechnicalChallenge.Entity;

import org.hibernate.annotations.SQLDelete;


import javax.persistence.*;
/*
Enity  To Represent a Item in the System

 */
@Entity
@Table(name = "Items")
@SQLDelete(sql = "UPDATE Items SET deleted = true WHERE id=?") //Override delete command
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(name = "quantity")
    private int qty;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;
    @Column(name = "deletion_comment")
    private String comment ="";

    public Item(){

    }

    public Item(Long id, String itemName, int qty){
        super();
        this.id = id;
        this.itemName = itemName;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }

    public boolean getDeleted(){
        return this.deleted;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getComment(){
        return this.comment;
    }
}
