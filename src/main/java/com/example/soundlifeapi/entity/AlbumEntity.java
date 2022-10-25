package com.example.soundlifeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@SQLDelete(sql = "UPDATE albums SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "albums")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String album_art;
    private String lyric;
    @JsonIgnore
    @OneToMany(mappedBy = "album")
    private List<SongEntity> songs;
    private boolean deleted = Boolean.FALSE;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;

}
