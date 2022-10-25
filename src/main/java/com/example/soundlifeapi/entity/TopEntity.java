package com.example.soundlifeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "top")
@SQLDelete(sql = "UPDATE top SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class TopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "top")
    private List<SongEntity> songs;

    private boolean deleted = Boolean.FALSE;


}
