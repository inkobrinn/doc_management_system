package org.example.dms.repository;

import lombok.RequiredArgsConstructor;
import org.example.dms.entity.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DocumentRepositoryImpl implements DocumentRepositoryCustom {

    private final EntityManager entityManager;


    @Override
    public List<Document> findAll(LocalDate issueDate, LocalDate expiryDate, Long userId, Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> criteria = cb.createQuery(Document.class);
        Root<Document> document = criteria.from(Document.class);
        List<Predicate> predicates = new ArrayList<>();

        if (issueDate != null) {
            predicates.add(cb.equal(document.get("issueDate"), issueDate));
        }
        if (expiryDate != null) {
            predicates.add(cb.equal(document.get("expiryDate"), expiryDate));
        }
        if (userId != null) {
            predicates.add(cb.equal(document.get("user"), userId));
        }

        criteria.select(document).where(
                predicates.toArray(Predicate[]::new)
        ).orderBy(cb.desc(document.get("issueDate")));

        TypedQuery<Document> typedQuery = entityManager.createQuery(criteria);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());
        return typedQuery.getResultList();
    }
}
