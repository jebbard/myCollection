package com.github.mycollection.collections.impl.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Collection {

   @Id
   private long id;

   @Column
   private String name;

   @Column
   private String rootPath;

   @Column
   private String pictureType;

   @Column
   private byte syncStatus;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
   private CollectionStatistics collectionStatistics;
}
