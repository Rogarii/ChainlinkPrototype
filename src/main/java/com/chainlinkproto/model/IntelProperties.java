package com.chainlinkproto.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "IntelProperties")
public class IntelProperties implements Serializable{

	private static final long serialVersionUID = -7595230403837545071L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="AccountID", nullable = false)
	private Accounts account;
	
	@NotEmpty
	@Column(name = "PropName")
	private String propName;
	
	@Column(name = "DateAdded")
	private Timestamp dateAdded;
	
	@Column(name = "DateModified")
	private Timestamp dateModified;
	
	@Column(name = "LyricsData")
	private byte[] lyricsData;
	
	@Column(name = "CompData")
	private byte[] compData;
	
	@Column(name = "Meta_Song")
	private String metaSong;
	
	@Column(name = "Meta_Artist")
	private String metaArtist;
	
	@Column(name = "Meta_Album")
	private String metaAlbum;
	
	@Column(name = "Meta_AlbumArtist")
	private String metaAlbumArtist;
	
	@Column(name = "Meta_Composer")
	private String metaComposer;
	
	@Column(name = "Meta_Grouping")
	private String metaGrouping;
	
	@Column(name = "Meta_Genre")
	private String metaGenre;
	
	@Column(name = "Meta_Year")
	private Integer metaYear;
	
	@Column(name = "Meta_Bpm")
	private Integer metaBpm;
	
	@Column(name = "Meta_AlbumArt")
	private byte[] metaAlbumArt;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ContractProperties", joinColumns = { @JoinColumn(name = "PropertyID") }, inverseJoinColumns = { @JoinColumn(name = "ContractID")})
	private Set<Contracts> contracts = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public Accounts getAccount() {
		return account;
	}

	public String getPropName() {
		return propName;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public byte[] getLyricsData() {
		return lyricsData;
	}

	public byte[] getCompData() {
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

	public Integer getMetaYear() {
		return metaYear;
	}

	public Integer getMetaBpm() {
		return metaBpm;
	}

	public byte[] getMetaAlbumArt() {
		return metaAlbumArt;
	}

	public Set<Contracts> getContracts() {
		return contracts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public void setLyricsData(byte[] lyricsData) {
		this.lyricsData = lyricsData;
	}

	public void setCompData(byte[] compData) {
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

	public void setMetaYear(Integer metaYear) {
		this.metaYear = metaYear;
	}

	public void setMetaBpm(Integer metaBpm) {
		this.metaBpm = metaBpm;
	}

	public void setMetaAlbumArt(byte[] metaAlbumArt) {
		this.metaAlbumArt = metaAlbumArt;
	}

	public void setContracts(Set<Contracts> contracts) {
		this.contracts = contracts;
	}
}
