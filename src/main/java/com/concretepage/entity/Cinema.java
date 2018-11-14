package com.concretepage.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cinemas")
public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cinema_id")
    private long cinemaId;
	@Column(name="title")
    private String title;
	@Column(name="adresse")
	private String adresse;
	public long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
} 