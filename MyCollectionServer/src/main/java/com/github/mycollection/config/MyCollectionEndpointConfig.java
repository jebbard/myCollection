/**
 *
 * {@link MyCollectionEndpointConfig}.java
 *
 * @author Jens Ebert
 *
 * @date 09.02.2018
 *
 */
package com.github.mycollection.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.github.mycollection.collections.rest.CollectionManagementResource;

/**
 * {@link MyCollectionEndpointConfig} is the necessary endpoint configuration for using Jersey. Be sure to register all
 * REST Jersey resource classes in {@link #registerEndpoints()}!
 * 
 * <b>Very important: </b> Do not use the same root path for the Jersey configuration and the Spring MVC root! Otherwise
 * it appears to be random whether Spring MVC or Jersey root wins. Instead, set \@ApplicationPath for Jersey to a child
 * path of the \@RequestMapping.
 */
@Component
@ApplicationPath("/api")
public class MyCollectionEndpointConfig extends ResourceConfig {

   /**
    * Creates a new {@link MyCollectionEndpointConfig}.
    */
   public MyCollectionEndpointConfig() {
      registerEndpoints();
   }

   /**
    * Registers all needed REST endpoint resources.
    */
   private void registerEndpoints() {
      register(CollectionManagementResource.class);
   }
}
