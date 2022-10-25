package com.example.soundlifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenreDto implements Serializable {
    private int id;
    private String name;
    private String image_url;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
