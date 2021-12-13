package org.example.dms.mapper;

import org.example.dms.dto.CreateDocumentDto;
import org.example.dms.dto.GetDocumentDto;
import org.example.dms.entity.Document;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DocumentMapper {

    /**
     * converting object Document to object GetDocumentDto
     *
     * @param document convertible object
     * @return mapped object
     */
    GetDocumentDto getEntityToDto(Document document);

    /**
     * converting object CreateDocumentDto to object Document
     *
     * @param createDocumentDto convertible object
     * @return mapped object
     */
    Document createDtoToEntity(CreateDocumentDto createDocumentDto);

    /**
     * converting object Document to object CreateDocumentDto
     *
     * @param document convertible object
     * @return mapped object
     */
    CreateDocumentDto createEntityToDto(Document document);


}
