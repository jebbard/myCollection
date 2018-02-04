package com.github.mycollection.collections.api.dtos;

public enum PictureType {

	ROCK1("Rock1"),
	ELECTRO1("Electro1"),
	MUSIC1("Music1"),
	;
	
	private String name;
	
	private PictureType(String name) {
		this.name = name;
	}
}
