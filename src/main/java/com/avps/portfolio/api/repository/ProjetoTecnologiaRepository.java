package com.avps.portfolio.api.repository;

import com.avps.portfolio.api.domain.ProjetoTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoTecnologiaRepository extends JpaRepository<ProjetoTecnologia, Long> {

}
