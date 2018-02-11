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

import com.github.mycollection.collections.rest.CollectionManagementRessource;

/**
 * {@link MyCollectionEndpointConfig}
 *
 */
@Component
@ApplicationPath("/api")
public class MyCollectionEndpointConfig extends ResourceConfig {

   public MyCollectionEndpointConfig() {
      registerEndpoints();
   }

   private void registerEndpoints() {
      register(CollectionManagementRessource.class);
   }
}
