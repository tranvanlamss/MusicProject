package com.example.soundlifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentSongDto implements Serializable {
    private int id;
    @NotBlank(message = "please input description")
    private String description;
    private int song_id;
    private SongDto song;
    private int user_id;
    private UserDto user;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
