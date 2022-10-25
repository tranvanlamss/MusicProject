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
public class UserDto implements Serializable {
    private int id;
    @NotBlank(message = "please input username")
    private String username;
    private String email;
    private String avatar;
    private String banner;
    private String thone;
    private int type;
    private int status;
    @NotBlank(message = "please input password")
    private String password;
    private int role_id;
    private RoleDto role;
    private Date created_at;
    private Date updated_at;
}
