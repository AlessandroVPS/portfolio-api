package com.avps.portfolio.api.specification;

import com.avps.portfolio.api.domain.Tecnologia;
import org.springframework.data.jpa.domain.Specification;

import static java.util.Objects.isNull;

public class TecnologiaSpecification {

    public static Specification<Tecnologia> containsNome(String nome) {
        if(isNull(nome)) return null;
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%".concat(nome.toUpperCase()).concat("%"));
    }
}
