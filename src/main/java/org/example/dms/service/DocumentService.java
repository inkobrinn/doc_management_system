package org.example.dms.service;

import org.example.dms.dto.CreateDocumentDto;
import org.example.dms.dto.GetDocumentDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DocumentService {

    List<GetDocumentDto> findAll(LocalDate issueDate, LocalDate expiryDate, Long userId, int page, int size);

    Optional<GetDocumentDto> findDocumentByDocumentCode(String code);

    CreateDocumentDto save(CreateDocumentDto createDocumentDto);

    CreateDocumentDto update(CreateDocumentDto createDocumentDto);

    void delete(Long id);


}
