package com.github.mycollection.utils.entity.api.types;

import java.io.Serializable;

/**
 * {@link AbstractVersionedTO} is the base class of all TOs (transport objects) that contain data for a single,
 * identifiable and (optimistic locking) versioned objects.
 *
 * @param <PK>
 *           The type of the primary key
 * @param <V>
 *           The type of the version
 */
public abstract class AbstractVersionedTO<PK, V> implements Serializable {

   private PK id;
   private V version;
   private VersionedEntity<PK, V> versionedEntity;

   public void setVersionedEntity(VersionedEntity<PK, V> versionedEntity) {
      this.versionedEntity = versionedEntity;
   }

   private static final long serialVersionUID = 1L;

   /**
    * Creates a new {@link AbstractVersionedTO}.
    * 
    * @param version
    */
   public AbstractVersionedTO(PK id, V version) {
      this.id = id;
      this.version = version;
   }

   /**
    * @return the primary key
    */
   public PK getId() {
      if (id == null && versionedEntity != null) {
         return versionedEntity.getId();
      }

      return id;
   }

   /**
    * @return the version
    */
   public V getVersion() {
      if (version == null && versionedEntity != null) {
         return versionedEntity.getVersion();
      }

      return version;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((version == null) ? 0 : version.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      @SuppressWarnings("rawtypes")
      AbstractVersionedTO other = (AbstractVersionedTO) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (version == null) {
         if (other.version != null)
            return false;
      } else if (!version.equals(other.version))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "AbstractVersionedTO [getId()=" + getId() + ", getVersion()=" + getVersion() + "]";
   }
}
