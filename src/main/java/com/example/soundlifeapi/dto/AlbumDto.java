package com.example.soundlifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto implements Serializable{
    private int id;
    @NotBlank(message = "please input name")
    private String name;
    @NotBlank(message = "please input album_art")
    private String album_art;
    @NotBlank(message = "please input lyric")
    private String lyric;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
