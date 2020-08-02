package com.avps.portfolio.api.service;

import com.avps.portfolio.api.adapter.TecnologiaAdapter;
import com.avps.portfolio.api.dto.TecnologiaDTO;
import com.avps.portfolio.api.repository.TecnologiaRepository;
import com.avps.portfolio.api.specification.TecnologiaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository repository;

    public List<TecnologiaDTO> findAll(String nome) {
        return repository.findAll(TecnologiaSpecification.containsNome(nome))
            .stream()
            .map(TecnologiaAdapter::valueOf)
            .collect(Collectors.toList());
    }

    public TecnologiaDTO findById(Long id) throws Exception {
        return ofNullable(repository.findById(id).get())
            .map(TecnologiaAdapter::valueOf)
            .orElseThrow(() -> new Exception("Erro ao buscar tecnologia pelo ID -> ajustar esta exceção"));
    }

    public TecnologiaDTO save(TecnologiaDTO tecnologiaDTO) throws Exception {
        return ofNullable(repository.save(TecnologiaAdapter.toEntity(tecnologiaDTO)))
            .map(TecnologiaAdapter::valueOf)
            .orElseThrow(() -> new Exception("Erro ao gravar a nova tenologia - ajustar exceção"));
    }

}