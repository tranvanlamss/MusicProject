package com.example.soundlifeapi.dto;

import com.example.soundlifeapi.entity.SongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingerDto implements Serializable {
    private int id;
    private String name;
    private String image;
    private boolean deleted;
}
