package com.esign.model.AgreementAdobe;

import org.springframework.core.io.FileSystemResource;

public class AdobeUploadFile {
    private FileSystemResource file;

    public AdobeUploadFile(){}

    public AdobeUploadFile(FileSystemResource file)
    {
        this.setFile(file);
    }

    public FileSystemResource getFile() {
        return file;
    }

    public void setFile(FileSystemResource file) {
        this.file = file;
    }
}
