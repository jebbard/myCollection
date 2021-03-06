/**
 *
 * {@link PreconditionUnfullfilledException}.java
 *
 * @author Jens Ebert
 *
 * @date 08.03.2008
 *
 */

package com.github.mycollection.utils.dbc.api.exceptions;

/**
 * {@link PreconditionUnfullfilledException} is thrown whenever a specified prerequisite-condition of a class is
 * violated.
 */
public class PreconditionUnfullfilledException extends RuntimeException {

   private static final long serialVersionUID = -1124070837233774318L;

   /**
    * Creates a new {@link PreconditionUnfullfilledException}.
    * 
    * @param message
    *           The message containing the cause of this exception.
    */
   public PreconditionUnfullfilledException(String message) {
      super(message, null);
   }
}
