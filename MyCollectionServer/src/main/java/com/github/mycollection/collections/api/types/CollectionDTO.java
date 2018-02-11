package com.github.mycollection.collections.api.types;

import java.nio.file.Path;

import com.github.mycollection.utils.entity.api.types.AbstractVersionedTO;

public class CollectionDTO extends AbstractVersionedTO<Long, Integer> {

   private String name;
   private Path localRootPath;
   private PictureType pictureType;
   private Byte syncStatus;
   private CollectionStatisticsDTO statistics;

   /**
    * Creates a new {@link CollectionDTO}.
    * 
    * @param id
    * @param name
    * @param rootPath
    * @param pictureType
    * @param syncStatus
    * @param statistics
    */
   public CollectionDTO(Long id, String name, Path rootPath, PictureType pictureType, Byte syncStatus,
      CollectionStatisticsDTO statistics, Integer version) {
      super(id, version);
      this.name = name;
      this.localRootPath = rootPath;
      this.pictureType = pictureType;
      this.syncStatus = syncStatus;
      this.statistics = statistics;
   }

   public String getName() {
      return name;
   }

   public Path getLocalRootPath() {
      return localRootPath;
   }

   public PictureType getPictureType() {
      return pictureType;
   }

   public Byte getSyncStatus() {
      return syncStatus;
   }

   public CollectionStatisticsDTO getStatistics() {
      return statistics;
   }
}
