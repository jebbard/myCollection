package com.github.mycollection.collections.impl.facade;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.mycollection.collections.api.services.CollectionManagementAPI;
import com.github.mycollection.collections.api.types.CollectionDTO;
import com.github.mycollection.collections.api.types.CollectionStatisticsDTO;
import com.github.mycollection.collections.api.types.PictureType;
import com.github.mycollection.collections.impl.dao.CollectionRepository;
import com.github.mycollection.collections.impl.entities.Collection;
import com.github.mycollection.collections.impl.entities.CollectionStatistics;
import com.github.mycollection.utils.dbc.api.services.Reject;

@Component
public class CollectionManagementFacade implements CollectionManagementAPI {

   private CollectionRepository collectionRepo;

   @Autowired
   public void setCollectionRepo(CollectionRepository collectionRepo) {
      this.collectionRepo = collectionRepo;
   }

   @Transactional(readOnly = true)
   @Override
   public List<CollectionDTO> getAllCollections() {

      List<CollectionDTO> allCollections = new ArrayList<>();

      for (Collection collection : collectionRepo.findAll()) {
         allCollections.add(convertToCollectionDTO(collection));
      }

      return allCollections;
   }

   @Transactional(readOnly = true)
   @Override
   public CollectionDTO getCollection(long collectionId) {
      Collection collectionWithId = collectionRepo.findOne(collectionId);

      return convertToCollectionDTO(collectionWithId);
   }

   @Transactional(readOnly = false)
   @Override
   public CollectionDTO createCollection(CollectionDTO collection) {
      Reject.ifNull(collection, "collection");

      Collection collectionEntity = convertToCollectionEntity(collection);

      collectionEntity = collectionRepo.save(collectionEntity);

      collection.setVersionedEntity(collectionEntity);

      return collection;
   }

   @Transactional(readOnly = false)
   @Override
   public void updateCollection(CollectionDTO collection) {
      Reject.ifNull(collection, "collection");

      Collection collectionEntity = convertToCollectionEntity(collection);

      collectionRepo.save(collectionEntity);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteCollection(CollectionDTO collection) {
      Reject.ifNull(collection, "collection");

      Collection collectionEntity = convertToCollectionEntity(collection);

      collectionRepo.delete(collectionEntity);
   }

   @Transactional(readOnly = false)
   @Override
   public void synchCollection(long collectionId) {
      // TODO Auto-generated method stub

   }

   @Transactional(readOnly = false)
   @Override
   public void cancelSynchCollection(long collectionId) {
      // TODO Auto-generated method stub

   }

   private CollectionStatisticsDTO convertToCollectionStatisticsDTO(CollectionStatistics collectionStatistics) {
      return new CollectionStatisticsDTO(collectionStatistics.getId(), collectionStatistics.getNumberOfFiles(),
         collectionStatistics.getNumberOfFolders(), collectionStatistics.getTotalSizeInBytes(),
         collectionStatistics.getStatisticsSummary(), collectionStatistics.getVersion());
   }

   private CollectionStatistics convertToCollectionStatisticsEntity(CollectionStatisticsDTO collectionStatistics) {
      return new CollectionStatistics(collectionStatistics.getId(), collectionStatistics.getNumberOfFiles(),
         collectionStatistics.getNumberOfFolders(), collectionStatistics.getTotalSizeInBytes(),
         collectionStatistics.getStatisticsSummary(), collectionStatistics.getVersion());
   }

   private CollectionDTO convertToCollectionDTO(Collection collection) {
      return new CollectionDTO(collection.getId(), collection.getName(), Paths.get(collection.getRootPath()),
         PictureType.valueOf(collection.getPictureType()), collection.getSyncStatus(),
         convertToCollectionStatisticsDTO(collection.getCollectionStatistics()), collection.getVersion());
   }

   private Collection convertToCollectionEntity(CollectionDTO collection) {
      return new Collection(collection.getId(), collection.getName(), collection.getRootPath().toString(),
         collection.getPictureType().toString(), collection.getSyncStatus(),
         convertToCollectionStatisticsEntity(collection.getCollectionStatistics()), collection.getVersion());
   }
}
