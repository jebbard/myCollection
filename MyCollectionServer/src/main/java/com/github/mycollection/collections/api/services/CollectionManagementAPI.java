package com.github.mycollection.collections.api.services;

import java.util.List;

import com.github.mycollection.collections.api.dtos.CollectionDTO;

public interface CollectionManagementAPI {
	public List<CollectionDTO> getAllCollections();
	public CollectionDTO getCollection(long collectionId);
	public CollectionDTO createCollection(CollectionDTO collection);
	public void updateCollection(CollectionDTO collection);
	public void deleteCollection(CollectionDTO collection);
	public void synchCollection(long collectionId);
	public void cancelSynchCollection(long collectionId);
}
