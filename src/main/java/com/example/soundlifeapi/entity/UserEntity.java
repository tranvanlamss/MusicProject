package com.example.soundlifeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String avatar;
    private String banner;
    private String thone;
    private int type;
    private int status;
    private String password;
    private int role_id;

    @ManyToOne()
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private RoleEntity role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<PlaylistEntity> playlist;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<MvEntity> mv;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<LikeSongEntity> likeSongs;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<LikeMvEntity> likeMvs;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CommentMvEntity> commentMvs;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CommentSongEntity> commentSongs;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;


}
