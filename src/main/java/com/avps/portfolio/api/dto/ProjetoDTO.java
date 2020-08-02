package com.avps.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {

    private Long       id;
    private String     nome;
    private String     descricao;
    private String     linguagem;
    private String     linkRepositorio;
    private String     linkDocumentacao;
    private String     linkAplicacao;
    private LocalDate  dataCadastro;
    private LocalDate  dataUltimaAtualizacao;
    private UsuarioDTO usuarioResponsavel;
    private String     situacao;

    private List<ProjetoTecnologiaDTO> projetoTecnologias;

}
