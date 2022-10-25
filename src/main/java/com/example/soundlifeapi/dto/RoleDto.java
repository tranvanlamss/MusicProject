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
public class RoleDto implements Serializable {
    private int id;
    @NotBlank(message = "please input name role")
    private String name;
    private Date created_at;
    private Date updated_at;
}
