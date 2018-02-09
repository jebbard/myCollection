package com.github.mycollection.collections.impl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class CollectionStatistics {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private int numberOfFiles;

   @Column
   private int numberOfFolders;

   @Column
   private long totalSizeInBytes;

   @Column
   private String statisticsSummary;

   @Version
   @Column
   private int version;

   /**
    * Creates a new {@link CollectionStatistics}.
    */
   public CollectionStatistics() {
   }

   /**
    * Creates a new {@link CollectionStatistics}.
    * 
    * @param numberOfFiles
    * @param numberOfFolders
    * @param totalSizeInBytes
    * @param statisticsSummary
    */
   public CollectionStatistics(Long id, int numberOfFiles, int numberOfFolders, long totalSizeInBytes,
      String statisticsSummary, int version) {
      this.id = id;
      this.numberOfFiles = numberOfFiles;
      this.numberOfFolders = numberOfFolders;
      this.totalSizeInBytes = totalSizeInBytes;
      this.statisticsSummary = statisticsSummary;
      this.version = version;
   }

   public int getVersion() {
      return version;
   }

   public Long getId() {
      return id;
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
