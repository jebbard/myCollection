package com.github.mycollection.collections.impl.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.mycollection.collections.api.dtos.CollectionDTO;
import com.github.mycollection.collections.api.services.CollectionManagementAPI;
import com.github.mycollection.collections.impl.dao.CollectionRepository;
import com.github.mycollection.collections.impl.entities.Collection;

@Component
public class CollectionManagementFacade implements CollectionManagementAPI {

   private CollectionRepository collectionRepo;

   public void setCollectionRepo(CollectionRepository collectionRepo) {
      this.collectionRepo = collectionRepo;
   }

   @Transactional(readOnly = true)
   @Override
   public List<CollectionDTO> getAllCollections() {

      List<CollectionDTO> allCollections = new ArrayList<>();

      for (Collection collection : collectionRepo.findAll()) {
         allCollections.add(convertToDTO(collection));
      }

      return allCollections;
   }

   @Transactional(readOnly = true)
   @Override
   public CollectionDTO getCollection(long collectionId) {
      Collection collectionWithId = collectionRepo.findOne(collectionId);

      // TODO Auto-generated method stub
      return null;
   }

   @Transactional(readOnly = false)
   @Override
   public CollectionDTO createCollection(CollectionDTO collection) {
      // TODO Auto-generated method stub
      return null;
   }

   @Transactional(readOnly = false)
   @Override
   public void updateCollection(CollectionDTO collection) {
      // TODO Auto-generated method stub

   }

   @Transactional(readOnly = false)
   @Override
   public void deleteCollection(CollectionDTO collection) {
      // TODO Auto-generated method stub

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

   private CollectionDTO convertToDTO(Collection collection) {
      return null;
   }
}
