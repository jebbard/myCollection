package com.github.mycollection;

import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import com.github.mycollection.collections.api.types.CollectionDTO;
import com.github.mycollection.collections.api.types.CollectionStatisticsDTO;
import com.github.mycollection.collections.api.types.PictureType;
import com.github.mycollection.collections.impl.facade.CollectionManagementFacade;

@SpringBootApplication
public class MyCollectionServerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

   private static final Logger log = LoggerFactory.getLogger(MyCollectionServerApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(MyCollectionServerApplication.class, args);
   }

   @Bean
   public CommandLineRunner demo(CollectionManagementFacade facade) {
      return (args) -> {
         facade.createCollection(new CollectionDTO(null, "Rock", Paths.get("E:\\Musik\\Rock"), PictureType.ROCK1, null,
            new CollectionStatisticsDTO(null, 10, 9, 11210, "100 albums", null), null));
         facade
            .createCollection(new CollectionDTO(null, "Electro", Paths.get("E:\\Musik\\Electro"), PictureType.ELECTRO1,
               null, new CollectionStatisticsDTO(null, 0, 5, 210, "10 songs, 100 albums", null), null));
         facade.createCollection(new CollectionDTO(null, "Andere", Paths.get("E:\\Musik\\Andere"), PictureType.MUSIC1,
            null, new CollectionStatisticsDTO(null, 10, 1, 1130, "1000 labels, 100 albums", null), null));

         // fetch all collections
         log.info("Collections found with getAllCollections():");
         log.info("-------------------------------------------");
         for (CollectionDTO collection : facade.getAllCollections()) {
            log.info(collection.toString());
         }
         log.info("");

         // fetch an individual collection by ID
         CollectionDTO collection = facade.getCollection(1L);
         log.info("Collection found with getCollection(1L):");
         log.info("--------------------------------");
         log.info(collection.toString());
         log.info("");
      };
   }
}
