package com.esign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.esign.model.ConfigModel;
import com.esign.model.UsuarioModel;
import com.esign.repository.ConfigRepository;
import com.esign.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    
    @Autowired
    ConfigRepository configRepository;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>> listarTodos()
    {
        List<ConfigModel> config = new ArrayList<ConfigModel>();
        config = configRepository.findAll();
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }

   
}