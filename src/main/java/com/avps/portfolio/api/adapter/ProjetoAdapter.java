package com.avps.portfolio.api.adapter;

import com.avps.portfolio.api.domain.Projeto;
import com.avps.portfolio.api.dto.ProjetoDTO;

import java.util.stream.Collectors;

public class ProjetoAdapter {

    public static Projeto toEntity(ProjetoDTO dto) {
        return Projeto.builder()
            .id                    (dto.getId())
            .nome                  (dto.getNome())
            .descricao             (dto.getDescricao())
            .linguagem             (dto.getLinguagem())
            .linkRepositorio       (dto.getLinkRepositorio())
            .linkDocumentacao      (dto.getLinkDocumentacao())
            .linkAplicacao         (dto.getLinkAplicacao())
            .usuarioResponsavel    (UsuarioAdapter.toEntity(dto.getUsuarioResponsavel()))
            .dataCadastro          (dto.getDataCadastro())
            .dataUltimaAtualizacao (dto.getDataUltimaAtualizacao())
            .situacao              (dto.getSituacao())
            .projetoTecnologias    (dto.getProjetoTecnologias()
                .stream()
                .map(ProjetoTecnologiaAdapter::toEntity)
                .collect(Collectors.toList()))
            .build();
    }

    public static ProjetoDTO valueOf(Projeto entity) {
        return ProjetoDTO.builder()
            .id                    (entity.getId())
            .nome                  (entity.getNome())
            .descricao             (entity.getDescricao())
            .linguagem             (entity.getLinguagem())
            .linkRepositorio       (entity.getLinkRepositorio())
            .linkDocumentacao      (entity.getLinkDocumentacao())
            .linkAplicacao         (entity.getLinkAplicacao())
            .usuarioResponsavel    (UsuarioAdapter.valueOf(entity.getUsuarioResponsavel()))
            .dataCadastro          (entity.getDataCadastro())
            .dataUltimaAtualizacao (entity.getDataUltimaAtualizacao())
            .situacao              (entity.getSituacao())
            .projetoTecnologias    (entity.getProjetoTecnologias()
                .stream()
                .map(ProjetoTecnologiaAdapter::valueOf)
                .collect(Collectors.toList()))
            .build();
    }

}

