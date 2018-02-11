package com.github.mycollection.collections.api.types;

import com.github.mycollection.utils.entity.api.types.AbstractVersionedTO;

public class CollectionStatisticsDTO extends AbstractVersionedTO<Long, Integer> {

   private int numberOfFiles;
   private int numberOfFolders;
   private long totalSizeInBytes;
   private String statisticsSummary;

   /**
    * Creates a new {@link CollectionStatisticsDTO}.
    * 
    * @param numberOfFiles
    * @param numberOfFolders
    * @param totalSizeInBytes
    * @param statisticsSummary
    * @param version
    *           TODO
    */
   public CollectionStatisticsDTO(Long id, int numberOfFiles, int numberOfFolders, long totalSizeInBytes,
      String statisticsSummary, Integer version) {
      super(id, version);
      this.numberOfFiles = numberOfFiles;
      this.numberOfFolders = numberOfFolders;
      this.totalSizeInBytes = totalSizeInBytes;
      this.statisticsSummary = statisticsSummary;
   }

   public int getNumberOfFiles() {
      return numberOfFiles;
   }

   public int getNumberOfFolders() {
      return numberOfFolders;
   }

   public long getTotalSizeInBytes() {
      return totalSizeInBytes;
   }

   public String getStatisticsSummary() {
      return statisticsSummary;
   }
}
