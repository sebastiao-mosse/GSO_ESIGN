package com.esign.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

//import com.esign.configuration.Configs;
//import com.esign.util.Tools;

@Service
public class StorageService implements FilesStorageService, EnvironmentAware {
    @Autowired
    private Environment env;

    

    @Override
    public void setEnvironment(final Environment environment) {
        this.env = environment;
    }

    private final Path getRoot()
    {
        return Paths.get(env.getProperty("configs.esign.uploads") + "unsigned");
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(this.getRoot());
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.getRoot().resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = this.getRoot().resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(this.getRoot().toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.getRoot(), 1).filter(path -> !path.equals(this.getRoot())).map(this.getRoot()::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
