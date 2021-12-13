package org.example.dms.controller;

import lombok.RequiredArgsConstructor;
import org.example.dms.dto.CreateDocumentDto;
import org.example.dms.dto.GetDocumentDto;
import org.example.dms.service.DocumentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    /**
     * Make a request to receive all documents
     *
     * @param issueDate  document creation date
     * @param expiryDate document expiry date
     * @param userId     identifier user
     * @param page       zero-based page index, must not be negative
     * @param size       the size of the page to be returned, must be greater than 0
     * @return list of documents with pagination, if present, otherwise an empty list
     */
    @GetMapping
    public ResponseEntity<List<GetDocumentDto>> findAllByCriteria(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate issueDate,
                                                                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expiryDate,
                                                                  @RequestParam(required = false) Long userId,
                                                                  @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(documentService.findAll(issueDate, expiryDate, userId, page, size), HttpStatus.OK);
    }

    /**
     * Search document by code
     *
     * @param code document code
     * @return document object, if present, otherwise HttpStatus.NOT_FOUND
     */
    @GetMapping("/{code}")
    public ResponseEntity<Optional<GetDocumentDto>> findDocumentByDocumentCode(@PathVariable String code) {
        Optional<GetDocumentDto> documentDto = documentService.findDocumentByDocumentCode(code);
        return documentDto.map(doc -> new ResponseEntity<>(documentDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Save document object
     *
     * @param createDocumentDto document object to save
     * @return saved document object
     */
    @PostMapping
    public ResponseEntity<CreateDocumentDto> save(@RequestBody CreateDocumentDto createDocumentDto) {
        return new ResponseEntity<>(documentService.save(createDocumentDto), HttpStatus.CREATED);
    }

    /**
     * Update document object
     *
     * @param createDocumentDto document object to update
     * @return updated document object
     */
    @PutMapping
    public ResponseEntity<CreateDocumentDto> update(@RequestBody CreateDocumentDto createDocumentDto) {
        return new ResponseEntity<>(documentService.update(createDocumentDto), HttpStatus.OK);
    }

    /**
     * Delete document object by id
     *
     * @param id to delete a document object
     * @return HttpStatus.NO_CONTENT on successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<GetDocumentDto> delete(@PathVariable Long id) {
        documentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
