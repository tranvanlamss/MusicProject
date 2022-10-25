package com.example.soundlifeapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
@Data
@SQLDelete(sql = "UPDATE mv SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "mv")
public class MvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String thumbnail;
    private String video_url;

    private int user_id;
    @ManyToOne()
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;
    private boolean deleted = Boolean.FALSE;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;
}
