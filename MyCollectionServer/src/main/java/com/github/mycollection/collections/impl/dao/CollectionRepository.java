package com.github.mycollection.collections.impl.dao;

import org.springframework.data.repository.CrudRepository;

import com.github.mycollection.collections.impl.entities.Collection;

public interface CollectionRepository extends CrudRepository<Collection, Long> {

}
