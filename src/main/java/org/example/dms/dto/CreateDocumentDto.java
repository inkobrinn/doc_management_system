package org.example.dms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateDocumentDto {

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

    private CreateUserDto user;

    public CreateDocumentDto(Long id, String documentCode, String description, LocalDate issueDate, LocalDate expiryDate) {
        this.id = id;
        this.documentCode = documentCode;
        this.description = description;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }
}
