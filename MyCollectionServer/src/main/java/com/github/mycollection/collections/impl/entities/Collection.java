package com.github.mycollection.collections.impl.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Collection {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

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

   @Version
   @Column
   private int version;

   /**
    * Creates a new {@link Collection}.
    */
   public Collection() {
   }

   public Long getId() {
      return id;
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
      CollectionStatistics collectionStatistics, int version) {
      this.id = id;
      this.name = name;
      this.rootPath = rootPath;
      this.pictureType = pictureType;
      this.syncStatus = syncStatus;
      this.collectionStatistics = collectionStatistics;
      this.version = version;
   }

   public int getVersion() {
      return version;
   }
}
