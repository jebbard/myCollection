package com.github.mycollection.utils.entity.api.types;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * {@link AbstractVersionedEntity}
 *
 * @param <PK>
 * @param <V>
 */
@MappedSuperclass
public abstract class AbstractVersionedEntity<PK, V> implements VersionedEntity<PK, V> {

   /**
    * Creates a new {@link AbstractVersionedEntity}.
    * 
    * @param id
    * @param version
    */
   public AbstractVersionedEntity(PK id, V version) {
      this.id = id;
      this.version = version;
   }

   /**
    * Creates a new {@link AbstractVersionedEntity}.
    */
   public AbstractVersionedEntity() {
      super();
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private PK id;

   @Version
   @Column
   private V version;

   /**
    * @return the primary key
    */
   public PK getId() {
      return id;
   }

   /**
    * @return the version
    */
   public V getVersion() {
      return version;
   }
}
