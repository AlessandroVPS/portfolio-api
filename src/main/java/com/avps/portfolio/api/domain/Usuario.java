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
        name           = "usuario"
)
@SequenceGenerator(
        name           = "seq_usuario_id",
        sequenceName   = "portfolio.seq_usuario_id",
        allocationSize = 1,
        schema         = "portfolio"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

}
