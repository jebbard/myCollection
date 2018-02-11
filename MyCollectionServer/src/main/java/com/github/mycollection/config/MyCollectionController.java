/**
 *
 * {@link MyCollectionController}.java
 *
 * @author Jens Ebert
 *
 * @date 11.02.2018
 *
 */
package com.github.mycollection.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCollectionController {

   @RequestMapping("/")
   public String index() {
      return "Greetings from Spring Boot!";
   }

}
