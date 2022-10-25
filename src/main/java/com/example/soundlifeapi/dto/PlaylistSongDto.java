package com.example.soundlifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistSongDto implements Serializable {
    private int id;
    private int song_id;
    private int playlist_id;
    private PlaylistDto playlist;
    private boolean deleted;
}
