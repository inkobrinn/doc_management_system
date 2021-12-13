package org.example.dms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DocumentTypeDto {

    private Integer id;

    @NotNull
    private String typeName;


}
