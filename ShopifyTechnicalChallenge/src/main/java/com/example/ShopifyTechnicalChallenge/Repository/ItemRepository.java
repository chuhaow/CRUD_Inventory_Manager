package com.example.ShopifyTechnicalChallenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.ShopifyTechnicalChallenge.Entity.Item;

import java.util.List;

@EnableJpaRepositories
public interface ItemRepository extends JpaRepository <Item,Long> {

    @Override
    @Query("select e from #{#entityName} e where e.deleted = true or e.deleted = false") //filter out null items
    List<Item> findAll();


}