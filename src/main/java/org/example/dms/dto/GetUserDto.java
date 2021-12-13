package org.example.dms.dto;

import lombok.Data;
import org.example.dms.entity.Role;

import javax.validation.constraints.NotNull;

@Data
public class GetUserDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Role role;

    @NotNull
    private String email;
}
