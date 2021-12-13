package org.example.dms.repository;

import org.example.dms.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long>, DocumentRepositoryCustom {

    Optional<Document> findDocumentByDocumentCode(String code);
}
