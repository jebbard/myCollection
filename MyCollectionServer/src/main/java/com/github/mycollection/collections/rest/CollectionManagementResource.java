/**
 *
 * {@link CollectionManagementResource}.java
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

import com.github.mycollection.collections.api.services.CollectionManagementAPI;
import com.github.mycollection.collections.api.types.CollectionDTO;

/**
 * {@link CollectionManagementResource}
 *
 */
@Component
@Path("/collections")
public class CollectionManagementResource {

   private CollectionManagementAPI collectionManagementAPI;

   @Autowired
   public void setCollectionManagementAPI(CollectionManagementAPI collectionManagementAPI) {
      this.collectionManagementAPI = collectionManagementAPI;
   }

   @GET
   @Produces("application/json")
   public List<CollectionDTO> getCollections() {
      return collectionManagementAPI.getAllCollections();
   }
}
