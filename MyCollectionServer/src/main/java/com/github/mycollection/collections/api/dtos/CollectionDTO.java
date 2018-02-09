package com.github.mycollection.collections.api.dtos;

import java.nio.file.Path;

public class CollectionDTO {

   private Long id;
   private String name;
   private Path rootPath;
   private PictureType pictureType;
   private Byte syncStatus;
   private CollectionStatisticsDTO collectionStatistics;
   private int version;

   /**
    * Creates a new {@link CollectionDTO}.
    * 
    * @param id
    * @param name
    * @param rootPath
    * @param pictureType
    * @param syncStatus
    * @param collectionStatistics
    */
   public CollectionDTO(Long id, String name, Path rootPath, PictureType pictureType, Byte syncStatus,
      CollectionStatisticsDTO collectionStatistics, int version) {
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

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public Path getRootPath() {
      return rootPath;
   }

   public PictureType getPictureType() {
      return pictureType;
   }

   public Byte getSyncStatus() {
      return syncStatus;
   }

   public CollectionStatisticsDTO getCollectionStatistics() {
      return collectionStatistics;
   }
}
