package com.eplusing.demo1200.prospring5.ch7.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author eplusing
 * @date 2020/5/8
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {
    private Long id;
    private String title;
    private Date releaseDate;
    private int version;
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    public Singer getSinger() {
        return singer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    public Date getReleaseDate() {
        return releaseDate;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", version=" + version +
                '}';
    }
}
