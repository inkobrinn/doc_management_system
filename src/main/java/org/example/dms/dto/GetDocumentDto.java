package org.example.dms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class GetDocumentDto {

    private Long id;

    @NotNull
    private String documentCode;

    @NotNull
    private String description;

    private DocumentTypeDto doctype;

    @NotNull
    private LocalDate issueDate;

    @NotNull
    private LocalDate expiryDate;

    private AuthorityDto issuingAuthority;

    private GetUserDto user;
}
