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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * {@link MyCollectionController} is a class necessary to serve static content. It belongs to Spring MVC. However, we
 * actually do not (want) to use Spring MVC. We are building a single page web app, and for REST we use Jersey instead
 * of Spring MVC. However, to serve static content we need the dependency to Spring MVC and this class.
 * 
 * <b>Very important: </b> Do not use the same root path for the Jersey configuration and the Spring MVC root! Otherwise
 * it appears to be random whether Spring MVC or Jersey root wins. Instead, set \@ApplicationPath for Jersey to a child
 * path of the \@RequestMapping.
 * 
 * Ensure to put static content onto the classpath in specifically named folders, such as src/main/resources/static.
 */
@RestController
public class MyCollectionController {

   /**
    * @return A {@link RedirectView} to ensure the root path is redircted to the application home page.
    */
   @RequestMapping(path = "/", method = RequestMethod.GET)
   public RedirectView index() {
      return new RedirectView("/index.html");
   }
}
