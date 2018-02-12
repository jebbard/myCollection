package com.github.mycollection.collections.impl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.github.mycollection.utils.entity.api.types.AbstractVersionedEntity;

@Entity
public class CollectionStatistics extends AbstractVersionedEntity<Long, Integer> {

   @Column
   private int numberOfFiles;

   @Column
   private int numberOfFolders;

   @Column
   private long totalSizeInBytes;

   @Column
   private String statisticsSummary;

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
