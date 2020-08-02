package com.avps.portfolio.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
    schema         = "portfolio",
    name           = "tecnologia"
)
@SequenceGenerator(
    name           = "seq_tecnologia_id",
    sequenceName   = "portfolio.seq_tecnologia_id",
    allocationSize = 1,
    schema         = "portfolio"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "versao_maior")
    private Integer versaoMaior;

    @Column(name = "versao_menor")
    private Integer versaoMenor;

}

