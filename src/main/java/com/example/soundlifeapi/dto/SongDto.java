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
public class SongDto implements Serializable {
    private int id;
    @NotBlank(message = "please input")
    private String name;
    @NotBlank(message = "please input")
    private String lyrics;

    private String url;

    private int singer_id;
    private SingerDto singer;


    private int author_id;
    private AuthorDto author;

    private int album_id;
    private AlbumDto album;

    private int genre_id;
    private GenreDto genre;

    private int top_id;
    private TopDto top;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
