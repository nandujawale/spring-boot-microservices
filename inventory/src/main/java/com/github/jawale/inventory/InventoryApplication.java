package com.github.jawale.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    //    @Bean
    //    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
    //        return args -> {
    //            Inventory inventory = new Inventory();
    //            inventory.setSkuCode("aaaa");
    //            inventory.setQuantity(5);
    //            inventoryRepository.save(inventory);
    //
    //            Inventory inventory1 = new Inventory();
    //            inventory1.setSkuCode("bbbb");
    //            inventory1.setQuantity(0);
    //            inventoryRepository.save(inventory1);
    //        };
    //    }
}
