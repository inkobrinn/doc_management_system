package org.example.dms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthorityDto {

    private Integer id;

    @NotNull
    private String authorityName;

}
