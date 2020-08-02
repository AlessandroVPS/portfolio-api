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
public class ProjetoTecnologiaDTO {

    private Long          id;
    private ProjetoDTO    projeto;
    private TecnologiaDTO tecnologia;
    private LocalDate     dataInclusao;
    private LocalDate     dataExclusao;

}
