package com.github.mycollection.collections.api.types;

import java.nio.file.Path;

import com.github.mycollection.utils.entity.api.types.AbstractVersionedTO;

public class CollectionDTO extends AbstractVersionedTO<Long, Integer> {

   private String name;
   private Path rootPath;
   private PictureType pictureType;
   private Byte syncStatus;
   private CollectionStatisticsDTO collectionStatistics;

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
      CollectionStatisticsDTO collectionStatistics, Integer version) {
      super(id, version);
      this.name = name;
      this.rootPath = rootPath;
      this.pictureType = pictureType;
      this.syncStatus = syncStatus;
      this.collectionStatistics = collectionStatistics;
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
