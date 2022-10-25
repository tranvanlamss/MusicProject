package com.example.soundlifeapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Data
@Entity
@Table(name = "singers")
@SQLDelete(sql = "UPDATE singers SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class SingerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "singer")
    private List<SongEntity> songs;
    private boolean deleted = Boolean.FALSE;


}
