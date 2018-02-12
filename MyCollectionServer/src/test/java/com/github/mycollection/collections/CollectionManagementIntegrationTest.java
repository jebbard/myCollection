/**
 *
 * {@link CollectionManagementIntegrationTest}.java
 *
 * @author Jens Ebert
 *
 * @date 12.02.2018
 *
 */
package com.github.mycollection.collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.mycollection.collections.api.services.CollectionManagementAPI;

/**
 * {@link CollectionManagementIntegrationTest}
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:testCollections.sql")
public class CollectionManagementIntegrationTest {

   @LocalServerPort
   private int port;

   @Autowired
   private CollectionManagementAPI api;

   @Test
   public void test() {
      System.out.println("################ PORT: " + port);
      api.getAllCollections();
      Assert.assertTrue(true);
   }

}
