package org.example.dms.service.imlp;

import lombok.RequiredArgsConstructor;
import org.example.dms.dto.CreateDocumentDto;
import org.example.dms.dto.GetDocumentDto;
import org.example.dms.entity.Document;
import org.example.dms.mapper.DocumentMapper;
import org.example.dms.repository.DocumentRepository;
import org.example.dms.service.DocumentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    /**
     * Make a request to receive all documents
     *
     * @param issueDate  document creation date
     * @param expiryDate document expiry date
     * @param userId     identifier user
     * @param page       zero-based page index, must not be negative
     * @param size       the size of the page to be returned, must be greater than 0
     * @return list of documents
     */
    @Override
    public List<GetDocumentDto> findAll(LocalDate issueDate, LocalDate expiryDate, Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return documentRepository.findAll(issueDate, expiryDate, userId, pageRequest).stream()
                .map(documentMapper::getEntityToDto).collect(Collectors.toList());
    }

    /**
     * Search document by code
     *
     * @param code document code
     * @return document object
     */
    @Override
    public Optional<GetDocumentDto> findDocumentByDocumentCode(String code) {
        return documentRepository.findDocumentByDocumentCode(code).map(documentMapper::getEntityToDto);
    }

    /**
     * Save document object
     *
     * @param createDocumentDto document object to save
     * @return saved document object
     */
    @Override
    public CreateDocumentDto save(CreateDocumentDto createDocumentDto) {
        Document document = documentRepository.save(documentMapper.createDtoToEntity(createDocumentDto));
        return documentMapper.createEntityToDto(document);
    }

    /**
     * Update document object
     *
     * @param createDocumentDto document object to update
     * @return updated document object
     */
    @Override
    public CreateDocumentDto update(CreateDocumentDto createDocumentDto) {
        Document document = documentRepository.save(documentMapper.createDtoToEntity(createDocumentDto));
        return documentMapper.createEntityToDto(document);
    }

    /**
     * Delete document object by id
     *
     * @param id to delete a document object
     */
    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
