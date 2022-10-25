package com.example.soundlifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto implements Serializable {
    private int id;
    private String name;
    private int user_id;
    private UserDto user;
    private String image_url;
    private List<SongDto> songs;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
