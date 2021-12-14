package org.example.dms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "document")
@SQLDelete(sql = "UPDATE document SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "document_code")
    private String documentCode;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "doctype_id")
    private DocumentType doctype;

    @NotNull
    @Column(name = "issue_date")
    private LocalDate issueDate;

    @NotNull
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority issuingAuthority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean deleted = Boolean.FALSE;

    public Document(Long id, String documentCode, String description, LocalDate issueDate, LocalDate expiryDate) {
        this.id = id;
        this.documentCode = documentCode;
        this.description = description;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }
}

