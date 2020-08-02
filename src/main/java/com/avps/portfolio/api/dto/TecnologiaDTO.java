package com.avps.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TecnologiaDTO {

    private Long    id;
    private String  nome;
    private String  descricao;
    private Integer versaoMaior;
    private Integer versaoMenor;

}
