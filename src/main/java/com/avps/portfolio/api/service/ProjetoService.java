package com.avps.portfolio.api.service;

import com.avps.portfolio.api.adapter.ProjetoAdapter;
import com.avps.portfolio.api.adapter.ProjetoTecnologiaAdapter;
import com.avps.portfolio.api.dto.ProjetoDTO;
import com.avps.portfolio.api.dto.ProjetoTecnologiaDTO;
import com.avps.portfolio.api.repository.ProjetoRepository;
import com.avps.portfolio.api.specification.ProjetoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoTecnologiaService projetoTecnologiaService;

    @Autowired
    private ProjetoRepository repository;

    public List<ProjetoDTO> findAll(String nome) {
        return repository.findAll(ProjetoSpecification.containsNome(nome))
            .stream()
            .map(ProjetoAdapter::valueOf)
            .collect(Collectors.toList());
    }

    public ProjetoDTO save(ProjetoDTO projetoDTO) throws Exception {
        List<ProjetoTecnologiaDTO> listaProjetoTecnologiaDTO = projetoTecnologiaService.saveAll(projetoDTO.getProjetoTecnologias());

        ProjetoDTO projeto = ofNullable(repository.save(ProjetoAdapter.toEntity(projetoDTO)))
            .map(ProjetoAdapter::valueOf)
            .orElseThrow(() -> new Exception("Erro ao gravar novo projeto - ajustar exceção"));

        projeto.setProjetoTecnologias(listaProjetoTecnologiaDTO);
        return projeto;
    }

}
