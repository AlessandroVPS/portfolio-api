package com.avps.portfolio.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    schema         = "portfolio",
    name           = "projeto_tecnologia"
)
@SequenceGenerator(
    name           = "seq_projeto_tecnologia_id",
    sequenceName   = "portfolio.seq_projeto_tecnologia_id",
    allocationSize = 1,
    schema         = "portfolio"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "id_tecnologia", referencedColumnName = "id")
    private Tecnologia tecnologia;

    @Column(name = "data_inclusao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInclusao;

    @Column(name = "data_exclusao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataExclusao;

}
