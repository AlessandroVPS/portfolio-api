package com.avps.portfolio.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
    schema         = "portfolio",
    name           = "projeto"
)
@SequenceGenerator(
    name           = "seq_projeto_id",
    sequenceName   = "portfolio.seq_projeto_id",
    allocationSize = 1,
    schema         = "portfolio"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "linguagem")
    private String linguagem;

    @Column(name = "link_repositorio")
    private String linkRepositorio;

    @Column(name = "link_documentacao")
    private String linkDocumentacao;

    @Column(name = "link_aplicacao")
    private String linkAplicacao;

    @Column(name = "data_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @Column(name = "data_ultima_atualizacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataUltimaAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario_responsavel", referencedColumnName = "id")
    private Usuario usuarioResponsavel;

    @Column(name = "situacao")
    private String situacao;

    @OneToMany(mappedBy = "projeto")
    private List<ProjetoTecnologia> projetoTecnologias;

}
