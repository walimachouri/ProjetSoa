package com.concretepage.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="movies")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="movie_id")
    private long movieId;
    @Column(name="title")
    private String title;
    @Column(name="dateProduction")
    private String dateProduction;
    public long getMovieId() {
        return movieId;
    }
    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getdateProduction() {
        return dateProduction;
    }
    public void setdateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }
}