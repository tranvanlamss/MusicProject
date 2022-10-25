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
public class CommentMvDto implements Serializable {
    private int id;
    @NotBlank(message = "please input description")
    private String description;
    private int mv_id;
    private MvDto mv;
    private int user_id;
    private UserDto userDto;
    private boolean deleted;
    private Date created_at;
    private Date updated_at;
}
