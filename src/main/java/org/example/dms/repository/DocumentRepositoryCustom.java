package org.example.dms.repository;

import org.example.dms.entity.Document;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface DocumentRepositoryCustom {

    List<Document> findAll(LocalDate issueDate, LocalDate expiryDate, Long userId, Pageable pageable);
}
