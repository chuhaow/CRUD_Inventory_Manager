package com.example.ShopifyTechnicalChallenge;

import com.example.ShopifyTechnicalChallenge.Controller.ItemController;
import com.example.ShopifyTechnicalChallenge.Entity.Item;
import com.example.ShopifyTechnicalChallenge.Repository.ItemRepository;
import com.example.ShopifyTechnicalChallenge.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.example.ShopifyTechnicalChallenge.Entity"})
@ComponentScan(basePackageClasses = {ItemController.class})
@ComponentScan(basePackageClasses = {ItemService.class})
public class ShopifyTechnicalChallengeApplication  implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShopifyTechnicalChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Item i1 = new Item((long)1,"Test",2);
		itemRepo.save(i1);

		Item i2 = new Item((long)2,"Peanuts",2);
		itemRepo.save(i2);*/
	}
}
