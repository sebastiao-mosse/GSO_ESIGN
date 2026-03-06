package com.esign.repository;

import java.util.Optional;

import com.esign.model.TokenInfoEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TokenInfoRepository extends CrudRepository<TokenInfoEntity, Long> {

    public Optional<TokenInfoEntity> findById(Long id);

    public TokenInfoEntity findByClientId(String client_id);

    @Query(value = "select * from token_info where id = 1", nativeQuery = true)
    TokenInfoEntity findByPrimaryId();
}
