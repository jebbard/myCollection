package com.github.mycollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.mycollection.collections.api.dtos.CollectionDTO;
import com.github.mycollection.collections.api.dtos.PictureType;
import com.github.mycollection.collections.impl.dao.CollectionRepository;
import com.github.mycollection.collections.impl.entities.Collection;
import com.github.mycollection.collections.impl.entities.CollectionStatistics;
import com.github.mycollection.collections.impl.facade.CollectionManagementFacade;

@SpringBootApplication
public class MyCollectionServerApplication {

   private static final Logger log = LoggerFactory.getLogger(MyCollectionServerApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(MyCollectionServerApplication.class, args);
   }

   @Bean
   public CommandLineRunner demo(CollectionRepository repository, CollectionManagementFacade facade) {
      return (args) -> {
         // save a couple of customers
         repository.save(new Collection(null, "Rock", "E:\\Musik\\Rock", PictureType.ROCK1.toString(), null,
            new CollectionStatistics(null, 10, 9, 11210, "100 albums", 1), 1));
         repository.save(new Collection(null, "Electro", "E:\\Musik\\Electro", PictureType.ELECTRO1.toString(), null,
            new CollectionStatistics(null, 0, 5, 210, "10 songs, 100 albums", 1), 1));
         repository.save(new Collection(null, "Andere", "E:\\Musik\\Andere", PictureType.MUSIC1.toString(), null,
            new CollectionStatistics(null, 10, 1, 1130, "1000 labels, 100 albums", 1), 1));

         // fetch all customers
         log.info("Collections found with findAll():");
         log.info("-------------------------------");
         for (Collection collection : repository.findAll()) {
            log.info(collection.toString());
         }
         log.info("");

         // fetch all customers
         log.info("Collections found with getAllCollections():");
         log.info("-------------------------------------------");
         for (CollectionDTO collection : facade.getAllCollections()) {
            log.info(collection.toString());
         }
         log.info("");

         // fetch an individual customer by ID
         Collection collection = repository.findOne(1L);
         log.info("Customer found with findOne(1L):");
         log.info("--------------------------------");
         log.info(collection.toString());
         log.info("");
      };
   }
}
