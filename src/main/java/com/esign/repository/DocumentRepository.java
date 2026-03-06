package com.esign.repository;

import com.esign.model.DocumentEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends CrudRepository<DocumentEntity, String> {

    @Query(value = "SELECT * FROM documents WHERE document_reference = :reference or transaction_id = :reference", nativeQuery = true)
    DocumentEntity findByReference(@Param("reference") String reference);

}
