package com.example.soundlifeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
@Data
@SQLDelete(sql = "UPDATE authors SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String image_url;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<SongEntity> songs;

    private boolean deleted = Boolean.FALSE;

}
