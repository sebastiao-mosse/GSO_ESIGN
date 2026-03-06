package com.esign.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Config")
public class ConfigModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token_senha;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token_expiracao;

}
