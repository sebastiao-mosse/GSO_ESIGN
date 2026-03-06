package com.esign.model.AgreementRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformacaoCampos {
    private String fieldName;
    private String defaultValue;

    public InformacaoCampos(String fieldName, String defaultValue)
    {
        this.setFieldName(fieldName);
        this.setDefaultValue(defaultValue);
    }  
    public InformacaoCampos(){}

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

  
}