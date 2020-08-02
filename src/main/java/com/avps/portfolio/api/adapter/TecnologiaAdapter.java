package com.avps.portfolio.api.adapter;

import com.avps.portfolio.api.domain.Tecnologia;
import com.avps.portfolio.api.dto.TecnologiaDTO;

public class TecnologiaAdapter {

    public static Tecnologia toEntity(TecnologiaDTO dto) {
        return Tecnologia.builder()
            .id          (dto.getId())
            .nome        (dto.getNome())
            .descricao   (dto.getDescricao())
            .versaoMaior (dto.getVersaoMaior())
            .versaoMenor (dto.getVersaoMenor())
            .build();
    }

    public static TecnologiaDTO valueOf(Tecnologia entity) {
        return TecnologiaDTO.builder()
            .id          (entity.getId())
            .nome        (entity.getNome())
            .descricao   (entity.getDescricao())
            .versaoMaior (entity.getVersaoMaior())
            .versaoMenor (entity.getVersaoMenor())
            .build();
    }

}
