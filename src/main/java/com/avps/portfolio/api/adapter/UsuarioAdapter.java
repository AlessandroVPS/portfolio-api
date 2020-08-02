package com.avps.portfolio.api.adapter;

import com.avps.portfolio.api.domain.Usuario;
import com.avps.portfolio.api.dto.UsuarioDTO;

public class UsuarioAdapter {

    public static Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
            .id           (dto.getId())
            .nome         (dto.getNome())
            .email        (dto.getEmail())
            .perfil       (dto.getPerfil())
            .senha        (dto.getSenha())
            .dataCadastro (dto.getDataCadastro())
            .build();
    }

    public static UsuarioDTO valueOf(Usuario entity) {
        return UsuarioDTO.builder()
            .id           (entity.getId())
            .nome         (entity.getNome())
            .email        (entity.getEmail())
            .perfil       (entity.getPerfil())
            .dataCadastro (entity.getDataCadastro())
            .build();
    }

}
