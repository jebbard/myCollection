package com.github.mycollection.collections.api.dtos;

public class CollectionStatisticsDTO {

   private Long id;

   public Long getId() {
      return id;
   }

   private int numberOfFiles;
   private int numberOfFolders;
   private long totalSizeInBytes;
   private String statisticsSummary;
   private int version;

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
      String statisticsSummary, int version) {
      this.id = id;
      this.numberOfFiles = numberOfFiles;
      this.numberOfFolders = numberOfFolders;
      this.totalSizeInBytes = totalSizeInBytes;
      this.statisticsSummary = statisticsSummary;
   }

   public int getVersion() {
      return version;
   }
}
