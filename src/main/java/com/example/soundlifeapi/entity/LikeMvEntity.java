package com.example.soundlifeapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
@Data
@SQLDelete(sql = "UPDATE like_mv SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "like_mv")
public class LikeMvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int like_mv;
    private int mv_id;

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
