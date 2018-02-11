/**
 *
 * {@link StaticResourceConfiguration}.java
 *
 * @author Jens Ebert
 *
 * @date 10.02.2018
 *
 */
package com.github.mycollection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * {@link StaticResourceConfiguration}
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

   private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
      "classpath:/resources/", "classpath:/static/", "classpath:/public/" };

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
   }
}