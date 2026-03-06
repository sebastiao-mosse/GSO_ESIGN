package com.esign.repository;
import java.util.List;

import com.esign.model.UserEntity;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository <UserEntity, Long> {
    
    List<UserEntity> findAll();
}
