package com.avps.portfolio.api.service;

import com.avps.portfolio.api.adapter.ProjetoTecnologiaAdapter;
import com.avps.portfolio.api.domain.ProjetoTecnologia;
import com.avps.portfolio.api.dto.ProjetoTecnologiaDTO;
import com.avps.portfolio.api.repository.ProjetoTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ProjetoTecnologiaService {

    @Autowired
    private ProjetoTecnologiaRepository repository;

    public ProjetoTecnologiaDTO save(ProjetoTecnologiaDTO projetoTecnologiaDTO) throws Exception {
        return ofNullable(repository.save(ProjetoTecnologiaAdapter.toEntity(projetoTecnologiaDTO)))
            .map(ProjetoTecnologiaAdapter::valueOf)
            .orElseThrow(() -> new Exception("Erro ao gravar a tecnologia do projeto - ajustar exceção"));
    }

    public List<ProjetoTecnologiaDTO> saveAll(List<ProjetoTecnologiaDTO> listaProjetoTecnologiaDTO) {
        List<ProjetoTecnologia> listaProjetoTecnologias = listaProjetoTecnologiaDTO
            .stream()
            .map(ProjetoTecnologiaAdapter::toEntity)
            .collect(Collectors.toList());

        return repository.saveAll(listaProjetoTecnologias)
            .stream()
            .map(ProjetoTecnologiaAdapter::valueOf)
            .collect(Collectors.toList());
    }
}
