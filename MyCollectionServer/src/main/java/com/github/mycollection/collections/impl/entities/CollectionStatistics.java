package com.github.mycollection.collections.impl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CollectionStatistics {
	
	@Id
	private long id;
	
	@Column
	private int numberOfFiles;
	
	@Column
	private int numberOfFolders;
	
	@Column
	private long totalSizeInBytes;
	
	@Column
	private String statisticsSummary;
}
