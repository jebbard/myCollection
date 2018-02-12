/**
 *
 * {@link VersionedEntity}.java
 *
 * @author Jens Ebert
 *
 * @date 09.02.2018
 *
 */
package com.github.mycollection.utils.entity.api.types;

/**
 * {@link VersionedEntity}
 *
 */
public interface VersionedEntity<PK, V> {

   public PK getId();

   public V getVersion();

}
