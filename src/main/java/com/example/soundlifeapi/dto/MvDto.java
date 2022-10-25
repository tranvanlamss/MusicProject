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
public class MvDto implements Serializable {
    private int id;
    @NotBlank(message = "please input name")
    private String name;
    @NotBlank(message = "please input thumbnail")
    private String thumbnail;
    @NotBlank(message = "please input url video")
    private String video_url;
    private int user_id;
    private UserDto user;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
