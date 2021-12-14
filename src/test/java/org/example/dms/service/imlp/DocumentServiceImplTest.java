package org.example.dms.service.imlp;


import org.example.dms.dto.CreateDocumentDto;
import org.example.dms.dto.GetDocumentDto;
import org.example.dms.entity.Document;
import org.example.dms.mapper.DocumentMapper;
import org.example.dms.repository.DocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentServiceImplTest {

    public static final long DOCUMENT1_ID = 1L;
    public static final String DOCUMENT1_CODE = "1121121";
    public static final String DOCUMENT1_DESCRIPTION = "DescriptionOne";
    public static final LocalDate DOCUMENT1_ISSUE_DATE = LocalDate.of(2012, 1, 15);
    public static final LocalDate DOCUMENT1_EXPIRY_DATE = LocalDate.of(2016, 2, 12);
    public static final long DOCUMENT2_ID = 2L;
    public static final String DOCUMENT2_CODE = "2232232";
    public static final String DOCUMENT2_DESCRIPTION = "DescriptionTwo";
    public static final LocalDate DOCUMENT2_ISSUE_DATE = LocalDate.of(2013, 2, 25);
    public static final LocalDate DOCUMENT2_EXPIRY_DATE = LocalDate.of(2017, 5, 22);

    private Document document1;
    private Document document2;

    private GetDocumentDto getDocumentDto1;
    private GetDocumentDto getDocumentDto2;

    private CreateDocumentDto createDocumentDto1;
    private CreateDocumentDto createDocumentDto2;

    private List<Document> documentList;


    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private DocumentMapper documentMapper;

    @InjectMocks
    private DocumentServiceImpl documentService;

    @BeforeEach
    void prepare() {
        document1 = new Document(DOCUMENT1_ID, DOCUMENT1_CODE, DOCUMENT1_DESCRIPTION, DOCUMENT1_ISSUE_DATE, DOCUMENT1_EXPIRY_DATE);
        document2 = new Document(DOCUMENT2_ID, DOCUMENT2_CODE, DOCUMENT2_DESCRIPTION, DOCUMENT2_ISSUE_DATE, DOCUMENT2_EXPIRY_DATE);

        getDocumentDto1 = new GetDocumentDto(DOCUMENT1_ID, DOCUMENT1_CODE, DOCUMENT1_DESCRIPTION, DOCUMENT1_ISSUE_DATE, DOCUMENT1_EXPIRY_DATE);
        getDocumentDto2 = new GetDocumentDto(DOCUMENT2_ID, DOCUMENT2_CODE, DOCUMENT2_DESCRIPTION, DOCUMENT2_ISSUE_DATE, DOCUMENT2_EXPIRY_DATE);

        createDocumentDto1 = new CreateDocumentDto(DOCUMENT1_ID, DOCUMENT1_CODE, DOCUMENT1_DESCRIPTION, DOCUMENT1_ISSUE_DATE, DOCUMENT1_EXPIRY_DATE);
        createDocumentDto2 = new CreateDocumentDto(DOCUMENT2_ID, DOCUMENT2_CODE, DOCUMENT2_DESCRIPTION, DOCUMENT2_ISSUE_DATE, DOCUMENT2_EXPIRY_DATE);

        documentList = Arrays.asList(document1, document2);
    }


    @Test
    void testFindDocumentByDocumentCode() {
        when(documentRepository.findDocumentByDocumentCode(DOCUMENT1_CODE)).thenReturn(Optional.of(document1));
        when(documentMapper.getEntityToDto(document1)).thenReturn(getDocumentDto1);
        Optional<GetDocumentDto> getDocumentDto = documentService.findDocumentByDocumentCode(DOCUMENT1_CODE);
        verify(documentRepository, times(1)).findDocumentByDocumentCode(DOCUMENT1_CODE);
        assertNotNull(getDocumentDto);

    }

    @Test
    void testSave() {
        when(documentRepository.save(documentMapper.createDtoToEntity(createDocumentDto1))).thenReturn(document1);
        documentService.save(documentMapper.createEntityToDto(document1));
        verify(documentRepository, times(1)).save(documentMapper.createDtoToEntity(createDocumentDto1));
    }

    @Test
    void testUpdate() {
        when(documentRepository.save(documentMapper.createDtoToEntity(createDocumentDto1))).thenReturn(document1);
        documentService.update(documentMapper.createEntityToDto(document1));
        verify(documentRepository, times(1)).save(documentMapper.createDtoToEntity(createDocumentDto1));
    }


    @Test
    void testDelete() {
        documentService.delete(DOCUMENT1_ID);
        verify(documentRepository, times(1)).deleteById(DOCUMENT1_ID);

    }

}