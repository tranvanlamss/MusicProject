package com.example.soundlifeapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@SQLDelete(sql = "UPDATE playlists SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "playlists")
public class PlaylistEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image_url;
    private int user_id;
    @ManyToOne()
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "playlists")
    private List<SongEntity> songs;

    private boolean deleted = Boolean.FALSE;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;


}
