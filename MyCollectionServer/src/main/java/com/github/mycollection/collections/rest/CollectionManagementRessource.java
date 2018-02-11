/**
 *
 * {@link CollectionManagementRessource}.java
 *
 * @author Jens Ebert
 *
 * @date 09.02.2018
 *
 */
package com.github.mycollection.collections.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.github.mycollection.collections.api.services.CollectionManagementAPI;
import com.github.mycollection.collections.api.types.CollectionDTO;

/**
 * {@link CollectionManagementRessource}
 *
 */
@Component
@Path("/api/collections")
public class CollectionManagementRessource {

   private CollectionManagementAPI collectionManagementAPI;

   @Autowired
   public void setCollectionManagementAPI(CollectionManagementAPI collectionManagementAPI) {
      this.collectionManagementAPI = collectionManagementAPI;
   }

   @GET
   @Produces("application/json")
   @CrossOrigin(origins = "http://localhost:4200")
   public List<CollectionDTO> getCollections() {
      return collectionManagementAPI.getAllCollections();
   }
}
