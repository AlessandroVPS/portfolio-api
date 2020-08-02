package com.avps.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long      id;
    private String    nome;
    private String    email;
    private String    perfil;
    private String    senha;
    private LocalDate dataCadastro;

}
