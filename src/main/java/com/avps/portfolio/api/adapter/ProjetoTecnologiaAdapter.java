package com.avps.portfolio.api.adapter;

import com.avps.portfolio.api.domain.ProjetoTecnologia;
import com.avps.portfolio.api.dto.ProjetoTecnologiaDTO;

public class ProjetoTecnologiaAdapter {

    public static ProjetoTecnologia toEntity(ProjetoTecnologiaDTO dto) {
        return ProjetoTecnologia.builder()
            .id           (dto.getId())
            .projeto      (ProjetoAdapter.toEntity(dto.getProjeto()))
            .tecnologia   (TecnologiaAdapter.toEntity(dto.getTecnologia()))
            .dataInclusao (dto.getDataInclusao())
            .dataExclusao (dto.getDataExclusao())
            .build();
    }

    public static ProjetoTecnologiaDTO valueOf(ProjetoTecnologia entity) {
        return ProjetoTecnologiaDTO.builder()
            .id           (entity.getId())
            .projeto      (ProjetoAdapter.valueOf(entity.getProjeto()))
            .tecnologia   (TecnologiaAdapter.valueOf(entity.getTecnologia()))
            .dataInclusao (entity.getDataInclusao())
            .dataExclusao (entity.getDataExclusao())
            .build();
    }

}
