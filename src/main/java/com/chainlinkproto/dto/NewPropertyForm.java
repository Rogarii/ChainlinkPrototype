package com.chainlinkproto.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class NewPropertyForm implements Serializable {

	private static final long serialVersionUID = -3166941716699838289L;
	
	private String id;

	private String propName;
	
	private MultipartFile lyricsData;
	
	private MultipartFile compData;
	
	private String metaSong;
	
	private String metaArtist;
	
	private String metaAlbum;
	
	private String metaAlbumArtist;
	
	private String metaComposer;
	
	private String metaGrouping;
	
	private String metaGenre;
	
	private String metaYear;
	
	private String metaBpm;
	
	private MultipartFile metaAlbumArt;

	public String getPropName() {
		return propName;
	}

	public MultipartFile getLyricsData() {
		return lyricsData;
	}

	public MultipartFile getCompData() {
		return compData;
	}

	public String getMetaSong() {
		return metaSong;
	}

	public String getMetaArtist() {
		return metaArtist;
	}

	public String getMetaAlbum() {
		return metaAlbum;
	}

	public String getMetaAlbumArtist() {
		return metaAlbumArtist;
	}

	public String getMetaComposer() {
		return metaComposer;
	}

	public String getMetaGrouping() {
		return metaGrouping;
	}

	public String getMetaGenre() {
		return metaGenre;
	}

	public String getMetaYear() {
		return metaYear;
	}

	public String getMetaBpm() {
		return metaBpm;
	}

	public MultipartFile getMetaAlbumArt() {
		return metaAlbumArt;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public void setLyricsData(MultipartFile lyricsData) {
		this.lyricsData = lyricsData;
	}

	public void setCompData(MultipartFile compData) {
		this.compData = compData;
	}

	public void setMetaSong(String metaSong) {
		this.metaSong = metaSong;
	}

	public void setMetaArtist(String metaArtist) {
		this.metaArtist = metaArtist;
	}

	public void setMetaAlbum(String metaAlbum) {
		this.metaAlbum = metaAlbum;
	}

	public void setMetaAlbumArtist(String metaAlbumArtist) {
		this.metaAlbumArtist = metaAlbumArtist;
	}

	public void setMetaComposer(String metaComposer) {
		this.metaComposer = metaComposer;
	}

	public void setMetaGrouping(String metaGrouping) {
		this.metaGrouping = metaGrouping;
	}

	public void setMetaGenre(String metaGenre) {
		this.metaGenre = metaGenre;
	}

	public void setMetaYear(String metaYear) {
		this.metaYear = metaYear;
	}

	public void setMetaBpm(String metaBpm) {
		this.metaBpm = metaBpm;
	}

	public void setMetaAlbumArt(MultipartFile metaAlbumArt) {
		this.metaAlbumArt = metaAlbumArt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
