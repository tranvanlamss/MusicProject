package com.example.soundlifeapi.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
@Data
@SQLDelete(sql = "UPDATE playlist_song SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "playlist_song")
public class PlaylistSongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "song_id", nullable = false)
    private int song_id;

    private int playlist_id;
    @ManyToOne()
    @JoinColumn(name = "playlist_id", insertable = false, updatable = false)
    private PlaylistEntity playlist;

    private boolean deleted = Boolean.FALSE;



}
