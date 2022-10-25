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
@SQLDelete(sql = "UPDATE songs SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "songs")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int album_id;
    private String lyrics;
    private String url;
    @ManyToOne()
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    private AlbumEntity album;

    private int genre_id;
    @ManyToOne()
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    private int singer_id;
    @ManyToOne()
    @JoinColumn(name = "singer_id", insertable = false, updatable = false)
    private SingerEntity singer;

    private int author_id;
    @ManyToOne()
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private AuthorEntity author;


    private int top_id;
    @ManyToOne()
    @JoinColumn(name = "top_id", insertable = false, updatable = false)
    private TopEntity top;

    @ManyToMany()
    @JoinTable(name = "playlist_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    private List<PlaylistEntity> playlists;


    @JsonIgnore
    @OneToMany(mappedBy = "song")
    private List<LikeSongEntity> likes;


    @JsonIgnore
    @OneToMany(mappedBy = "song")
    private List<CommentSongEntity> comments;

    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;
}
