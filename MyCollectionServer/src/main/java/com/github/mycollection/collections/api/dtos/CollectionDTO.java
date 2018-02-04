package com.github.mycollection.collections.api.dtos;

import java.nio.file.Path;

public class CollectionDTO {

	private String name;
	private Path rootPath;
	private long id;
	private PictureType pictureType;
	private byte syncStatus;
	private CollectionStatisticsDTO collectionStatistics;
}
