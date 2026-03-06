package com.esign.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.util.stream.*;
import java.nio.file.Path;

public interface FilesStorageService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

}
