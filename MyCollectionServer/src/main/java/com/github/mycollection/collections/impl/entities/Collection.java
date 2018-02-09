package com.github.mycollection.collections.impl.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.github.mycollection.utils.entity.api.types.AbstractVersionedEntity;

@Entity
public class Collection extends AbstractVersionedEntity<Long, Integer> {

   @Column
   private String name;

   @Column
   private String rootPath;

   @Column
   private String pictureType;

   @Column
   private Byte syncStatus;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
   private CollectionStatistics collectionStatistics;

   /**
    * Creates a new {@link Collection}.
    */
   public Collection() {
   }

   public String getName() {
      return name;
   }

   public String getRootPath() {
      return rootPath;
   }

   public String getPictureType() {
      return pictureType;
   }

   public Byte getSyncStatus() {
      return syncStatus;
   }

   public CollectionStatistics getCollectionStatistics() {
      return collectionStatistics;
   }

   /**
    * Creates a new {@link Collection}.
    * 
    * @param id
    * @param name
    * @param rootPath
    * @param pictureType
    * @param syncStatus
    * @param collectionStatistics
    */
   public Collection(Long id, String name, String rootPath, String pictureType, Byte syncStatus,
      CollectionStatistics collectionStatistics, Integer version) {
      super(id, version);
      this.name = name;
      this.rootPath = rootPath;
      this.pictureType = pictureType;
      this.syncStatus = syncStatus;
      this.collectionStatistics = collectionStatistics;
   }
}
