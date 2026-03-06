package com.esign.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esign.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public Optional<UsuarioModel> findByLogin(String login);

}
