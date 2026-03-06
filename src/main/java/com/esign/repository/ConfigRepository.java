package com.esign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esign.model.ConfigModel;
public interface ConfigRepository extends JpaRepository<ConfigModel, Long> {

}